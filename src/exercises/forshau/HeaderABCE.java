package exercises.forshau;

/**
 * @author Ross Khapilov
 * @version 1.0 12.11.2018
 */
public class HeaderABCE {
    public long Header;
    public long PacketIndex;
    public long Multiplecsor_2Hz;
    public long Flag;
    public long Roll_deg;
    public long Pitch_deg;
    public long Heading_deg;
    public long MagHeading_deg;

    public long Speed_m_s;

    public long BaroAltitude_m;
    public long Altitude_m;

    public double Lat_deg;
    public double Lon_deg;

    public int[] rawG;
    public int[] rawA;
    public int[] rawM;
    public int RawIMUTemperature;

    public int RawBaroPressure;
    public int RawBaroTemperature;

    public float[] OmegaB_deg_s;
    public float[] fB_m_s_s;
    public float[] MagnIntensityB_microTesla;
    public float BaroPressure_Pa;
    public int CheckSum_XOR_16;


}
