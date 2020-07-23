package javaCore.GUI.swing.dataExchange;

/**
 * Пользователь имеет имя и пароль. Для безопасности пароль хранится в виде массива символов
 *
 * @author Ross Khapilov
 * @version 1.0 created on 02.05.2018
 */
public class User {
    private String name;
    private char[] password;

    public User(String aName, char[] aPassword) {
        name = aName;
        password = aPassword;
    }

    public String getName() {
        return name;
    }

    public char[] getPassword() {
        return password;
    }

    public void setName(String aName) {
        name = aName;
    }

    public void setPassword(char[] aPassword) {
        password = aPassword;
    }
}
