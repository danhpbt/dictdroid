package com.xynotec.dictdroid.engine.compare;

import java.util.HashMap;

public class CompareSerbian extends CompareBase
{
	char[] charCollation = 
	{		
		0x0430,
		0x0410,
		0x0431,
		0x0411,
		0x0432,
		0x0412,
		0x0433,
		0x0413,
		0x0434,
		0x0414,
		0x0452,
		0x0402,
		0x0435,
		0x0415,
		0x0436,
		0x0416,
		0x0437,
		0x0417,
		0x0438,
		0x0418,
		0x0458,
		0x0408,
		0x043A,
		0x041A,
		0x043B,
		0x041B,
		0x0459,
		0x0409,
		0x043C,
		0x041C,
		0x043D,
		0x041D,
		0x045A,
		0x040A,
		0x043E,
		0x041E,
		0x043F,
		0x041F,
		0x0440,
		0x0420,
		0x0441,
		0x0421,
		0x0442,
		0x0422,
		0x045B,
		0x040B,
		0x0443,
		0x0423,
		0x0444,
		0x0424,
		0x0445,
		0x0425,
		0x0446,
		0x0426,
		0x0447,
		0x0427,
		0x045F,
		0x040F,
		0x0448,
		0x0428,			
	};	

	public CompareSerbian()
	{
		charMap = new HashMap(charCollation.length);
		minVal = 0x7FFF;
		for(int i = 0; i < charCollation.length; i++)
		{
			if (charCollation[i] < minVal)
				minVal = charCollation[i];
		}		
		
		charMap.put((char)0x0430, (char)(0 + minVal));	 
		charMap.put((char)0x0410, (char)(0 + minVal));	 

		charMap.put((char)0x0431, (char)(1 + minVal));
		charMap.put((char)0x0411, (char)(1 + minVal));

		charMap.put((char)0x0432, (char)(2 + minVal));
		charMap.put((char)0x0412, (char)(2 + minVal));

		charMap.put((char)0x0433, (char)(3 + minVal));
		charMap.put((char)0x0413, (char)(3 + minVal));

		charMap.put((char)0x0434, (char)(4 + minVal));
		charMap.put((char)0x0414, (char)(4 + minVal));

		charMap.put((char)0x0452, (char)(5 + minVal));
		charMap.put((char)0x0402, (char)(5 + minVal));

		charMap.put((char)0x0435, (char)(6 + minVal));
		charMap.put((char)0x0415, (char)(6 + minVal));

		charMap.put((char)0x0436, (char)(7 + minVal));
		charMap.put((char)0x0416, (char)(7 + minVal));

		charMap.put((char)0x0437, (char)(8 + minVal));
		charMap.put((char)0x0417, (char)(8 + minVal));

		charMap.put((char)0x0438, (char)(9 + minVal));
		charMap.put((char)0x0418, (char)(9 + minVal));

		charMap.put((char)0x0458, (char)(10 + minVal));
		charMap.put((char)0x0408, (char)(10 + minVal));

		charMap.put((char)0x043A, (char)(11 + minVal));
		charMap.put((char)0x041A, (char)(11 + minVal));

		charMap.put((char)0x043B, (char)(12 + minVal));
		charMap.put((char)0x041B, (char)(12 + minVal));

		charMap.put((char)0x0459, (char)(13 + minVal));
		charMap.put((char)0x0409, (char)(13 + minVal));

		charMap.put((char)0x043C, (char)(14 + minVal));
		charMap.put((char)0x041C, (char)(14 + minVal));

		charMap.put((char)0x043D, (char)(15 + minVal));
		charMap.put((char)0x041D, (char)(15 + minVal));

		charMap.put((char)0x045A, (char)(16 + minVal));
		charMap.put((char)0x040A, (char)(16 + minVal));

		charMap.put((char)0x043E, (char)(17 + minVal));
		charMap.put((char)0x041E, (char)(17 + minVal));

		charMap.put((char)0x043F, (char)(18 + minVal));
		charMap.put((char)0x041F, (char)(18 + minVal));

		charMap.put((char)0x0440, (char)(19 + minVal));
		charMap.put((char)0x0420, (char)(19 + minVal));

		charMap.put((char)0x0441, (char)(20 + minVal));
		charMap.put((char)0x0421, (char)(20 + minVal));

		charMap.put((char)0x0442, (char)(21 + minVal));
		charMap.put((char)0x0422, (char)(21 + minVal));

		charMap.put((char)0x045B, (char)(22 + minVal));
		charMap.put((char)0x040B, (char)(22 + minVal));

		charMap.put((char)0x0443, (char)(23 + minVal));
		charMap.put((char)0x0423, (char)(23 + minVal));

		charMap.put((char)0x0444, (char)(24 + minVal));
		charMap.put((char)0x0424, (char)(24 + minVal));

		charMap.put((char)0x0445, (char)(25 + minVal));
		charMap.put((char)0x0425, (char)(25 + minVal));

		charMap.put((char)0x0446, (char)(26 + minVal));
		charMap.put((char)0x0426, (char)(26 + minVal));

		charMap.put((char)0x0447, (char)(27 + minVal));
		charMap.put((char)0x0427, (char)(27 + minVal));

		charMap.put((char)0x045F, (char)(28 + minVal));
		charMap.put((char)0x040F, (char)(28 + minVal));

		charMap.put((char)0x0448, (char)(29 + minVal));
		charMap.put((char)0x0428, (char)(29 + minVal));
	}
}
