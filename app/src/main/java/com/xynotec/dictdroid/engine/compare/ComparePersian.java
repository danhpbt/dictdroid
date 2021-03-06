package com.xynotec.dictdroid.engine.compare;

import java.util.HashMap;

public class ComparePersian extends CompareBase
{
	char[] charCollation = 
	{
		0x0622, 
		0x0627, 
		0x0671, 
		0x0621, 
		0x0623, 
		0x0625, 
		0x0624, 
		0x0626, 
		0x0628, 
		0x067E, 
		0x062A, 
		0x062B, 
		0x062C, 
		0x0686, 
		0x062D, 
		0x062E, 
		0x062F, 
		0x0630, 
		0x0631, 
		0x0632, 
		0x0698, 
		0x0633, 
		0x0634, 
		0x0635, 
		0x0636, 
		0x0637, 
		0x0638, 
		0x0639, 
		0x063A, 
		0x0641, 
		0x0642, 
		0x06A9, 
		0x0643, 
		0x06AF, 
		0x0644, 
		0x0645, 
		0x0646, 
		0x0648, 
		0x0647, 
		0x0629, 
		0x06CC, 
		0x0649, 
		0x064A, 
	};
	
	public ComparePersian()
	{
		charMap = new HashMap(charCollation.length);
		minVal = 0x7FFF;
		for(int i = 0; i < charCollation.length; i++)
		{
			if (charCollation[i] < minVal)
				minVal = charCollation[i];
		}
		
		charMap.put((char)0x0622, (char)(0 + minVal));	

		charMap.put((char)0x0627, (char)(1 + minVal));	
		charMap.put((char)0x0671, (char)(1 + minVal));	

		charMap.put((char)0x0621, (char)(2 + minVal));	
		charMap.put((char)0x0623, (char)(2 + minVal));	
		charMap.put((char)0x0625, (char)(2 + minVal));	
		charMap.put((char)0x0624, (char)(2 + minVal));	
		charMap.put((char)0x0626, (char)(2 + minVal));	

		charMap.put((char)0x0628, (char)(3 + minVal));	

		charMap.put((char)0x067E, (char)(4 + minVal));	

		charMap.put((char)0x062A, (char)(5 + minVal));	

		charMap.put((char)0x062B, (char)(6 + minVal));	

		charMap.put((char)0x062C, (char)(7 + minVal));	

		charMap.put((char)0x0686, (char)(8 + minVal));	

		charMap.put((char)0x062D, (char)(9 + minVal));	

		charMap.put((char)0x062E, (char)(10 + minVal));	

		charMap.put((char)0x062F, (char)(11 + minVal));	

		charMap.put((char)0x0630, (char)(12 + minVal));	

		charMap.put((char)0x0631, (char)(13 + minVal));	

		charMap.put((char)0x0632, (char)(14 + minVal));	

		charMap.put((char)0x0698, (char)(15 + minVal));	

		charMap.put((char)0x0633, (char)(16 + minVal));	

		charMap.put((char)0x0634, (char)(17 + minVal));	

		charMap.put((char)0x0635, (char)(18 + minVal));	

		charMap.put((char)0x0636, (char)(19 + minVal));	

		charMap.put((char)0x0637, (char)(20 + minVal));	

		charMap.put((char)0x0638, (char)(21 + minVal));	

		charMap.put((char)0x0639, (char)(22 + minVal));	

		charMap.put((char)0x063A, (char)(23 + minVal));	

		charMap.put((char)0x0641, (char)(24 + minVal));	

		charMap.put((char)0x0642, (char)(25 + minVal));	

		charMap.put((char)0x06A9, (char)(26 + minVal));	
		charMap.put((char)0x0643, (char)(26 + minVal));	

		charMap.put((char)0x06AF, (char)(27 + minVal));	

		charMap.put((char)0x0644, (char)(28 + minVal));	

		charMap.put((char)0x0645, (char)(29 + minVal));	

		charMap.put((char)0x0646, (char)(30 + minVal));	

		charMap.put((char)0x0648, (char)(31 + minVal));	

		charMap.put((char)0x0647, (char)(32 + minVal));	
		charMap.put((char)0x0629, (char)(32 + minVal));	

		charMap.put((char)0x06CC, (char)(33 + minVal));	
		charMap.put((char)0x0649, (char)(33 + minVal));	
		charMap.put((char)0x064A, (char)(33 + minVal));	
	}
}
