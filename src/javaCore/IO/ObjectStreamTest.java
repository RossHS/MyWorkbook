package javaCore.IO;

import java.io.*;

/**
 * @author Ross Khapilov
 * @version 1.0 05.01.2019
 */
public class ObjectStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Man[] men = new Man[3];
        men[0] = new Man("Carl", 28, 20_000);
        men[1] = new Man("Harry M", 38, 50_000);
        men[2] = new Man("Tony", 10, 100);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D:\\prog\\MyProjects\\Learning\\src\\javaCore\\IO\\files\\ObjectStreamTest.dat"))) {
            out.writeObject(men);
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:\\prog\\MyProjects\\Learning\\src\\javaCore\\IO\\files\\ObjectStreamTest.dat"))) {
            Man[] newMen = (Man[]) in.readObject();
            for (Man m : newMen)
                System.out.println(m);
        }
    }
}
