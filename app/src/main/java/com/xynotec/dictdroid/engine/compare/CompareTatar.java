package com.xynotec.dictdroid.engine.compare;

import java.util.HashMap;

public class CompareTatar extends CompareBase
{
	char[] charCollation = 
	{		
		0x0430,
		0x0410,
		0x04D9,
		0x04D8,
		0x0431, 
		0x0411,
		0x0432, 
		0x0412,
		0x0433, 
		0x0413,
		0x0434, 
		0x0414,
		0x0435, 
		0x0415, 
		0x0451,  
		0x0401,
		0x0436,  
		0x0416,
		0x0497,  
		0x0496,
		0x0437, 
		0x0417,
		0x0438, 
		0x0418,
		0x0439,  
		0x0419,
		0x043A,  
		0x041A,
		0x043B,  
		0x041B,
		0x043C, 
		0x041C,
		0x043D, 
		0x041D,
		0x04A3,  
		0x04A2,
		0x043E,  
		0x041E,
		0x04E9,  
		0x04E8,
		0x043F, 
		0x041F,
		0x0440, 
		0x0420,
		0x0441,  
		0x0421,
		0x0442,  
		0x0422,
		0x0443,  
		0x0423,
		0x04AF, 
		0x04AE,
		0x0444, 
		0x0424,
		0x0445,  
		0x0425,
		0x04BB,  
		0x04BA,
		0x0446,  
		0x0426,
		0x0447, 
		0x0427,
		0x0448, 
		0x0428,
		0x0449,  
		0x0429,
		0x044A,  
		0x042A,
		0x044B,  
		0x042B,
		0x044C, 
		0x042C,
		0x044D, 
		0x042D,
		0x044E,  
		0x042E,
		0x044F,  
		0x042F,		
	};	

	public CompareTatar()
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

		charMap.put((char)0x04D9, (char)(1 + minVal));	
		charMap.put((char)0x04D8, (char)(1 + minVal));	

		charMap.put((char)0x0431, (char)(2 + minVal));	
		charMap.put((char)0x0411, (char)(2 + minVal));	

		charMap.put((char)0x0432, (char)(3 + minVal));	
		charMap.put((char)0x0412, (char)(3 + minVal));	

		charMap.put((char)0x0433, (char)(4 + minVal));	
		charMap.put((char)0x0413, (char)(4 + minVal));	

		charMap.put((char)0x0434, (char)(5 + minVal));	
		charMap.put((char)0x0414, (char)(5 + minVal));	

		charMap.put((char)0x0435, (char)(6 + minVal));	
		charMap.put((char)0x0415, (char)(6 + minVal));	
		charMap.put((char)0x0451, (char)(6 + minVal));	
		charMap.put((char)0x0401, (char)(6 + minVal));	

		charMap.put((char)0x0436, (char)(7 + minVal));	
		charMap.put((char)0x0416, (char)(7 + minVal));	

		charMap.put((char)0x0497, (char)(8 + minVal));	
		charMap.put((char)0x0496, (char)(8 + minVal));	

		charMap.put((char)0x0437, (char)(9 + minVal));	
		charMap.put((char)0x0417, (char)(9 + minVal));	

		charMap.put((char)0x0438, (char)(10 + minVal));	
		charMap.put((char)0x0418, (char)(10 + minVal));	

		charMap.put((char)0x0439, (char)(11 + minVal));	
		charMap.put((char)0x0419, (char)(11 + minVal));	

		charMap.put((char)0x043A, (char)(12 + minVal));	
		charMap.put((char)0x041A, (char)(12 + minVal));	

		charMap.put((char)0x043B, (char)(13 + minVal));	
		charMap.put((char)0x041B, (char)(13 + minVal));	

		charMap.put((char)0x043C, (char)(14 + minVal));	
		charMap.put((char)0x041C, (char)(14 + minVal));	

		charMap.put((char)0x043D, (char)(15 + minVal));	
		charMap.put((char)0x041D, (char)(15 + minVal));	

		charMap.put((char)0x04A3, (char)(16 + minVal));	
		charMap.put((char)0x04A2, (char)(16 + minVal));	

		charMap.put((char)0x043E, (char)(17 + minVal));	
		charMap.put((char)0x041E, (char)(17 + minVal));	

		charMap.put((char)0x04E9, (char)(18 + minVal));	
		charMap.put((char)0x04E8, (char)(18 + minVal));	

		charMap.put((char)0x043F, (char)(19 + minVal));	
		charMap.put((char)0x041F, (char)(19 + minVal));	

		charMap.put((char)0x0440, (char)(20 + minVal));	
		charMap.put((char)0x0420, (char)(20 + minVal));	

		charMap.put((char)0x0441, (char)(21 + minVal));	
		charMap.put((char)0x0421, (char)(21 + minVal));	

		charMap.put((char)0x0442, (char)(22 + minVal));	
		charMap.put((char)0x0422, (char)(22 + minVal));	

		charMap.put((char)0x0443, (char)(23 + minVal));	
		charMap.put((char)0x0423, (char)(23 + minVal));	

		charMap.put((char)0x04AF, (char)(24 + minVal));	
		charMap.put((char)0x04AE, (char)(24 + minVal));	

		charMap.put((char)0x0444, (char)(25 + minVal));	
		charMap.put((char)0x0424, (char)(25 + minVal));	

		charMap.put((char)0x0445, (char)(26 + minVal));	
		charMap.put((char)0x0425, (char)(26 + minVal));	

		charMap.put((char)0x04BB, (char)(27 + minVal));	
		charMap.put((char)0x04BA, (char)(27 + minVal));	

		charMap.put((char)0x0446, (char)(28 + minVal));	
		charMap.put((char)0x0426, (char)(28 + minVal));	

		charMap.put((char)0x0447, (char)(29 + minVal));	
		charMap.put((char)0x0427, (char)(29 + minVal));	

		charMap.put((char)0x0448, (char)(30 + minVal));	
		charMap.put((char)0x0428, (char)(30 + minVal));	

		charMap.put((char)0x0449, (char)(31 + minVal));	
		charMap.put((char)0x0429, (char)(31 + minVal));	

		charMap.put((char)0x044A, (char)(32 + minVal));	
		charMap.put((char)0x042A, (char)(32 + minVal));	

		charMap.put((char)0x044B, (char)(33 + minVal));	
		charMap.put((char)0x042B, (char)(33 + minVal));	

		charMap.put((char)0x044C, (char)(34 + minVal));	
		charMap.put((char)0x042C, (char)(34 + minVal));	

		charMap.put((char)0x044D, (char)(35 + minVal));	
		charMap.put((char)0x042D, (char)(35 + minVal));	

		charMap.put((char)0x044E, (char)(36 + minVal));	
		charMap.put((char)0x042E, (char)(36 + minVal));	

		charMap.put((char)0x044F, (char)(37 + minVal));	
		charMap.put((char)0x042F, (char)(37 + minVal));	
	
		
	}
}
