package com.xynotec.dictdroid.engine.compare;

import java.util.HashMap;

public class CompareGerman extends CompareBase
{
	char[] charCollation = 
	{
		0x0061,
		0x0041,
		0x00E4,
		0x00C4,
		0x0062,
		0x0042,
		0x0063,
		0x0043,
		0x0064,
		0x0044,
		0x0065,
		0x0045,
		0x0066,
		0x0046,
		0x0067,
		0x0047,
		0x0068,
		0x0048,
		0x0069,
		0x0049,
		0x006A,
		0x004A,
		0x006B,
		0x004B,
		0x006C,
		0x004C,
		0x006D,
		0x004D,
		0x006E,
		0x004E,
		0x006F,
		0x004F,
		0x00F6,
		0x00D6,
		0x0070,
		0x0050,
		0x0071,
		0x0051,
		0x0072,
		0x0052,
		0x0073,
		0x0053,

		0x00DF,

		0x0074,
		0x0054,
		0x0075,
		0x0055,
		0x00FC,
		0x00DC,
		0x0076,
		0x0056,
		0x0077,
		0x0057,
		0x0078,
		0x0058,
		0x0079,
		0x0059,
		0x007A,
		0x005A,	
	};	

	public CompareGerman()
	{
		charMap = new HashMap(charCollation.length);
		minVal = 0x7FFF;
		for(int i = 0; i < charCollation.length; i++)
		{
			if (charCollation[i] < minVal)
				minVal = charCollation[i];
		}
		
		charMap.put((char)0x0061, (char)(0 + minVal));	
		charMap.put((char)0x0041, (char)(0 + minVal)); 	
		charMap.put((char)0x00E4, (char)(0 + minVal)); 	
		charMap.put((char)0x00C4, (char)(0 + minVal));

		charMap.put((char)0x0062, (char)(1 + minVal)); 	
		charMap.put((char)0x0042, (char)(1 + minVal));

		charMap.put((char)0x0063, (char)(2 + minVal)); 	
		charMap.put((char)0x0043, (char)(2 + minVal));

		charMap.put((char)0x0064, (char)(3 + minVal)); 	
		charMap.put((char)0x0044, (char)(3 + minVal));

		charMap.put((char)0x0065, (char)(4 + minVal)); 	
		charMap.put((char)0x0045, (char)(4 + minVal));

		charMap.put((char)0x0066, (char)(5 + minVal)); 	
		charMap.put((char)0x0046, (char)(5 + minVal));

		charMap.put((char)0x0067, (char)(6 + minVal)); 	
		charMap.put((char)0x0047, (char)(6 + minVal));

		charMap.put((char)0x0068, (char)(7 + minVal)); 	
		charMap.put((char)0x0048, (char)(7 + minVal));

		charMap.put((char)0x0069, (char)(8 + minVal)); 	
		charMap.put((char)0x0049, (char)(8 + minVal));

		charMap.put((char)0x006A, (char)(9 + minVal)); 	
		charMap.put((char)0x004A, (char)(9 + minVal));

		charMap.put((char)0x006B, (char)(10 + minVal)); 	
		charMap.put((char)0x004B, (char)(10 + minVal));

		charMap.put((char)0x006C, (char)(11 + minVal)); 	
		charMap.put((char)0x004C, (char)(11 + minVal));

		charMap.put((char)0x006D, (char)(12 + minVal)); 	
		charMap.put((char)0x004D, (char)(12 + minVal));

		charMap.put((char)0x006E, (char)(13 + minVal)); 	
		charMap.put((char)0x004E, (char)(13 + minVal));

		charMap.put((char)0x006F, (char)(14 + minVal)); 	
		charMap.put((char)0x004F, (char)(14 + minVal)); 	
		charMap.put((char)0x00F6, (char)(14 + minVal)); 	
		charMap.put((char)0x00D6, (char)(14 + minVal));
		
		charMap.put((char)0x0070, (char)(15 + minVal)); 	
		charMap.put((char)0x0050, (char)(15 + minVal));
		
		charMap.put((char)0x0071, (char)(16 + minVal)); 	
		charMap.put((char)0x0051, (char)(16 + minVal));
		
		charMap.put((char)0x0072, (char)(17 + minVal)); 	
		charMap.put((char)0x0052, (char)(17 + minVal));
		
		charMap.put((char)0x0073, (char)(18 + minVal)); 	
		charMap.put((char)0x0053, (char)(18 + minVal)); 	
		charMap.put((char)0x00DF, (char)(18 + minVal));
		//charMap.put((char)0x00DF, (char)(19 + minVal));
		
		charMap.put((char)0x0074, (char)(20 + minVal)); 	
		charMap.put((char)0x0054, (char)(20 + minVal));
		
		charMap.put((char)0x0075, (char)(21 + minVal)); 	
		charMap.put((char)0x0055, (char)(21 + minVal)); 	
		charMap.put((char)0x00FC, (char)(21 + minVal)); 	
		charMap.put((char)0x00DC, (char)(21 + minVal));
		
		charMap.put((char)0x0076, (char)(22 + minVal));	
		charMap.put((char)0x0056, (char)(22 + minVal));
		
		charMap.put((char)0x0077, (char)(23 + minVal)); 	
		charMap.put((char)0x0057, (char)(23 + minVal));
		
		charMap.put((char)0x0078, (char)(24 + minVal)); 	
		charMap.put((char)0x0058, (char)(24 + minVal));
		
		charMap.put((char)0x0079, (char)(25 + minVal)); 	
		charMap.put((char)0x0059, (char)(25 + minVal));
		
		charMap.put((char)0x007A, (char)(26 + minVal)); 	
		charMap.put((char)0x005A, (char)(26 + minVal));
		
	}
}
