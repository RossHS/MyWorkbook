package javaCore.SQL;

import java.sql.*;

/**
 * Уровни изоляции транзакций- предостережение от различного рода проблем при работе с транзакциями
 * (т.е. перечнем команд, которые обязательно должны выполниться полностью, иначе должен быть произведен откат)
 * Isolation Level                   Transactions	Dirty Reads	    Non-Repeatable Reads	Phantom Reads
 * TRANSACTION_NONE	                Not supported	Not applicable	Not applicable	        Not applicable
 * TRANSACTION_READ_COMMITTED	    Supported	    Prevented	    Allowed	                Allowed
 * TRANSACTION_READ_UNCOMMITTED	    Supported	    Allowed	        Allowed	                Allowed
 * TRANSACTION_REPEATABLE_READ	    Supported	    Prevented	    Prevented	            Allowed
 * TRANSACTION_SERIALIZABLE	        Supported	    Prevented	    Prevented	            Prevented
 * <p>
 * Dirty Reads -  чтение данных, добавленных или изменённых транзакцией, которая впоследствии не подтвердится (откатится);
 * Non-Repeatable Reads - при повторном чтении в рамках одной транзакции ранее прочитанные данные оказываются изменёнными;
 * Phantom Reads - одна транзакция в ходе своего выполнения несколько раз выбирает множество строк по одним и
 * тем же критериям. Другая транзакция в интервалах между этими выборками добавляет или удаляет строки или изменяет
 * столбцы некоторых строк, используемых в критериях выборки первой транзакции, и успешно заканчивается.
 * В результате получится, что одни и те же выборки в первой транзакции дают разные множества строк.
 *
 * @author Ross Khapilov
 * @version 1.0 25.02.2019
 */
public class TransactionIsolationLevel {
    static String username = "root";
    static String password = "pass";
    static String connectionURL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useSSL=false";

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        dirtyReadsExample();
        nonRepeatableReadsExample();
        phantomReadsExample();
    }

    //***************************************************************************************************************//

    /**
     * Пример проблемы Dirty Reads и ее устранение. По дефолту она не возникает.
     */
    private static void dirtyReadsExample() {
        try (Connection connection = DriverManager.getConnection(connectionURL, username, password);
             Statement stat = connection.createStatement()) {
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            stat.execute("UPDATE test.books SET name = 'Random book' WHERE id = 3");

            new DirtyReadClass().start();
            Thread.sleep(2000);

            connection.rollback();

            ResultSet resultSet = stat.executeQuery("SELECT * FROM  test.books WHERE id = 3");
            System.out.println("Результаты после отмены транзакции в первом потоке");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + "\t" + resultSet.getString("name"));
            }

        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class DirtyReadClass extends Thread {
        @Override
        public void run() {
            try (Connection connection = DriverManager.getConnection(connectionURL, username, password);
                 Statement stat = connection.createStatement()) {
                connection.setAutoCommit(false);

                System.out.println("Для появления ошибки следует установить connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);\n" +
                        "иначе ошибка устранится автоматически");
                connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);

                System.out.println("Должны получить Python book т.к. транзакция не была закончена");
                ResultSet resultSet = stat.executeQuery("SELECT * FROM test.books where id = 3");
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("id") + "\t" + resultSet.getString("name"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //***************************************************************************************************************//

    /**
     * Пример проблемы nonRepeatableReads и ее устранение. По дефолту она не возникает.
     */
    private static void nonRepeatableReadsExample() {
        try (Connection conn = DriverManager.getConnection(connectionURL, username, password);
             Statement stat = conn.createStatement()) {
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            System.out.println("-----------------------");
            System.out.println("По дефолту данной ошибки не будет, по правилам- в рамках данной\nтранзакции значение должно остаться без изменения");
            ResultSet res1 = stat.executeQuery("SELECT * FROM  test.books WHERE id = 10");
            while (res1.next()) {
                System.out.println(res1.getInt("id") + "\t" + res1.getString("name"));
            }
            new NonRepeatableReadsClass().start();
            Thread.sleep(2000);

            ResultSet res2 = stat.executeQuery("SELECT * FROM test.books WHERE id = 10");
            while (res2.next()) {
                System.out.println(res2.getInt("id") + "\t" + res2.getString("name"));
            }
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class NonRepeatableReadsClass extends Thread {
        @Override
        public void run() {
            try (Connection conn = DriverManager.getConnection(connectionURL, username, password);
                 Statement stat = conn.createStatement()) {
                conn.setAutoCommit(false);
                conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                stat.execute("UPDATE test.books SET name = 'A SQL Book " + (int) (Math.random() * 10) + "' WHERE id = 10");
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //***************************************************************************************************************//

    /**
     * Пример проблемы phantomReads и ее устранение. По дефолту она не возникает. Проблема очень похожа на пред пример
     */
    private static void phantomReadsExample() {
        try (Connection conn = DriverManager.getConnection(connectionURL, username, password);
             Statement stat = conn.createStatement()) {
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            System.out.println("---------------------------");
            System.out.println("Должно получиться одинаковое кол-во записей в рамках одной транзакции");
            ResultSet res1 = stat.executeQuery("SELECT COUNT(*) FROM test.books");
            while (res1.next()) {
                System.out.println("Количество записей в таблице = " + res1.getInt(1));
            }

            new PhantomReadsClass().start();
            Thread.sleep(2000);

            ResultSet res2 = stat.executeQuery("SELECT COUNT(*) FROM test.books");
            while (res2.next()) {
                System.out.println("Количество записей в таблице = " + res2.getInt(1));
            }


        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class PhantomReadsClass extends Thread {
        @Override
        public void run() {
            try (Connection conn = DriverManager.getConnection(connectionURL, username, password);
                 Statement stat = conn.createStatement()) {
                conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                stat.executeUpdate("INSERT INTO test.books (name) VALUES ('Java random book " + (int) (Math.random() * 20) + " edition')");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
