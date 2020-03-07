package com.xynotec.dictdroid.engine.compare;

import java.util.HashMap;

public class CompareArmenian extends CompareBase
{

	char[] charCollation = 
	{	
		0x0561,
		0x0531,
		0x0562,
		0x0532,
		0x0563,
		0x0533,
		0x0564,
		0x0534,
		0x0565,
		0x0535,
		0x0566,
		0x0536,
		0x0567,
		0x0537,
		0x0568,
		0x0538,
		0x0569,
		0x0539,
		0x056A,
		0x053A,
		0x056B,
		0x053B,
		0x056C,
		0x053C,
		0x056D,
		0x053D,
		0x056E,
		0x053E,
		0x056F,
		0x053F,
		0x0570,
		0x0540,
		0x0571,
		0x0541,
		0x0572,
		0x0542,
		0x0573,
		0x0543,
		0x0574,
		0x0544,
		0x0575,
		0x0545,
		0x0576,
		0x0546,
		0x0577,
		0x0547,
		0x0578,
		0x0548,
		0x0579,
		0x0549,
		0x057A,
		0x054A,
		0x057B,
		0x054B,
		0x057C,
		0x054C,
		0x057D,
		0x054D,
		0x057E,
		0x054E,
		0x057F,
		0x054F,
		0x0580,
		0x0550,
		0x0581,
		0x0551,
		0x0582,
		0x0552,
		0x0583,
		0x0553,
		0x0584,
		0x0554,
		0x0587,
		//0x0535 0582
		0x0585,
		0x0555,
		0x0586,
		0x0556,
				
	};	

