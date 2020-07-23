package thinkingInJava.ch3_operators;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 19.12.2017
 */
public class Speed {
    private int time;
    private int distance;

    public Speed(int distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public double getSpeed(){
        return (double) distance/time;
    }
}

class SpeedTest{
    public static void main(String[] args) {
        System.out.println(new Speed(100,35).getSpeed());
    }
}
