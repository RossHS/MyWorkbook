package exercises.forshau;

import java.util.Arrays;

/**
 * @author Ross Khapilov
 * @version 1.0 12.11.2018
 */
public class BytesCounter {
    public static void main(String[] args) {
        String[] str = "CE AB D1 2F 03 00 00 00 00 00 10 00 00 00 8D D7 5A 3E 9D AD FD 3E 05 80 B6 42 00 00 00 00 00 00 00 00 6A 7D 53 43 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 ED FF 3F FF D5 FF 5D FF EB FF 15 42 00 00 00 00 00 00 8B 0B 70 2E 83 00 F0 C6 7D 00 68 85 98 BC AC 1E 3E 3E 97 E0 9B 3C 60 A3 49 BD 9E 3E AE 3D 5A A8 1D 41 00 00 00 00 00 00 00 00 00 00 00 00 00 FD C0 47 90 D7".split(" ");
        System.out.println(str.length);
        System.out.println(Arrays.toString(str));
        int[] a = {16, //Header
                32, //packIndex
                32, //MultiPlescor
                32, //Flag
                32, //Roll
                32, //Pitch
                32, //Heading
                32, //MagHead
                32, //speed_ms
                32, //BaroAlt
                32, //Alti_m
                64, //lat_deg
                64, //lon_deg

                16, 16, 16, //rawG
                16, 16, 16,  //rawA
                16, 16, 16, //rawM
                16, //RawIMUT
                32, //RawBaroP
                32, //RawBaroT
                32, 32, 32, //OmegaB
                32, 32, 32, //fB_m_s_s
                32, 32, 32, //MagInter
                32,//baroPres
                16}; //checkSum
        int stream = Arrays.stream(a).map(v -> v / 8).sum();
        System.out.println(stream);
        System.out.println(a.length);
        System.out.println(Integer.parseInt(str[0], 16));

        String[] reverse = new String[str.length];
        for (int i = 0, counter = 0; i < a.length; i++) {
            int size = a[i] / 8;
//            System.out.println(k);
            String[] temp = new String[size];
            for (int j = 0; j < a[i] / 8; j++, counter++) {
//                System.out.print(str[counter+k] +"     ");
//                System.out.print(str[counter] + " ");
                temp[j] = str[counter];
//

                String t = str[counter];
                str[counter] = str[str.length - counter - 1];
                str[str.length - counter - 1] = t;


            }
            for (int j = 0; j < temp.length / 2; j++) {
                String t = temp[j];
                temp[j] = temp[temp.length - j - 1];
                temp[temp.length - j - 1] = t;
            }
            System.out.println(i + " COUNTER " + Arrays.toString(temp));
//            System.out.println();
            System.out.println();
        }
        System.out.println(Arrays.toString(str));
    }
}
