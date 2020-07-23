#ifndef ML_IO_OUTPUT_PACKETS_H
#define ML_IO_OUTPUT_PACKETS_H


#include "Global_types.h"

// void Calc_XOR16_and_Write(void* data, unsigned short length)
// {
//   unsigned short x16 = 0, word_index, word_max_array;
//   word_max_array = length / 2 - 1;

//   for (word_index = 0; word_index < word_max_array; word_index++)
//     x16 ^= ((unsigned short*) data)[word_index];
//   ((unsigned short*) data)[word_max_array] = x16;
// }

// -----------------------------------------------------------------------------------------------------------

typedef struct
{
  _UINT16 Header;                              // (0xABCE);
  _UINT32 PacketIndex;
  _UINT32 Multiplecsor_2Hz;
  _UINT32 Flag;
  _FLOAT32 Roll_deg, Pitch_deg, Heading_deg, MagHeading_deg;
  _FLOAT32 Speed_m_s;
  _FLOAT32 BaroAltitude_m, Altitude_m;
  _DOUBLE64 Lat_deg, Lon_deg;
  _SINT16 RawG[3], RawA[3], RawM[3], RawIMUTemperature;
  _UINT32 RawBaroPressure, RawBaroTemperature;
  _FLOAT32 OmegaB_deg_s[3], fB_m_s_s[3], MagnIntensityB_microTesla[3], BaroPressure_Pa;
  _UINT16 CheckSum_XOR_16;
} TOutINSDataPacket; // 100 Hz

// -----------------------------------------------------------------------------------------------------------

typedef struct
{
  unsigned short int Head; // 0xA511
  float RMCU_LAT;
  float RMCU_LAT2;
  float RMCU_LNG;
  float RMCU_LNG2;
  float RMCU_SPEED;
  float RMCU_COURSE;
  short int GSAU_PDOP; // x 100
  short int GSAU_HDOP; // x 100
  short int GSAU_VDOP; // x 100
  short int flags;     // RMC_AVL +  Push_int2COMP(GGAU->QUAL); Push_int2COMP(GSAU->CALCMOD);  GSAU->AUTO
  unsigned short int ui;
} TGPSPacket1; // 36 bytes

// -----------------------------------------------------------------------------------------------------------

typedef struct
{
  unsigned short int Head; // 0xA522
  float GGAU_LAT;
  float GGAU_LAT2;
  float GGAU_LNG;
  float GGAU_LNG2;
  float GGAU_HDOP;
  float GGAU_HEIGHT;
  float GGAU_UTC;
  long int RMCU_DATE;
  unsigned short int ui;
} TGPSPacket2; // 36 bytes

// -----------------------------------------------------------------------------------------------------------

typedef struct
{
  unsigned short int Head; // 0xA533
  float RMCU_UTC;
  float RMCU_DECLIN;
  short int GSAU_ID[12];
  unsigned short int ui;
} TGPSPacket3; // 36 bytes

// -----------------------------------------------------------------------------------------------------------

typedef struct
{
  unsigned short int Head; // 0xA544
  short int GGAU_SNUM;
  short int GGAU_HDIFF;
  short int GSVU_VIEW;
  short int GSVU_ID[12];
  short int Smode;
  unsigned short int ui;
} TGPSPacket4; // 36 bytes

// -----------------------------------------------------------------------------------------------------------

typedef struct
{
  unsigned short int Head; // 0xA555
  short int GSVU_ELEV[12];
  short int z[4];
  unsigned short int ui;
} TGPSPacket5; // 36 bytes

// -----------------------------------------------------------------------------------------------------------

typedef struct
{
  unsigned short int Head; // 0xA566
  short int GSVU_AZIM[12];
  short int z[4];
  unsigned short int ui;
} TGPSPacket6; // 36 bytes

// -----------------------------------------------------------------------------------------------------------

typedef struct
{
  unsigned short int Head; // 0xA577
  short int GSVU_SN[12];
  short int z[4];
  unsigned short int ui;
} TGPSPacket7; // 36 bytes

// -----------------------------------------------------------------------------------------------------------

typedef struct
{
  unsigned short int Head; // 0xA588
  float RMCU_UTC;
  float RMCU_DECLIN;
  short GSAU_ID[12];
  unsigned short ui;
} TGPSPacket8; // 36 bytes

// -----------------------------------------------------------------------------------------------------------

typedef struct
{
  unsigned short Head; // 0xA599
  short GGAU_SNUM;
  short GGAU_HDIFF;
  short GSVU_VIEW_GL;
  short GSVU_ID[12];
  short Smode;
  unsigned short ui;
} TGPSPacket9; // 36 bytes

// -----------------------------------------------------------------------------------------------------------

typedef struct
{
  unsigned short Head; // 0xA5AA
  short GSVU_ELEV[12];
  // short z[4];
  long muxpassout;
  long muxpassout2;
  unsigned short ui;
} TGPSPacket10; // 36 bytes

// -----------------------------------------------------------------------------------------------------------

typedef struct
{
  unsigned short Head; // 0xA5BB
  short GSVU_AZIM[12];
  short z[4];
  unsigned short ui;
} TGPSPacket11; // 36 bytes

// -----------------------------------------------------------------------------------------------------------

typedef struct
{
  unsigned short Head; // 0xA5CC
  short GSVU_SN[12];
  short z[4];
  unsigned short ui;
} TGPSPacket12; // 36 bytes

// -----------------------------------------------------------------------------------------------------------

#endif // OUTPUT_PACKETS_H
