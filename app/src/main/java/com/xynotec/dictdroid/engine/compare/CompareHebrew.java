package com.xynotec.dictdroid.engine.compare;

import java.util.HashMap;


public class CompareHebrew extends CompareBase
{
	char[] charCollation = 
	{	
		0x05D0,
		0x05D1,
		0x05D2,
		0x05D3,
		0x05D4,
		0x05D5,
		0x05D6,
		0x05D7,
		0x05D8,
		0x05D9,
		0x05DB,
		0x05DA,
		0x05DC,
		0x05DE,
		0x05DD,
		0x05E0,
		0x05DF,
		0x05E1,
		0x05E2,
		0x05E4,
		0x05E3,
		0x05E6,
		0x05E5,
		0x05E7,
		0x05E8,
		0x05E9,
		0x05EA,			
	};	

	public CompareHebrew()
	{
		charMap = new HashMap(charCollation.length);
		minVal = 0x7FFF;
		for(int i = 0; i < charCollation.length; i++)
		{
			if (charCollation[i] < minVal)
				minVal = charCollation[i];
		}
		
		charMap.put((char)0x05D0, (char)(0 + minVal)); 

		charMap.put((char)0x05D1, (char)(1 + minVal)); 

		charMap.put((char)0x05D2, (char)(2 + minVal)); 

		charMap.put((char)0x05D3, (char)(3 + minVal)); 

		charMap.put((char)0x05D4, (char)(4 + minVal)); 

		charMap.put((char)0x05D5, (char)(5 + minVal)); 

		charMap.put((char)0x05D6, (char)(6 + minVal)); 

		charMap.put((char)0x05D7, (char)(7 + minVal)); 

		charMap.put((char)0x05D8, (char)(8 + minVal)); 

		charMap.put((char)0x05D9, (char)(9 + minVal)); 

		charMap.put((char)0x05DB, (char)(10 + minVal)); 
		charMap.put((char)0x05DA, (char)(10 + minVal)); 

		charMap.put((char)0x05DC, (char)(11 + minVal)); 

		charMap.put((char)0x05DE, (char)(12 + minVal)); 
		charMap.put((char)0x05DD, (char)(12 + minVal)); 

		charMap.put((char)0x05E0, (char)(13 + minVal)); 
		charMap.put((char)0x05DF, (char)(13 + minVal)); 

		charMap.put((char)0x05E1, (char)(14 + minVal)); 

		charMap.put((char)0x05E2, (char)(15 + minVal)); 

		charMap.put((char)0x05E4, (char)(16 + minVal)); 
		charMap.put((char)0x05E3, (char)(16 + minVal)); 

		charMap.put((char)0x05E6, (char)(17 + minVal)); 
		charMap.put((char)0x05E5, (char)(17 + minVal)); 

		charMap.put((char)0x05E7, (char)(18 + minVal)); 

		charMap.put((char)0x05E8, (char)(19 + minVal)); 

		charMap.put((char)0x05E9, (char)(20 + minVal)); 

		charMap.put((char)0x05EA, (char)(21 + minVal)); 
		
	}
}
