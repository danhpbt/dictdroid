package com.xynotec.dictdroid.engine.compare;

import java.util.HashMap;

public class CompareYiddish extends CompareBase
{
	
	char[] charCollation = 
	{		
		0x05D0,	
		//0x05D0 05B7 	
		//0x05D0 05B8
		0x05D1,
		//0x05D1 05BF
		0x05D2,
		0x05D3,
		0x05D4,
		0x05D5,	
		//0x05D5 05BC 	
		0x05F0, 	
		0x05F1,
		0x05D6,
		0x05D7,
		0x05D8,
		0x05D9,	
		//0x05D9 05B4 	
		0x05F2, 	
		//0x05F2 05B7
		//0x05DB 05BC
		0x05DB, 	
		0x05DA,
		0x05DC,
		0x05DE,	
		0x05DD,
		0x05E0, 	
		0x05DF,
		0x05E1,
		0x05E2,
		//0x05E4 05BC
		//0x05E4 05BF 	
		0x05E3,
		0x05E6,	
		0x05E5,
		0x05E7,
		0x05E8,
		0x05E9,
		//0x05E9 05C2
		//0x05EA 05BC
		0x05EA,			
	};	

	public CompareYiddish()
	{
		charMap = new HashMap(charCollation.length);
		minVal = 0x7FFF;
		for(int i = 0; i < charCollation.length; i++)
		{
			if (charCollation[i] < minVal)
				minVal = charCollation[i];
		}
		
		charMap.put((char)0x05D0, (char)(0 + minVal)); 	
		//05D0 05B7 			 , (char)(0 + minVal));
		//05D0 05B8			 , (char)(0 + minVal));

		charMap.put((char)0x05D1, (char)(1 + minVal));

		//05D1 05BF			 , (char)(2 + minVal));

		charMap.put((char)0x05D2, (char)(3 + minVal));

		charMap.put((char)0x05D3, (char)(4 + minVal));

		charMap.put((char)0x05D4, (char)(5 + minVal));

		charMap.put((char)0x05D5, (char)(6 + minVal)); 	
		//05D5 05BC 			 , (char)(6 + minVal));
		charMap.put((char)0x05F0, (char)(6 + minVal)); 	
		charMap.put((char)0x05F1, (char)(6 + minVal));

		charMap.put((char)0x05D6, (char)(7 + minVal));

		charMap.put((char)0x05D7, (char)(8 + minVal));

		charMap.put((char)0x05D8, (char)(9 + minVal));

		charMap.put((char)0x05D9, (char)(10 + minVal)); 	
		//05D9 05B4 			 , (char)(10 + minVal));
		charMap.put((char)0x05F2, (char)(10 + minVal)); 	
		//05F2 05B7			 , (char)(10 + minVal));

		//05DB 05BC			 , (char)(11 + minVal));

		charMap.put((char)0x05DB, (char)(12 + minVal)); 	
		charMap.put((char)0x05DA, (char)(12 + minVal));

		charMap.put((char)0x05DC, (char)(13 + minVal));

		charMap.put((char)0x05DE, (char)(14 + minVal)); 	
		charMap.put((char)0x05DD, (char)(14 + minVal));

		charMap.put((char)0x05E0, (char)(15 + minVal)); 	
		charMap.put((char)0x05DF, (char)(15 + minVal));

		charMap.put((char)0x05E1, (char)(16 + minVal));

		charMap.put((char)0x05E2, (char)(17 + minVal));

		//05E4 05BC			 , (char)(18 + minVal));
			
		//05E4 05BF 			 , (char)(19 + minVal));
		charMap.put((char)0x05E3, (char)(19 + minVal));

		charMap.put((char)0x05E6, (char)(20 + minVal)); 	
		charMap.put((char)0x05E5, (char)(20 + minVal));

		charMap.put((char)0x05E7, (char)(21 + minVal));

		charMap.put((char)0x05E8, (char)(22 + minVal));

		charMap.put((char)0x05E9, (char)(23 + minVal));

		//05E9 05C2			 , (char)(24 + minVal));
		
		//05EA 05BC			 , (char)(25 + minVal));

		charMap.put((char)0x05EA, (char)(26 + minVal));
		
	
		
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
					case 0x05D0:
						//05D0 05B7			 , 0 + minVal);
						//05D0 05B8			 , 0 + minVal);		
						if ((i + 1 < key_length) && ((key.charAt(i + 1) == 0x05B7) || (key.charAt(i + 1) == 0x05B8)))
						{
							sb.append((char)(0 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;
					
					case 0x05D1:
						//05D1 05BF			 , 2 + minVal);
						if ((i + 1 < key_length) && (key.charAt(i + 1) == 0x05BF))
						{
							sb.append((char)(2 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					case 0x05D5:
						//05D5 05BC			 , 6 + minVal);
						if ((i + 1 < key_length) && (key.charAt(i + 1) == 0x05BC))
						{
							sb.append((char)(6 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;
						
					case 0x05D9:
						//05D9 05B4 			 , 10 + minVal);
						if ((i + 1 < key_length) && (key.charAt(i + 1) == 0x05B4))
						{
							sb.append((char)(10 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;
					case 0x05F2:
						//05F2 05B7			 , 10 + minVal);
						if ((i + 1 < key_length) && (key.charAt(i + 1) == 0x05B7))
						{
							sb.append((char)(10 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					case 0x05DB:
						//05DB 05BC			 , 11 + minVal);
						if ((i + 1 < key_length) && (key.charAt(i + 1) == 0x05BC))
						{
							sb.append((char)(11 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					case 0x05E4://////////////////////////////
						//05E4 05BC			 , 18 + minVal);
						//05E4 05BF 			 , 19 + minVal);
						if ((i + 1 < key_length) && (key.charAt(i + 1) == 0x05BC))
						{
							sb.append((char)(18 + minVal));
							
							i++;
						}
						else if (key.charAt(i + 1) == 0x05BF)
						{
							sb.append((char)(19 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					case 0x05E9:					
						//05E9 05C2			 , 24 + minVal);
						if ((i + 1 < key_length) && (key.charAt(i + 1) == 0x05C2))
						{
							sb.append((char)(24 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					case 0x05EA:
						//05EA 05BC			 , 25 + minVal);
						if ((i + 1 < key_length) && (key.charAt(i + 1) == 0x05BC))
						{
							sb.append((char)(25 + minVal));
							
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
