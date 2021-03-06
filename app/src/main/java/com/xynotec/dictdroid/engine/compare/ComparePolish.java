package com.xynotec.dictdroid.engine.compare;

import java.util.HashMap;

public class ComparePolish extends CompareBase
{
	char[] charCollation = 
	{	
		0x0061,
		0x0041,
		0x0105,
		0x0104,
		0x0062,
		0x0042,
		0x0063,
		0x0043,
		0x0107,
		0x0106,
		0x0064,
		0x0044,
		0x0065,
		0x0045,
		0x0119,
		0x0118,
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
		0x0142,
		0x0141,
		0x006D,
		0x004D,
		0x006E,
		0x004E,
		0x0144,
		0x0143,
		0x006F,
		0x004F,
		0x00F3,
		0x00D3,
		0x0070,
		0x0050,
		0x0072,
		0x0052,
		0x0073,
		0x0053,
		0x015B,
		0x015A,
		0x0074,
		0x0054,
		0x0075,
		0x0055,
		0x0077,
		0x0057,
		0x0079,
		0x0059,
		0x007A,
		0x005A,
		0x017A,
		0x0179,
		0x017C,
		0x017B,
					
	};	

	public ComparePolish()
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

		charMap.put((char)0x0105, (char)(1 + minVal));	
		charMap.put((char)0x0104, (char)(1 + minVal));	

		charMap.put((char)0x0062, (char)(2 + minVal));	
		charMap.put((char)0x0042, (char)(2 + minVal));	

		charMap.put((char)0x0063, (char)(3 + minVal));	
		charMap.put((char)0x0043, (char)(3 + minVal));	

		charMap.put((char)0x0107, (char)(4 + minVal));	
		charMap.put((char)0x0106, (char)(4 + minVal));	

		charMap.put((char)0x0064, (char)(5 + minVal));	
		charMap.put((char)0x0044, (char)(5 + minVal));	

		charMap.put((char)0x0065, (char)(6 + minVal));	
		charMap.put((char)0x0045, (char)(6 + minVal));	

		charMap.put((char)0x0119, (char)(7 + minVal));	
		charMap.put((char)0x0118, (char)(7 + minVal));	

		charMap.put((char)0x0066, (char)(8 + minVal));	
		charMap.put((char)0x0046, (char)(8 + minVal));	

		charMap.put((char)0x0067, (char)(9 + minVal));	
		charMap.put((char)0x0047, (char)(9 + minVal));	

		charMap.put((char)0x0068, (char)(10 + minVal));	
		charMap.put((char)0x0048, (char)(10 + minVal));	

		charMap.put((char)0x0069, (char)(11 + minVal));	
		charMap.put((char)0x0049, (char)(11 + minVal));	

		charMap.put((char)0x006A, (char)(12 + minVal));	
		charMap.put((char)0x004A, (char)(12 + minVal));	

		charMap.put((char)0x006B, (char)(13 + minVal));	
		charMap.put((char)0x004B, (char)(13 + minVal));	

		charMap.put((char)0x006C, (char)(14 + minVal));	
		charMap.put((char)0x004C, (char)(14 + minVal));	

		charMap.put((char)0x0142, (char)(15 + minVal));	
		charMap.put((char)0x0141, (char)(15 + minVal));	

		charMap.put((char)0x006D, (char)(16 + minVal));	
		charMap.put((char)0x004D, (char)(16 + minVal));	

		charMap.put((char)0x006E, (char)(17 + minVal));	
		charMap.put((char)0x004E, (char)(17 + minVal));	

		charMap.put((char)0x0144, (char)(18 + minVal));	
		charMap.put((char)0x0143, (char)(18 + minVal));	

		charMap.put((char)0x006F, (char)(19 + minVal));	
		charMap.put((char)0x004F, (char)(19 + minVal));	

		charMap.put((char)0x00F3, (char)(20 + minVal));	
		charMap.put((char)0x00D3, (char)(20 + minVal));	

		charMap.put((char)0x0070, (char)(21 + minVal));	
		charMap.put((char)0x0050, (char)(21 + minVal));	

		charMap.put((char)0x0072, (char)(22 + minVal));	
		charMap.put((char)0x0052, (char)(22 + minVal));	

		charMap.put((char)0x0073, (char)(23 + minVal));	
		charMap.put((char)0x0053, (char)(23 + minVal));	

		charMap.put((char)0x015B, (char)(24 + minVal));	
		charMap.put((char)0x015A, (char)(24 + minVal));	

		charMap.put((char)0x0074, (char)(25 + minVal));	
		charMap.put((char)0x0054, (char)(25 + minVal));	

		charMap.put((char)0x0075, (char)(26 + minVal));	
		charMap.put((char)0x0055, (char)(26 + minVal));	

		charMap.put((char)0x0077, (char)(27 + minVal));	
		charMap.put((char)0x0057, (char)(27 + minVal));	

		charMap.put((char)0x0079, (char)(28 + minVal));	
		charMap.put((char)0x0059, (char)(28 + minVal));	

		charMap.put((char)0x007A, (char)(29 + minVal));	
		charMap.put((char)0x005A, (char)(29 + minVal));	

		charMap.put((char)0x017A, (char)(30 + minVal));	
		charMap.put((char)0x0179, (char)(30 + minVal));	

		charMap.put((char)0x017C, (char)(31 + minVal));	
		charMap.put((char)0x017B, (char)(31 + minVal));	
		
	}
}
