package javaCore.security.encryption;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * способ шифрования, в котором для шифрования и расшифровывания применяется один и тот же криптографический ключ.
 * До изобретения схемы асимметричного шифрования единственным существовавшим способом являлось симметричное шифрование.
 * Ключ алгоритма должен сохраняться в секрете обеими сторонами. Алгоритм шифрования выбирается сторонами до начала
 * обмена сообщениями.
 *
 * @author Ross Khapilov
 * @version 1.0 09.07.2018
 */
public class SymmetricKeyAlgorithm {
    public static void main(String[] args) {
        //Главный супер класс для шифрования, в качестве аргумента передаем названия шифра
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("AES");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
        //Как только объект, реализующий алгоритм шифрования, будет создан, его нужно инициализировать, указав режим и
        //ключ шифрования, т.е. установив параметры mode и key следующим образом:
        SecretKeySpec key = new SecretKeySpec("Two One Nine Two".getBytes(), "AES");
        System.out.println("Key string =" + Arrays.toString("Two One Nine Two".getBytes()));
        try {
            assert cipher != null;
            cipher.init(Cipher.ENCRYPT_MODE, key);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        //Строка для шифрования
        String s = "Hel\nlo World!";
        System.out.println(s);
        System.out.println("До шифрования " + Arrays.toString(s.getBytes()));
        String cripted = "";
        //По завершении следует вызвать метод doFinal() один раз. Вызывать метод doFinal () требуется для того, чтобы
        //заполнить завершающий блок данных.
        byte[] bytes = new byte[0];
        try {
            bytes = cipher.doFinal(s.getBytes());
            cripted = new String(bytes);
            System.out.println("Зашифрованная строка в байтах" + Arrays.toString(bytes));
            System.out.println("После шифрования " + cripted);
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
        System.out.println("\n");
        //расшифруем сообщение
        Cipher decriptCipher = null;
        try {
            decriptCipher = Cipher.getInstance("AES");
            decriptCipher.init(Cipher.DECRYPT_MODE, key);
            byte[] bytesDec = decriptCipher.doFinal(bytes);
            System.out.println("После расшифровки " + Arrays.toString(bytesDec));
            System.out.println(new String(bytesDec));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
//        Для шифрования требуется сгенерировать ключ. Каждый алгоритм шифрования предусматривает свой формат для
//        ключей, но самое главное, чтобы их генерирование выполнялось произвольным образом. Чтобы получить
//        сгенерированный совершенно произвольно ключ, требуется выполнить три действия.
//        1. Создать объект типа KeyGenerator.
//        2. Инициализировать генератор случайных чисел. Если блок шифра имеет переменную длину, необходимо также
//           указать желаемую длину блока.
//        3. Вызвать метод generateKey ().
        try {
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            SecureRandom random = new SecureRandom();
            keygen.init(random);
            SecretKey keyRand = keygen.generateKey();
            for (byte v: keyRand.getEncoded())
                System.out.print(v);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
