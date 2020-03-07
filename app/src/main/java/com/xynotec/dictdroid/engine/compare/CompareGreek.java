package com.xynotec.dictdroid.engine.compare;

import java.util.HashMap;

public class CompareGreek extends CompareBase
{
	char[] charCollation = 
	{	
		0x03B1,	
		0x0391,	
		0x03AC,	
		0x0386,
		0x03B2,	
		0x0392,
		0x03B3,	
		0x0393,
		0x03B4,	
		0x0394,
		0x03B5,	
		0x0395,	
		0x03AD,	
		0x0388,
		0x03B6,	
		0x0396,
		0x03B7,	
		0x0397,	
		0x03AE,	
		0x0389,
		0x03B8,	
		0x0398,
		0x03B9,	
		0x0399,	
		0x03AF,	
		0x038A,	
		0x03CA,	
		0x03AA,	
		0x0390,
		0x03BA,	
		0x039A,
		0x03BB, 	
		0x039B,
		0x03BC, 	
		0x039C,
		0x03BD, 	
		0x039D,
		0x03BE, 	
		0x039E,
		0x03BF, 	
		0x039F, 	
		0x03CC, 	
		0x038C,
		0x03C0, 	
		0x03A0,
		0x03C1, 	
		0x03A1,
		0x03C3, 	
		0x03A3, 	
		0x03C2,
		0x03C4, 	
		0x03A4,
		0x03C5, 	
		0x03A5, 	
		0x03CD, 	
		0x038E, 	
		0x03CB, 	
		0x03AB, 	
		0x03B0,
		0x03C6, 	
		0x03A6,
		0x03C7, 	
		0x03A7,
		0x03C8, 	
		0x03A8,
		0x03C9, 	
		0x03A9, 	
		0x03CE, 	
		0x038F,	
	};	

	public CompareGreek()
	{
		charMap = new HashMap(charCollation.length);
		minVal = 0x7FFF;
		for(int i = 0; i < charCollation.length; i++)
		{
			if (charCollation[i] < minVal)
				minVal = charCollation[i];
		}
		
		charMap.put((char)0x03B1, (char)(0 + minVal));  	
		charMap.put((char)0x0391, (char)(0 + minVal));  	
		charMap.put((char)0x03AC, (char)(0 + minVal));  	
		charMap.put((char)0x0386, (char)(0 + minVal)); 
		
		charMap.put((char)0x03B2, (char)(1 + minVal));  	
		charMap.put((char)0x0392, (char)(1 + minVal)); 
		
		charMap.put((char)0x03B3, (char)(2 + minVal));  	
		charMap.put((char)0x0393, (char)(2 + minVal)); 
		
		charMap.put((char)0x03B4, (char)(3 + minVal));  	
		charMap.put((char)0x0394, (char)(3 + minVal)); 
		
		charMap.put((char)0x03B5, (char)(4 + minVal));  	
		charMap.put((char)0x0395, (char)(4 + minVal));  	
		charMap.put((char)0x03AD, (char)(4 + minVal));  	
		charMap.put((char)0x0388, (char)(4 + minVal)); 
		
		charMap.put((char)0x03B6, (char)(5 + minVal));  	
		charMap.put((char)0x0396, (char)(5 + minVal)); 
		
		charMap.put((char)0x03B7, (char)(6 + minVal));  	
		charMap.put((char)0x0397, (char)(6 + minVal));  	
		charMap.put((char)0x03AE, (char)(6 + minVal));  	
		charMap.put((char)0x0389, (char)(6 + minVal)); 
		
		charMap.put((char)0x03B8, (char)(7 + minVal));  	
		charMap.put((char)0x0398, (char)(7 + minVal)); 
		
		charMap.put((char)0x03B9, (char)(8 + minVal));  	
		charMap.put((char)0x0399, (char)(8 + minVal));  	
		charMap.put((char)0x03AF, (char)(8 + minVal));  	
		charMap.put((char)0x038A, (char)(8 + minVal));  	
		charMap.put((char)0x03CA, (char)(8 + minVal));  	
		charMap.put((char)0x03AA, (char)(8 + minVal));  	
		charMap.put((char)0x0390, (char)(8 + minVal)); 
							 
		charMap.put((char)0x03BA, (char)(9 + minVal));  	
		charMap.put((char)0x039A, (char)(9 + minVal)); 
		
		charMap.put((char)0x03BB, (char)(10 + minVal));  	
		charMap.put((char)0x039B, (char)(10 + minVal)); 
		
		charMap.put((char)0x03BC, (char)(11 + minVal));  	
		charMap.put((char)0x039C, (char)(11 + minVal)); 
		
		charMap.put((char)0x03BD, (char)(12 + minVal));  	
		charMap.put((char)0x039D, (char)(12 + minVal)); 
		
		charMap.put((char)0x03BE, (char)(13 + minVal));  	
		charMap.put((char)0x039E, (char)(13 + minVal)); 
		
		charMap.put((char)0x03BF, (char)(14 + minVal));  	
		charMap.put((char)0x039F, (char)(14 + minVal));  	
		charMap.put((char)0x03CC, (char)(14 + minVal));  	
		charMap.put((char)0x038C, (char)(14 + minVal)); 
		
		charMap.put((char)0x03C0, (char)(15 + minVal));  	
		charMap.put((char)0x03A0, (char)(15 + minVal)); 
		
		charMap.put((char)0x03C1, (char)(16 + minVal));  	
		charMap.put((char)0x03A1, (char)(16 + minVal)); 
		
		charMap.put((char)0x03C3, (char)(17 + minVal));  	
		charMap.put((char)0x03A3, (char)(17 + minVal));  	
		charMap.put((char)0x03C2, (char)(17 + minVal)); 
							 
		charMap.put((char)0x03C4, (char)(18 + minVal));  	
		charMap.put((char)0x03A4, (char)(18 + minVal)); 
		
		charMap.put((char)0x03C5, (char)(19 + minVal));  	
		charMap.put((char)0x03A5, (char)(19 + minVal));  	
		charMap.put((char)0x03CD, (char)(19 + minVal));  	
		charMap.put((char)0x038E, (char)(19 + minVal));  	
		charMap.put((char)0x03CB, (char)(19 + minVal));  	
		charMap.put((char)0x03AB, (char)(19 + minVal));  	
		charMap.put((char)0x03B0, (char)(19 + minVal)); 
							 
		charMap.put((char)0x03C6, (char)(20 + minVal));  	
		charMap.put((char)0x03A6, (char)(20 + minVal)); 
		
		charMap.put((char)0x03C7, (char)(21 + minVal));  	
		charMap.put((char)0x03A7, (char)(21 + minVal)); 
		
		charMap.put((char)0x03C8, (char)(22 + minVal));  	
		charMap.put((char)0x03A8, (char)(22 + minVal)); 
		
		charMap.put((char)0x03C9, (char)(23 + minVal));  	
		charMap.put((char)0x03A9, (char)(23 + minVal));  	
		charMap.put((char)0x03CE, (char)(23 + minVal));  	
		charMap.put((char)0x038F, (char)(23 + minVal)); 
	}
}
