package exercises.forshau;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * @author Ross Khapilov
 * @version 1.0 11.11.2018
 */
public class decode {
    public static void main(String[] args) throws Exception {
//        int[] a = {0xABCE, 0xA511, 0xA522, 0xA533, 0xA544, 0xA555, 0xA566, 0xA577, 0xA588, 0xA599, 0xA5AA, 0xA5BB, 0xA5CC};
//        for (int i = 0; i < a.length; i++) {
//            System.out.println((char) a[i]);
//        }
        mains("D:\\prog\\MyProjects\\Learning\\src\\exercises\\forshau\\20180314_11h_40m_57s_SINS2000_Test.nav");
//        String s  = "р.ѓ";
//        for (int i = 0; i < s.length(); i++) {
//            System.out.println(Integer.toHexString(s.charAt(i)));
//        }
        int[] a = {16, 32, 32, 32, 32, 32, 32, 64, 16, 32, 32, 16};
        int stream = Arrays.stream(a).map(v -> v / 8).sum();
        System.out.println(stream);
//        littleEndian("D:\\prog\\MyProjects\\Learning\\src\\exercises\\forshau\\20180314_11h_40m_57s_SINS2000_Test.txt");
    }

    private static void littleEndian(String filePath) throws FileNotFoundException {
        RandomAccessFile accessFile = new RandomAccessFile(filePath,"r");

    }

    public static void mains(String argv) throws Exception {
        FileInputStream fin = new FileInputStream(argv);
//        RandomAccessFile accessFile = new RandomAccessFile("D:\\prog\\MyProjects\\Learning\\src\\exercises\\forshau\\20180314_11h_40m_57s_SINS2000_Test.txt","rw");
        int len;
        byte data[] = new byte[16];
        int counterABCE = 0;
        int counter11 = 0;
        int counter33 = 0;
        int counter44 = 0;
        int counter55 = 0;
        int counterAA = 0;
        boolean A5 = false;
//         Read bytes until EOF is encountered.
//        int counter = 0;
//        do {
//            len = fin.read(data);
//            for (int j = 0; j < len; j++) {
//
//                String s = String.format("%02X ", data[j]);
//                System.out.print(s);
//            }
//            counter++;
//        } while (len != -1);


        int g;
        byte[] bytes = fin.readAllBytes();
        System.out.println(bytes[0]);
        System.out.println(String.format("%02X", bytes[0]));
        for (int i = 2; i < bytes.length; i++) {
            String s1 = String.format("%02X", bytes[i - 2]);
            String s2 = String.format("%02X", bytes[i - 1]);
            String s3 = String.format("%02X", bytes[i]);
            if ((s1.equals("A5") && s2.equals("AA")) || (s1.equals("A5") && s2.equals("00") && s3.equals("AA")))
                counterAA++;
            else if ((s1.equals("A5") && s2.equals("55")) || (s1.equals("A5") && s2.equals("00") && s3.equals("55")))
                counter55++;
            else if ((s1.equals("11") && s2.equals("A5")))
                counter11++;
            else if ((s1.equals("A5") && s2.equals("44")) || (s1.equals("A5") && s2.equals("00") && s3.equals("44")))
                counter44++;
//            else if ((s1.equals("A5") && s2.equals("33")) || (s1.equals("A5") && s2.equals("00") && s3.equals("33")))
//                counter33++;
            else if ((s1.equals("33") && s2.equals("A5")))
                counter33++;
            else if (s1.equals("CE") && s2.equals("AB")) counterABCE++;
        }
        System.out.println(counterABCE + " " + counter11 + " " + counter33 + " " + counter44 + " " + counter55 + " " + counterAA);
    }
}

