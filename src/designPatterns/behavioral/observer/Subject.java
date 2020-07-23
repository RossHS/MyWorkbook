package designPatterns.behavioral.observer;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * @author Ross Khapilov
 * @version 1.0 27.06.2019
 */
public interface Subject {
    void subscribeObserver(Observer observer);

    void unsubscribeObserver(Observer observer);

    void notifyObservers();

    String subjectDetails();
}

class t {
    protected static float rollDeg;
    protected static float pitchDeg;
    protected static float headingDeg;
    protected static float speedMS;
    protected static float baroAltitudeM;
    protected static float altitudeM;
    protected static double latDeg;
    protected static double lonDeg;
    protected static short[] rawG = new short[3];
    protected static short[] rawA = new short[3];
    protected static int rawBaroPressure;
    protected static int rawBaroTemperature;
    protected static float[] omegaBDegSec = new float[3];
    protected static float[] fBMSS = new float[3];
    protected static float baroPressurePa;
    protected static float temperature;

    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream("D:\\prog\\MyProjects\\Learning\\2020_01_12_12_15_09.txt");
        byte[] bytes = stream.readAllBytes();
        System.out.println(bytes.length);
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        System.out.println((short) 0xBD01);
        System.out.println(buffer.getShort());
        System.out.println(buffer.getShort());
        System.out.println(buffer.getShort());
        while (buffer.hasRemaining()) {
            if (buffer.getShort() == (short) 0xBD01) {
                int packindex = buffer.getInt();
                int multiplecsor = buffer.getInt();
                int flag = buffer.getInt();
                rollDeg = buffer.getFloat();
                pitchDeg = buffer.getFloat();
                headingDeg = buffer.getFloat();
                speedMS = buffer.getFloat();
                baroAltitudeM = buffer.getFloat();
                altitudeM = buffer.getFloat();
                latDeg = buffer.getDouble();
                lonDeg = buffer.getDouble();
                for (int i = 0; i < rawG.length; i++) {
                    rawG[i] = buffer.getShort();
                }
                for (int i = 0; i < rawA.length; i++) {
                    rawA[i] = buffer.getShort();
                }
                temperature = ((float) buffer.getShort()) / 333.87f + 21.0f;
                rawBaroPressure = buffer.getInt();
                rawBaroTemperature = buffer.getInt();
                for (int i = 0; i < omegaBDegSec.length; i++) {
                    omegaBDegSec[i] = buffer.getFloat();
                }
                for (int i = 0; i < fBMSS.length; i++) {
                    fBMSS[i] = buffer.getFloat();
                }
                baroPressurePa = buffer.getFloat();
                short checksum = buffer.getShort();

                System.out.println(packindex + " " + " " + rollDeg + " " + pitchDeg + " " + headingDeg + " " + speedMS + " " + baroAltitudeM + " " + altitudeM + " " + latDeg + " " + lonDeg + " " + Arrays.toString(rawG) + " " + Arrays.toString(rawA) + " " +
                        +temperature + " " + rawBaroPressure + " " + rawBaroTemperature + " " + Arrays.toString(omegaBDegSec) + " " + Arrays.toString(fBMSS) + " " + baroPressurePa + " " + checksum);
            }
                buffer.getShort();

        }


//        System.out.println(Arrays.toString(bytes));
    }
}
