package exercises.forshau;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * @author Ross Khapilov
 * @version 1.0 14.11.2018
 */
public class MissionComplete {
    static FileInputStream fin;
    static FileWriter fw;

    public static void main(String[] args) throws IOException {
        String filePath = "D:\\prog\\MyProjects\\Learning\\src\\exercises\\forshau\\20180314_11h_40m_57s_SINS2000_Test.nav";
        fin = new FileInputStream(filePath);
        fw = new FileWriter("D:\\prog\\MyProjects\\Learning\\src\\exercises\\forshau\\20180314_11h_40m_57s_SHAAAAAAAAAAUUUUUUUUUU.txt");
//        fw.append("ПАКЕТ ИНС\n" +
//                "1- Индекс пакета 4 байта\n" +
//                "2- Мультиплексор 2Гц 4 байта\n" +
//                "3- Флаг 4 байта\n" +
//                "4- Roll градусы 4 байта\n" +
//                "5- Pitch градусы 4 байта\n" +
//                "6- Heading градусы 4 байта\n" +
//                "7- MagHeading 4 байта\n" +
//                "8- Скорость м/с 4 байта\n" +
//                "9- Барометр высота над уровнем моря м 4 байта\n" +
//                "10- Высота над уровнем моря м 4 байта\n" +
//                "11- Широта градусы 8 байт\n" +
//                "12- Долгота градусы 8 байт\n" +
//                "13- RawG1 2 байта\n" +
//                "14- RawG2 2 байта\n" +
//                "15- RawG3 2 байта\n" +
//                "16- RawA1 2 байта\n" +
//                "17- RawA2 2 байта\n" +
//                "18- RawA3 2 байта\n" +
//                "19- RawM1 2 байта\n" +
//                "20- RawM2 2 байта\n" +
//                "21- RawM3 2 байта\n" +
//                "22- RawIMUTemperature 2 байта\n" +
//                "23- Raw Давление барометра 4 байта\n" +
//                "24- Raw Температура Барометра 4 байта\n" +
//                "25- ОмегаB1 градусы/с 4 байта\n" +
//                "26- ОмегаB2 градусы/с 4 байта\n" +
//                "27- ОмегаB3 градусы/с 4 байта\n" +
//                "28- fB1 м/с^2 4 байта\n" +
//                "29- fB2 м/с^2 4 байта\n" +
//                "30- fB3 м/с^2 4 байта\n" +
//                "31- MagnIntensityB1_microTesla 4 байта\n" +
//                "32- MagnIntensityB2_microTesla 4 байта\n" +
//                "33- MagnIntensityB3_microTesla 4 байта\n" +
//                "34- Давление Барометр Паскали 4 байта\n" +
//                "35- ЧекСумма XOR 16 бит\n"
//        );
        int length;
        byte[] header = new byte[2];
        do {
            length = fin.read(header);
            String strHeader = String.format("%02X", header[1]) + String.format("%02X", header[0]);
            switch (strHeader) {
                case "ABCE":
                    parseABCE();
                    break;
                case "A511":
                    break;
                case "A522":
                    break;
                case "A533":
                    break;
                case "A544":
                    break;
                case "A555":
                    break;
                case "A566":
                    break;
                case "A577":
                    break;
                case "A588":
                    break;
                case "A599":
                    break;
                case "A5AA":
                    break;
                case "A5BB":
                    break;
                case "A5CC":
                    break;
                default:
                    fin.read(new byte[1]);
            }
        } while (length != -1);
    }

    private static void parseABCE() throws IOException {
        fw.append("\nABCE\n");
        byte[] bytes = new byte[126];
        fin.read(bytes);
        //первые 12 байт int (3 переменных) без знака
//        for (int i = 0; i < 12; i += 4) {
//            fw.append(getInt(bytes[i], bytes[i + 1], bytes[i + 2], bytes[i + 3]) + " ");
//        }
        // еще 7 переменных, еще 28 байт
//        for (int i = 12; i < 40; i += 4) {
//            fw.append(getFloat(bytes[i], bytes[i + 1], bytes[i + 2], bytes[i + 3]) + " ");
//        }
        // 2 переменные по 8 байт, еще 16
//        for (int i = 40; i < 56; i += 8) {
//            fw.append(getDouble(bytes[i], bytes[i + 1], bytes[i + 2], bytes[i + 3], bytes[i + 4], bytes[i + 5], bytes[i + 6], bytes[i + 7]) + " ");
//        }
        // куча знаковых 2 байтовых переменных
        for (int i = 56; i < 76; i += 2) {
            fw.append(getShort(bytes[i], bytes[i + 2]) + " ");
        }
        // 2 переменные с барометров по 4 байта
//        for (int i = 76; i < 84; i += 4) {
//            fw.append(getInt(bytes[i], bytes[i + 1], bytes[i + 2], bytes[i + 3]) + " ");
//        }
        // куча переменных по 4 байта
//        for (int i = 84; i < 124; i += 4) {
//            fw.append(getFloat(bytes[i], bytes[i + 1], bytes[i + 2], bytes[i + 3]) + " ");
//        }
        fw.append(getShort(bytes[124], bytes[125]) + " ");
        System.out.println(getInt(bytes[0], bytes[1], bytes[2], bytes[3]));
        fw.append("\n");
    }

    private static float getFloat(byte... bytes) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return byteBuffer.getFloat();
    }

    private static double getDouble(byte... bytes) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return byteBuffer.getDouble();
    }

    private static int getInt(byte... bytes) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return byteBuffer.getInt();
    }

    private static short getShort(byte... bytes) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return byteBuffer.getShort();
    }
}
