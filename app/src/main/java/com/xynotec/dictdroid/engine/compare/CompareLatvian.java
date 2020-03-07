package com.xynotec.dictdroid.engine.compare;

import java.util.HashMap;

public class CompareLatvian extends CompareBase
{
	char[] charCollation = 
	{		
		0x0061,
		0x0041,
		0x0101,
		0x0100,
		0x0062,
		0x0042,
		0x0063,
		0x0043,
		0x010D,
		0x010C,
		0x0064,
		0x0044,
		0x0065,
		0x0045,
		0x0113,
		0x0112,
		0x0066,
		0x0046,
		0x0067,
		0x0047,
		0x0123,
		0x0122,
		0x0068,
		0x0048,
		0x0069,
		0x0049,
		0x012B,
		0x012A,
		0x006A,
		0x004A,
		0x006B,
		0x004B,
		0x0137,
		0x0136,
		0x006C,
		0x004C,
		0x013C,
		0x013B,
		0x006D,
		0x004D,
		0x006E,
		0x004E,
		0x0146,
		0x0145,
		0x006F,
		0x004F,
		0x0070,
		0x0050,
		0x0072,
		0x0052,
		0x0073,
		0x0053,
		0x0161,
		0x0160,
		0x0074,
		0x0054,
		0x0075,
		0x0055,
		0x016B,
		0x016A,
		0x0076,
		0x0056,
		0x007A,
		0x005A,
		0x017E,
		0x017D,		
	};	

	public CompareLatvian()
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
		charMap.put((char)0x0101, (char)(0 + minVal));	
		charMap.put((char)0x0100, (char)(0 + minVal));

		charMap.put((char)0x0062, (char)(1 + minVal));	
		charMap.put((char)0x0042, (char)(1 + minVal));

		charMap.put((char)0x0063, (char)(2 + minVal));	
		charMap.put((char)0x0043, (char)(2 + minVal));

		charMap.put((char)0x010D, (char)(3 + minVal));	
		charMap.put((char)0x010C, (char)(3 + minVal));

		charMap.put((char)0x0064, (char)(4 + minVal));	
		charMap.put((char)0x0044, (char)(4 + minVal));

		charMap.put((char)0x0065, (char)(5 + minVal));	
		charMap.put((char)0x0045, (char)(5 + minVal));
		charMap.put((char)0x0113, (char)(5 + minVal));	
		charMap.put((char)0x0112, (char)(5 + minVal));

		charMap.put((char)0x0066, (char)(6 + minVal));	
		charMap.put((char)0x0046, (char)(6 + minVal));

		charMap.put((char)0x0067, (char)(7 + minVal));	
		charMap.put((char)0x0047, (char)(7 + minVal));

		charMap.put((char)0x0123, (char)(8 + minVal));	
		charMap.put((char)0x0122, (char)(8 + minVal));

		charMap.put((char)0x0068, (char)(9 + minVal));	
		charMap.put((char)0x0048, (char)(9 + minVal));

		charMap.put((char)0x0069, (char)(10 + minVal));	
		charMap.put((char)0x0049, (char)(10 + minVal));
		charMap.put((char)0x012B, (char)(10 + minVal));	
		charMap.put((char)0x012A, (char)(10 + minVal));

		charMap.put((char)0x006A, (char)(11 + minVal));	
		charMap.put((char)0x004A, (char)(11 + minVal));

		charMap.put((char)0x006B, (char)(12 + minVal));	
		charMap.put((char)0x004B, (char)(12 + minVal));

		charMap.put((char)0x0137, (char)(13 + minVal));	
		charMap.put((char)0x0136, (char)(13 + minVal));

		charMap.put((char)0x006C, (char)(14 + minVal));	
		charMap.put((char)0x004C, (char)(14 + minVal));

		charMap.put((char)0x013C, (char)(15 + minVal));	
		charMap.put((char)0x013B, (char)(15 + minVal));

		charMap.put((char)0x006D, (char)(16 + minVal));	
		charMap.put((char)0x004D, (char)(16 + minVal));

		charMap.put((char)0x006E, (char)(17 + minVal));	
		charMap.put((char)0x004E, (char)(17 + minVal));

		charMap.put((char)0x0146, (char)(18 + minVal));	
		charMap.put((char)0x0145, (char)(18 + minVal));

		charMap.put((char)0x006F, (char)(19 + minVal));	
		charMap.put((char)0x004F, (char)(19 + minVal));

		charMap.put((char)0x0070, (char)(20 + minVal));	
		charMap.put((char)0x0050, (char)(20 + minVal));

		charMap.put((char)0x0072, (char)(21 + minVal));	
		charMap.put((char)0x0052, (char)(21 + minVal));

		charMap.put((char)0x0073, (char)(22 + minVal));	
		charMap.put((char)0x0053, (char)(22 + minVal));

		charMap.put((char)0x0161, (char)(23 + minVal));	
		charMap.put((char)0x0160, (char)(24 + minVal));

		charMap.put((char)0x0074, (char)(25 + minVal));	
		charMap.put((char)0x0054, (char)(25 + minVal));

		charMap.put((char)0x0075, (char)(26 + minVal));	
		charMap.put((char)0x0055, (char)(26 + minVal));
		charMap.put((char)0x016B, (char)(26 + minVal));	
		charMap.put((char)0x016A, (char)(26 + minVal));

		charMap.put((char)0x0076, (char)(27 + minVal));	
		charMap.put((char)0x0056, (char)(27 + minVal));

		charMap.put((char)0x007A, (char)(28 + minVal));	
		charMap.put((char)0x005A, (char)(28 + minVal));

		charMap.put((char)0x017E, (char)(29 + minVal));	
		charMap.put((char)0x017D, (char)(29 + minVal));
		
	}
}
