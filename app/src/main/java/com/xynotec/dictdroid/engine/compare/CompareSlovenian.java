package com.xynotec.dictdroid.engine.compare;

import java.util.HashMap;

public class CompareSlovenian extends CompareBase
{
	char[] charCollation = 
	{		
		0x0061,
		0x0041,
		0x00E1,
		0x00C1,
		0x00E0,
		0x00C0,
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
		0x00E9,
		0x00C9,
		0x00E8,
		0x00C8,
		0x00EA,
		0x00CA,
		0x0066,
		0x0046,
		0x0067,
		0x0047,
		0x0068,
		0x0048,
		0x0069,
		0x0049,
		0x00ED,
		0x00CD,
		0x00EC,
		0x00CC,
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
		0x00F3,
		0x00D3,
		0x00F2,
		0x00D2,
		0x00F4,
		0x00D4,
		0x0070,
		0x0050,
		0x0071,
		0x0051,
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
		0x00FA,
		0x00DA,
		0x00F9,
		0x00D9,
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
		0x017E,
		0x017D,				
	};	

	public CompareSlovenian()
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
		charMap.put((char)0x00E1, (char)(0 + minVal));
		charMap.put((char)0x00C1, (char)(0 + minVal));
		charMap.put((char)0x00E0, (char)(0 + minVal));
		charMap.put((char)0x00C0, (char)(0 + minVal));

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
		charMap.put((char)0x00E9, (char)(5 + minVal));
		charMap.put((char)0x00C9, (char)(5 + minVal));
		charMap.put((char)0x00E8, (char)(5 + minVal));
		charMap.put((char)0x00C8, (char)(5 + minVal));
		charMap.put((char)0x00EA, (char)(5 + minVal));
		charMap.put((char)0x00CA, (char)(5 + minVal));

		charMap.put((char)0x0066, (char)(6 + minVal));
		charMap.put((char)0x0046, (char)(6 + minVal));

		charMap.put((char)0x0067, (char)(7 + minVal));
		charMap.put((char)0x0047, (char)(7 + minVal));

		charMap.put((char)0x0068, (char)(8 + minVal));
		charMap.put((char)0x0048, (char)(8 + minVal));

		charMap.put((char)0x0069, (char)(9 + minVal));
		charMap.put((char)0x0049, (char)(9 + minVal));
		charMap.put((char)0x00ED, (char)(9 + minVal));
		charMap.put((char)0x00CD, (char)(9 + minVal));
		charMap.put((char)0x00EC, (char)(9 + minVal));
		charMap.put((char)0x00CC, (char)(9 + minVal));

		charMap.put((char)0x006A, (char)(10 + minVal));
		charMap.put((char)0x004A, (char)(10 + minVal));

		charMap.put((char)0x006B, (char)(11 + minVal));
		charMap.put((char)0x004B, (char)(11 + minVal));

		charMap.put((char)0x006C, (char)(12 + minVal));
		charMap.put((char)0x004C, (char)(12 + minVal));

		charMap.put((char)0x006D, (char)(13 + minVal));
		charMap.put((char)0x004D, (char)(13 + minVal));

		charMap.put((char)0x006E, (char)(14 + minVal));
		charMap.put((char)0x004E, (char)(14 + minVal));

		charMap.put((char)0x006F, (char)(15 + minVal));
		charMap.put((char)0x004F, (char)(15 + minVal));
		charMap.put((char)0x00F3, (char)(15 + minVal));
		charMap.put((char)0x00D3, (char)(15 + minVal));
		charMap.put((char)0x00F2, (char)(15 + minVal));
		charMap.put((char)0x00D2, (char)(15 + minVal));
		charMap.put((char)0x00F4, (char)(15 + minVal));
		charMap.put((char)0x00D4, (char)(15 + minVal));

		charMap.put((char)0x0070, (char)(16 + minVal));
		charMap.put((char)0x0050, (char)(16 + minVal));

		charMap.put((char)0x0071, (char)(17 + minVal));
		charMap.put((char)0x0051, (char)(17 + minVal));

		charMap.put((char)0x0072, (char)(18 + minVal));
		charMap.put((char)0x0052, (char)(18 + minVal));

		charMap.put((char)0x0073, (char)(19 + minVal));
		charMap.put((char)0x0053, (char)(19 + minVal));

		charMap.put((char)0x0161, (char)(20 + minVal));
		charMap.put((char)0x0160, (char)(20 + minVal));

		charMap.put((char)0x0074, (char)(21 + minVal));
		charMap.put((char)0x0054, (char)(21 + minVal));

		charMap.put((char)0x0075, (char)(22 + minVal));
		charMap.put((char)0x0055, (char)(22 + minVal));
		charMap.put((char)0x00FA, (char)(22 + minVal));
		charMap.put((char)0x00DA, (char)(22 + minVal));
		charMap.put((char)0x00F9, (char)(22 + minVal));
		charMap.put((char)0x00D9, (char)(22 + minVal));

		charMap.put((char)0x0076, (char)(23 + minVal));
		charMap.put((char)0x0056, (char)(23 + minVal));

		charMap.put((char)0x0077, (char)(24 + minVal));
		charMap.put((char)0x0057, (char)(24 + minVal));

		charMap.put((char)0x0078, (char)(25 + minVal));
		charMap.put((char)0x0058, (char)(25 + minVal));

		charMap.put((char)0x0079, (char)(26 + minVal));
		charMap.put((char)0x0059, (char)(26 + minVal));

		charMap.put((char)0x007A, (char)(27 + minVal));
		charMap.put((char)0x005A, (char)(27 + minVal));

		charMap.put((char)0x017E, (char)(28 + minVal));
		charMap.put((char)0x017D, (char)(28 + minVal));
		
	}
}
