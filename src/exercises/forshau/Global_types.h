#ifndef GLOBAL_TYPES_H
#define GLOBAL_TYPES_H

#ifndef POSTMISSION_ANALYZING
#include <inttypes.h>
#endif

#define _SINT8     signed char
#define _UINT8     unsigned char
#define _SINT16    signed short
#define _UINT16    unsigned short
#define _SINT32    signed long
#define _UINT32    unsigned long
#define _FLOAT32   float
#define _DOUBLE64  double

#ifdef POSTMISSION_ANALYZING
#define _BOOL      bool
#endif

typedef _FLOAT32 _TVector[3];
typedef _FLOAT32 _TMatrix[3][3];

#ifndef POSTMISSION_ANALYZING
#define _SINT64    int64_t
#define _UINT64    int64_t
#endif

#ifdef POSTMISSION_ANALYZING
#define _SINT64    __int64
#define _UINT64    __int64
#endif

#endif
