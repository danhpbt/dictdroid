package com.xynotec.dictdroid.engine.compare;

import java.util.HashMap;

public class CompareCroatian extends CompareBase
{
	
	char[] charCollation = 
	{		
		0x0061,	
		0x0041,
		0x0062, 	
		0x0042,
		0x0063, 	
		0x0043,
		0x010D, 	
		0x010C,
		0x0107, 	
		0x0106,
		0x0064, 	
		0x0044,
		//0064 0x017E 	D�
		//0044 0x017E 	D�
		//0044 0x017D
		0x0111, 	
		0x0110,
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
		//006C 006A 	Lj
		//004C 006A 	LJ
		//004C 004A
		0x006D, 	
		0x004D,
		0x006E, 	
		0x004E,
		//006E 006A 	Nj
		//004E 006A 	NJ
		//004E 004A
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
		0x0076, 	
		0x0056,
		0x007A, 	
		0x005A,
		0x017E, 	
		0x017D,			
	};	

	public CompareCroatian()
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

		charMap.put((char)0x0062, (char)(1 + minVal));  	
		charMap.put((char)0x0042, (char)(1 + minVal));

		charMap.put((char)0x0063, (char)(2 + minVal));  	
		charMap.put((char)0x0043, (char)(2 + minVal));

		charMap.put((char)0x010D, (char)(3 + minVal));  	
		charMap.put((char)0x010C, (char)(3 + minVal));

		charMap.put((char)0x0107, (char)(4 + minVal));  	
		charMap.put((char)0x0106, (char)(4 + minVal));

		charMap.put((char)0x0064, (char)(5 + minVal));  	
		charMap.put((char)0x0044, (char)(5 + minVal));

		//0064 017E 	D�	 , (char)(6 + minVal)); 
		//0044 017E 	D�	 , (char)(6 + minVal));
		//0044 017D

		charMap.put((char)0x0111, (char)(7 + minVal));  	
		charMap.put((char)0x0110, (char)(7 + minVal));

		charMap.put((char)0x0065, (char)(8 + minVal));  	
		charMap.put((char)0x0045, (char)(8 + minVal));

		charMap.put((char)0x0066, (char)(9 + minVal));  	
		charMap.put((char)0x0046, (char)(9 + minVal));

		charMap.put((char)0x0067, (char)(10 + minVal));  	
		charMap.put((char)0x0047, (char)(10 + minVal));

		charMap.put((char)0x0068, (char)(11 + minVal));  	
		charMap.put((char)0x0048, (char)(11 + minVal));

		charMap.put((char)0x0069, (char)(12 + minVal));  	
		charMap.put((char)0x0049, (char)(12 + minVal));

		charMap.put((char)0x006A, (char)(13 + minVal));  	
		charMap.put((char)0x004A, (char)(13 + minVal));

		charMap.put((char)0x006B, (char)(14 + minVal));  	
		charMap.put((char)0x004B, (char)(14 + minVal));

		charMap.put((char)0x006C, (char)(15 + minVal));  	
		charMap.put((char)0x004C, (char)(15 + minVal));

		//006C 006A 	Lj	 , (char)(16 + minVal)); 
		//004C 006A 	LJ	 , (char)(16 + minVal));
		//004C 004A

		charMap.put((char)0x006D, (char)(17 + minVal));  	
		charMap.put((char)0x004D, (char)(17 + minVal));

		charMap.put((char)0x006E, (char)(18 + minVal));  	
		charMap.put((char)0x004E, (char)(18 + minVal));

		//006E 006A 	Nj	 , (char)(19 + minVal)); 
		//004E 006A 	NJ	 , (char)(19 + minVal));
		//004E 004A

		charMap.put((char)0x006F, (char)(20 + minVal));  	
		charMap.put((char)0x004F, (char)(20 + minVal));

		charMap.put((char)0x0070, (char)(21 + minVal));  	
		charMap.put((char)0x0050, (char)(21 + minVal));

		charMap.put((char)0x0072, (char)(22 + minVal));  	
		charMap.put((char)0x0052, (char)(22 + minVal));

		charMap.put((char)0x0073, (char)(23 + minVal));  	
		charMap.put((char)0x0053, (char)(23 + minVal));

		charMap.put((char)0x0161, (char)(24 + minVal)); 
		charMap.put((char)0x0160, (char)(24 + minVal));

		charMap.put((char)0x0074, (char)(25 + minVal));  	
		charMap.put((char)0x0054, (char)(25 + minVal));

		charMap.put((char)0x0075, (char)(26 + minVal));  	
		charMap.put((char)0x0055, (char)(26 + minVal));

		charMap.put((char)0x0076, (char)(27 + minVal));  	
		charMap.put((char)0x0056, (char)(27 + minVal));

		charMap.put((char)0x007A, (char)(28 + minVal));  	
		charMap.put((char)0x005A, (char)(28 + minVal));

		charMap.put((char)0x017E, (char)(29 + minVal));  	
		charMap.put((char)0x017D, (char)(29 + minVal));
		
		
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
					case 0x0064:
						//0064 017E 	D�	 , 6 + minVal); 
						if ((i + 1 < key_length) && (key.charAt(i + 1) == 0x017E))
						{
							sb.append((char)(6 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}					
						break;
					case 0x0044:					
						//0044 017E 	D�	 , 6 + minVal);
						//0044 017D
						if ((i + 1 < key_length) && ((key.charAt(i + 1) == 0x017E) || (key.charAt(i + 1) == 0x017D)))
						{
							sb.append((char)(6 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}					
						break;

					case 0x006C:
						//006C 006A 	Lj	 , 16 + minVal); 
						if ((i + 1 < key_length) && (key.charAt(i + 1) == 0x006A))
						{
							sb.append((char)(16 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;
					case 0x004C:					
						//004C 006A 	LJ	 , 16 + minVal);
						//004C 004A
						if ((i + 1 < key_length) && ((key.charAt(i + 1) == 0x006A) || (key.charAt(i + 1) == 0x004A)))
						{
							sb.append((char)(16 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					case 0x006E:
						//006E 006A 	Nj	 , 19 + minVal); 
						if ((i + 1 < key_length) && (key.charAt(i + 1) == 0x006A))
						{
							sb.append((char)(19 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;
					case 0x004E:					
						//004E 006A 	NJ	 , 19 + minVal);
						//004E 004A
						if ((i + 1 < key_length) && ((key.charAt(i + 1) == 0x006A) || (key.charAt(i + 1) == 0x004A)))
						{
							sb.append((char)(19 + minVal));
							
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
