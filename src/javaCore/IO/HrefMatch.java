package javaCore.IO;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * В этой программе отображаются все веб-адреса на веб-странице
 * путем сопоставления с регулярным выражением, описывающим
 * дескриптор <а href=...> разметки в коде HTML.
 * Для запуска программы следует ввести:
 * java match. HrefMatch веб-адрес
 *
 * @author Ross Khapilov
 * @version 1.0 08.01.2019
 */
public class HrefMatch {
    public static void main(String[] args) {
        try {
            // извлечь символьную строку с веб-адресом (URL) из командной строки
            // или использовать выбираемый по умолчанию URL
            String urlString;
            if (args.length > 0) urlString = args[0];
            else urlString = "http://java.sun.com";

            //открыть поток ввода для чтения URL
            InputStreamReader in = new InputStreamReader(new URL(urlString).openStream(), StandardCharsets.UTF_8);

            //прочитать содержимое в построитель символьных строк
            StringBuilder input = new StringBuilder();
            int ch;
            while ((ch = in.read()) != -1)
                input.append((char) ch);

            // найти все совпадения с шаблоном
            String patternString = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>]*)\\s*>";
            Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String match = matcher.group();
                System.out.println(match);
            }
        } catch (IOException | PatternSyntaxException e) {
            e.printStackTrace();
        }
    }
}