	public CompareArmenian()
	{
		charMap = new HashMap(charCollation.length);
		minVal = 0x7FFF;
		for(int i = 0; i < charCollation.length; i++)
		{
			if (charCollation[i] < minVal)
				minVal = charCollation[i];
		}
		
		charMap.put((char)0x0561, (char)(0 + minVal));	 
		charMap.put((char)0x0531, (char)(0 + minVal));	

		charMap.put((char)0x0562, (char)(1 + minVal));	 
		charMap.put((char)0x0532, (char)(1 + minVal));	

		charMap.put((char)0x0563, (char)(2 + minVal));	 
		charMap.put((char)0x0533, (char)(2 + minVal));	

		charMap.put((char)0x0564, (char)(3 + minVal));	 
		charMap.put((char)0x0534, (char)(3 + minVal));	

		charMap.put((char)0x0565, (char)(4 + minVal));	 
		charMap.put((char)0x0535, (char)(4 + minVal));	

		charMap.put((char)0x0566, (char)(5 + minVal));	 
		charMap.put((char)0x0536, (char)(5 + minVal));	

		charMap.put((char)0x0567, (char)(6 + minVal));	 
		charMap.put((char)0x0537, (char)(6 + minVal));	

		charMap.put((char)0x0568, (char)(7 + minVal));	 
		charMap.put((char)0x0538, (char)(7 + minVal));	

		charMap.put((char)0x0569, (char)(8 + minVal));	 
		charMap.put((char)0x0539, (char)(8 + minVal));	

		charMap.put((char)0x056A, (char)(9 + minVal));	 
		charMap.put((char)0x053A, (char)(9 + minVal));	

		charMap.put((char)0x056B, (char)(10 + minVal));	 
		charMap.put((char)0x053B, (char)(10 + minVal));	

		charMap.put((char)0x056C, (char)(11 + minVal));	 
		charMap.put((char)0x053C, (char)(11 + minVal));	

		charMap.put((char)0x056D, (char)(12 + minVal));	 
		charMap.put((char)0x053D, (char)(12 + minVal));	

		charMap.put((char)0x056E, (char)(13 + minVal));	 
		charMap.put((char)0x053E, (char)(13 + minVal));	

		charMap.put((char)0x056F, (char)(14 + minVal));	 
		charMap.put((char)0x053F, (char)(14 + minVal));	

		charMap.put((char)0x0570, (char)(15 + minVal));	 
		charMap.put((char)0x0540, (char)(15 + minVal));	

		charMap.put((char)0x0571, (char)(16 + minVal));	 
		charMap.put((char)0x0541, (char)(16 + minVal));	

		charMap.put((char)0x0572, (char)(17 + minVal));	 
		charMap.put((char)0x0542, (char)(17 + minVal));	

		charMap.put((char)0x0573, (char)(18 + minVal));	 
		charMap.put((char)0x0543, (char)(18 + minVal));	

		charMap.put((char)0x0574, (char)(19 + minVal));	 
		charMap.put((char)0x0544, (char)(19 + minVal));	

		charMap.put((char)0x0575, (char)(20 + minVal));	 
		charMap.put((char)0x0545, (char)(20 + minVal));	

		charMap.put((char)0x0576, (char)(21 + minVal));	 
		charMap.put((char)0x0546, (char)(21 + minVal));	

		charMap.put((char)0x0577, (char)(22 + minVal));	 
		charMap.put((char)0x0547, (char)(22 + minVal));	

		charMap.put((char)0x0578, (char)(23 + minVal));	 
		charMap.put((char)0x0548, (char)(23 + minVal));	

		charMap.put((char)0x0579, (char)(24 + minVal));	 
		charMap.put((char)0x0549, (char)(24 + minVal));	

		charMap.put((char)0x057A, (char)(25 + minVal));	 
		charMap.put((char)0x054A, (char)(25 + minVal));	

		charMap.put((char)0x057B, (char)(26 + minVal));	 
		charMap.put((char)0x054B, (char)(26 + minVal));	

		charMap.put((char)0x057C, (char)(27 + minVal));	 
		charMap.put((char)0x054C, (char)(27 + minVal));	

		charMap.put((char)0x057D, (char)(28 + minVal));	 
		charMap.put((char)0x054D, (char)(28 + minVal));	

		charMap.put((char)0x057E, (char)(29 + minVal));	 
		charMap.put((char)0x054E, (char)(29 + minVal));	

		charMap.put((char)0x057F, (char)(30 + minVal));	 
		charMap.put((char)0x054F, (char)(30 + minVal));	

		charMap.put((char)0x0580, (char)(31 + minVal));	 
		charMap.put((char)0x0550, (char)(31 + minVal));	

		charMap.put((char)0x0581, (char)(32 + minVal));	 
		charMap.put((char)0x0551, (char)(32 + minVal));	

		charMap.put((char)0x0582, (char)(33 + minVal));	 
		charMap.put((char)0x0552, (char)(33 + minVal));	

		charMap.put((char)0x0583, (char)(34 + minVal));	 
		charMap.put((char)0x0553, (char)(34 + minVal));	

		charMap.put((char)0x0584, (char)(35 + minVal));	 
		charMap.put((char)0x0554, (char)(35 + minVal));	

		charMap.put((char)0x0587, (char)(36 + minVal));	 
		//charMap.put((char)0x0535 0582, (char)(36 + minVal));	 

		charMap.put((char)0x0585, (char)(37 + minVal));	 
		charMap.put((char)0x0555, (char)(37 + minVal));	

		charMap.put((char)0x0586, (char)(38 + minVal));	 
		charMap.put((char)0x0556, (char)(38 + minVal));	
	}
	
	protected String getComparableKey(String key)
	{
		StringBuilder sb = new StringBuilder();
		
		int key_length = key.length(); 
		for (int i = 0; i < key_length; ++i) 
		{
			char c = key.charAt(i);
			Character val = 0;
			boolean bLookup = charMap.containsKey(c);
			if (bLookup)
			{
				val = (Character)charMap.get(c);				
				switch(c)
				{
					case 0x0535:
						//0535 0582, 36 + minVal);	 
						if ((i + 1 < key_length) && (key.charAt(i + 1) == 0x0582))
						{
							sb.append((char)(36 + minVal));
							i++;
						}
						else
						{
							sb.append(val.charValue());							
						}
						break;
				


					default:
						sb.append(val.charValue());						
						break;
				}
			}
			else
			{
				bLookup = specialCharMap.containsKey(c);
				if (bLookup)
				{	
					val = (Character)specialCharMap.get(c);
					sb.append(val.charValue());					
				}
				else
				{
					sb.append(Character.toLowerCase(c));
				}		
			}
		}
		return sb.toString();
	}
}
