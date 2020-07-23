package javaCore.IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author Ross Khapilov
 * @version 1.0 05.01.2019
 */
public class TextFileTest {
    public static void main(String[] args) throws IOException {
        Man[] men = new Man[3];
        men[0] = new Man("Carl", 28, 20_000);
        men[1] = new Man("Harry M", 38, 50_000);
        men[2] = new Man("Tony", 10, 100);
        //сохранить записи обо всех сотрудниках в файле TextFileTest.dat
        try (PrintWriter out = new PrintWriter("D:\\prog\\MyProjects\\Learning\\src\\javaCore\\IO\\files\\TextFileTest.dat", StandardCharsets.UTF_8)) {
            writeData(men, out);
        }

        //извлечь все записи в новый массив
        try (Scanner in = new Scanner(new FileInputStream("D:\\prog\\MyProjects\\Learning\\src\\javaCore\\IO\\files\\TextFileTest.dat"), StandardCharsets.UTF_8)) {
            Man[] newMen = readData(in);
            //вывести вновь прочитанные записи в консоль
            for (Man e : newMen)
                System.out.println(e);
        }
    }

    /**
     * Записывает данный всех объектов в файл из массива в поток записи выводимых данных
     *
     * @param men Массив записей объектов
     * @param out Поток записи выводимых данных
     */
    private static void writeData(Man[] men, PrintWriter out) throws IOException {
        //запись количества элементов
        out.println(men.length);

        for (Man m : men)
            writeMan(out, m);
    }

    /**
     * Читает записи об объектах из потока сканирования в массив
     *
     * @param in Поток сканирования вводимых данных
     * @return Массив записей о сотрудниках
     */
    private static Man[] readData(Scanner in) {
        // извлечь размер массива
        int n = in.nextInt();
        in.nextLine();

        Man[] men = new Man[n];
        for (int i = 0; i < n; i++) {
            men[i] = readMan(in);
        }
        return men;
    }

    /**
     * Направляет данные в поток выводимых данных
     *
     * @param out Поток записи выводимых данных
     * @param m   Объект для вывода
     */
    public static void writeMan(PrintWriter out, Man m) {
        out.println(m.getName() + "|" + m.getAge() + "|" + m.getSalary());
    }

    /**
     * Считывает данные из буферизованного потока чтения вводимых данных
     * @param in Поток чтения/сканирования вводимых данных
     */
    public static Man readMan(Scanner in) {
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        int age = Integer.parseInt(tokens[1]);
        int salary = Integer.parseInt(tokens[2]);
        return new Man(name, age, salary);
    }

}
