package com.xynotec.dictdroid.engine.compare;

import java.util.HashMap;

public class CompareLithuanian extends CompareBase
{
	
	char[] charCollation = 
	{		
		0x0061,
		0x0041,
		0x00E1,
		0x00C1,
		0x00E0,
		0x00C0,
		0x00E3,
		0x00C3,
		0x0105,
		0x0104,
		//0105 0301
		//0104 0301
		//0105 0303
		//0104 0303
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
		0x1EBD,
		0x1EBC,
		0x0119,
		0x0118,
		//0119 0301 	E�
		//0118 0301 	e~
		//0119 0303 	E~
		//0118 0303
		0x0117,	
		0x0116,	
		//0117 0301 	E�
		//0116 0301 	e~
		//0117 0303 	E~
		//0116 0303
		0x0066,
		0x0046,
		0x0067,
		0x0047,
		0x0068,
		0x0048,
		0x0069,
		0x0049,
		//0069 0307 0301 	�
		0x00CD,	
		//0069 0307 0300 	�
		0x00CC,	
		//0069 0307 0303 	I
		0x0128,	
		0x012F, 	
		0x012E, 	
		//012F 0307 0301 	I�
		//012E 0301 	i?~
		//012F 0307 0303 	I~
		//012E 0303	
		0x0079,
		0x0059,
		0x00FD,
		0x00DD,
		0x1EF9,
		0x1EF8,
		0x006A,
		0x004A,
		//006A 0307 0303 	J~
		//004A 0303
		0x006B,
		0x004B,
		0x006C,
		0x004C,
		//006C 0303 	L~
		//004C 0303
		0x006D,
		0x004D,	
		//006D 0303 	M~
		//004D 0303
		0x006E,
		0x004E,
		0x00F1,
		0x00D1,
		0x006F,
		0x004F,
		0x00F3,
		0x00D3,
		0x00F2,
		0x00D2,
		0x00F5,
		0x00D5,
		0x0070,
		0x0050,
		0x0072,
		0x0052,
		//0072 0303 	R~
		//0052 0303
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
		0x0169,
		0x0168,
		0x0173,
		0x0172,
		//0173 0301 	U�
		//0172 0301 	u~
		//0173 0303 	U~
		//0172 0303	
		0x016B,	
		0x016A,	
		//016B 0301 	U�
		//016A 0301 	u~
		//016B 0303 	U~
		//016A 0303
		0x0076,
		0x0056,
		0x007A,
		0x005A,
		0x017E,
		0x017D,	 			
	};	

	public CompareLithuanian()
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
		charMap.put((char)0x00E3, (char)(0 + minVal));  	
		charMap.put((char)0x00C3, (char)(0 + minVal)); 
		charMap.put((char)0x0105, (char)(0 + minVal));  	
		charMap.put((char)0x0104, (char)(0 + minVal));  	
		//0105 0301 	A�	 , (char)(0 + minVal)); 
		//0104 0301 	a~	 , (char)(0 + minVal)); 
		//0105 0303 	A~	 , (char)(0 + minVal)); 
		//0104 0303			 , (char)(0 + minVal)); 

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
		charMap.put((char)0x1EBD, (char)(5 + minVal));  	
		charMap.put((char)0x1EBC, (char)(5 + minVal)); 
		charMap.put((char)0x0119, (char)(5 + minVal));  	
		charMap.put((char)0x0118, (char)(5 + minVal));  	
		//0119 0301 	E�	 , (char)(5 + minVal)); 
		//0118 0301 	e~	 , (char)(5 + minVal)); 
		//0119 0303 	E~	 , (char)(5 + minVal)); 
		//0118 0303			 , (char)(5 + minVal)); 
		charMap.put((char)0x0117, (char)(5 + minVal));  	
		charMap.put((char)0x0116, (char)(5 + minVal));  	
		//0117 0301 	E�	 , (char)(5 + minVal)); 
		//0116 0301 	e~	 , (char)(5 + minVal)); 
		//0117 0303 	E~	 , (char)(5 + minVal)); 
		//0116 0303			 , (char)(5 + minVal)); 

		charMap.put((char)0x0066, (char)(6 + minVal));  	
		charMap.put((char)0x0046, (char)(6 + minVal)); 

		charMap.put((char)0x0067, (char)(7 + minVal));  	
		charMap.put((char)0x0047, (char)(7 + minVal)); 

		charMap.put((char)0x0068, (char)(8 + minVal));  	
		charMap.put((char)0x0048, (char)(8 + minVal)); 

		charMap.put((char)0x0069, (char)(9 + minVal));  	
		charMap.put((char)0x0049, (char)(9 + minVal));  	
		//0069 0307 0301 	�, (char)(9 + minVal));
		charMap.put((char)0x00CD, (char)(9 + minVal));  	
		//0069 0307 0300 	�, (char)(9 + minVal));
		charMap.put((char)0x00CC, (char)(9 + minVal));  	
		//0069 0307 0303 	I, (char)(9 + minVal));
		charMap.put((char)0x0128, (char)(9 + minVal)); 	
		charMap.put((char)0x012F, (char)(9 + minVal));  	
		charMap.put((char)0x012E, (char)(9 + minVal)); 	
		//012F 0307 0301 	I�, (char)(9 + minVal));
		//012E 0301 	i?~	  , (char)(9 + minVal));
		//012F 0307 0303 	I~, (char)(9 + minVal));
		//012E 0303			 , (char)(9 + minVal));
		charMap.put((char)0x0079, (char)(9 + minVal));  	
		charMap.put((char)0x0059, (char)(9 + minVal));  	
		charMap.put((char)0x00FD, (char)(9 + minVal));  	
		charMap.put((char)0x00DD, (char)(9 + minVal));  	
		charMap.put((char)0x1EF9, (char)(9 + minVal));  	
		charMap.put((char)0x1EF8, (char)(9 + minVal)); 

		charMap.put((char)0x006A, (char)(10 + minVal));  	
		charMap.put((char)0x004A, (char)(10 + minVal));  	
		//006A 0307 0303 	J~, (char)(10 + minVal));
		//004A 0303			 , (char)(10 + minVal));
		
		charMap.put((char)0x006B, (char)(11 + minVal));  	
		charMap.put((char)0x004B, (char)(11 + minVal)); 

		charMap.put((char)0x006C, (char)(12 + minVal));  	
		charMap.put((char)0x004C, (char)(12 + minVal));  	
		//006C 0303 	L~	 , (char)(12 + minVal));  
		//004C 0303			 , (char)(12 + minVal));  

		charMap.put((char)0x006D, (char)(13 + minVal));  	
		charMap.put((char)0x004D, (char)(13 + minVal));  	
		//006D 0303 	M~	 , (char)(13 + minVal));  
		//004D 0303			 , (char)(13 + minVal));  

		charMap.put((char)0x006E, (char)(14 + minVal));  	
		charMap.put((char)0x004E, (char)(14 + minVal));  	
		charMap.put((char)0x00F1, (char)(14 + minVal));  	
		charMap.put((char)0x00D1, (char)(14 + minVal)); 

		charMap.put((char)0x006F, (char)(15 + minVal));  	
		charMap.put((char)0x004F, (char)(15 + minVal));  	
		charMap.put((char)0x00F3, (char)(15 + minVal));  	
		charMap.put((char)0x00D3, (char)(15 + minVal));  	
		charMap.put((char)0x00F2, (char)(15 + minVal));  	
		charMap.put((char)0x00D2, (char)(15 + minVal));  	
		charMap.put((char)0x00F5, (char)(15 + minVal));  	
		charMap.put((char)0x00D5, (char)(15 + minVal)); 

		charMap.put((char)0x0070, (char)(16 + minVal));  	
		charMap.put((char)0x0050, (char)(16 + minVal)); 

		charMap.put((char)0x0072, (char)(17 + minVal));  	
		charMap.put((char)0x0052, (char)(17 + minVal));  	
		//0072 0303 	R~	 , (char)(17 + minVal));  
		//0052 0303			 , (char)(17 + minVal));  

		charMap.put((char)0x0073, (char)(18 + minVal));  	
		charMap.put((char)0x0053, (char)(18 + minVal)); 

		charMap.put((char)0x0161, (char)(19 + minVal));  	
		charMap.put((char)0x0160, (char)(19 + minVal)); 

		charMap.put((char)0x0074, (char)(20 + minVal));  	
		charMap.put((char)0x0054, (char)(20 + minVal)); 

		charMap.put((char)0x0075, (char)(21 + minVal));  	
		charMap.put((char)0x0055, (char)(21 + minVal));  	
		charMap.put((char)0x00FA, (char)(21 + minVal));  	
		charMap.put((char)0x00DA, (char)(21 + minVal));  	
		charMap.put((char)0x00F9, (char)(21 + minVal));  	
		charMap.put((char)0x00D9, (char)(21 + minVal));  	
		charMap.put((char)0x0169, (char)(21 + minVal));  	
		charMap.put((char)0x0168, (char)(21 + minVal)); 	
		charMap.put((char)0x0173, (char)(21 + minVal));  	
		charMap.put((char)0x0172, (char)(21 + minVal));  	
		//0173 0301 	U�	 , (char)(21 + minVal));  
		//0172 0301 	u~	 , (char)(21 + minVal));  
		//0173 0303 	U~	 , (char)(21 + minVal));  
		//0172 0303			 , (char)(21 + minVal));  
		charMap.put((char)0x016B, (char)(21 + minVal));  	
		charMap.put((char)0x016A, (char)(21 + minVal));  	
		//016B 0301 	U�	 , (char)(21 + minVal));  
		//016A 0301 	u~	 , (char)(21 + minVal));  
		//016B 0303 	U~	 , (char)(21 + minVal));  
		//016A 0303			 , (char)(21 + minVal));  

		charMap.put((char)0x0076, (char)(22 + minVal));  	
		charMap.put((char)0x0056, (char)(22 + minVal)); 

		charMap.put((char)0x007A, (char)(23 + minVal));  	
		charMap.put((char)0x005A, (char)(23 + minVal)); 

		charMap.put((char)0x017E, (char)(24 + minVal));  	
		charMap.put((char)0x017D, (char)(24 + minVal)); 
		
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
					case 0x0105:					
						//0105 0301 	A�	 , 0 + minVal); 
						//0105 0303 	A~	 , 0 + minVal); 
						if ((i + 1 < key_length) && ((key.charAt(i + 1) == 0x0301) || (key.charAt(i + 1) == 0x0303)))
						{
							sb.append((char)(0 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;
					
					case 0x0104:
						//0104 0301 	a~	 , 0 + minVal); 
						//0104 0303			 , 0 + minVal);		
						if ((i + 1 < key_length) && ((key.charAt(i + 1) == 0x0301) || (key.charAt(i + 1) == 0x0303)))
						{
							sb.append((char)(0 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					//////////////////////////////
					case 0x0119:
						//0119 0301 	E�	 , 5 + minVal); 
						//0119 0303 	E~	 , 5 + minVal); 
						if ((i + 1 < key_length) && ((key.charAt(i + 1) == 0x0301) || (key.charAt(i + 1) == 0x0303)))
						{
							sb.append((char)(5 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					case 0x0118:
						//0118 0301 	e~	 , 5 + minVal); 				
						//0118 0303			 , 5 + minVal); 
						if ((i + 1 < key_length) && ((key.charAt(i + 1) == 0x0301) || (key.charAt(i + 1) == 0x0303)))
						{
							sb.append((char)(5 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					case 0x0117:
						//0117 0301 	E�	 , 5 + minVal); 
						//0117 0303 	E~	 , 5 + minVal); 
						if ((i + 1 < key_length) && ((key.charAt(i + 1) == 0x0301) || (key.charAt(i + 1) == 0x0303)))
						{
							sb.append((char)(5 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					case 0x0116:
						//0116 0301 	e~	 , 5 + minVal); 				
						//0116 0303			 , 5 + minVal); 
						if ((i + 1 < key_length) && ((key.charAt(i + 1) == 0x0301) || (key.charAt(i + 1) == 0x0303)))
						{
							sb.append((char)(5 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					//////////////////////////////
					case 0x0069:
						//0069 0307 0301 	�, 9 + minVal);
						//0069 0307 0300 	�, 9 + minVal);
						//0069 0307 0303 	I, 9 + minVal);
						if ((i + 1 < key_length) && ((key.charAt(i + 1) == 0x0307)))
						{
							if ((i + 2 < key_length) && ((key.charAt(i + 2) == 0x0301) || (key.charAt(i + 2) == 0x0300) || (key.charAt(i + 2) == 0x0303)))
							{
								sb.append((char)(9 + minVal));
								
								i += 2;
							}
//							else
//							{
//								sb.append(val.charValue());
//								
//							}
							
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					case 0x012F:
						//012F 0307 0301 	I�, 9 + minVal);				
						//012F 0307 0303 	I~, 9 + minVal);
						if ((i + 1 < key_length) && ((key.charAt(i + 1) == 0x0307)))
						{
							if ((i + 2 < key_length) && ((key.charAt(i + 2) == 0x0301) || (key.charAt(i + 2) == 0x0303)))
							{
								sb.append((char)(9 + minVal));
								
								i += 2;
							}
//							else
//							{
//								sb.append(val.charValue());
//								
//							}

						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					case 0x012E:
						//012E 0301 	i?~	  , 9 + minVal);
						//012E 0303			 , 9 + minVal);
						if ((i + 1 < key_length) && ((key.charAt(i + 1) == 0x0301) || (key.charAt(i + 1) == 0x0303)))
						{
							sb.append((char)(9 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					//////////////////////////////
					case 0x006A:
						//006A 0307 0303 	J~, 10 + minVal);
						if ((i + 2 < key_length) && ((key.charAt(i + 1) == 0x0307) && (key.charAt(i + 2) == 0x0303)))
						{
							sb.append((char)(10 + minVal));
							
							i += 2;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					case 0x004A:					
						//004A 0303			 , 10 + minVal);
						if ((i + 1 < key_length) && (key.charAt(i + 1) == 0x0303))
						{
							sb.append((char)(10 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					//////////////////////////////
					case 0x006C:
					case 0x004C:
						//006C 0303 	L~	 , 12 + minVal);  
						//004C 0303			 , 12 + minVal);  
						if ((i + 1 < key_length) && (key.charAt(i + 1) == 0x0303))
						{
							sb.append((char)(12 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					//////////////////////////////
					case 0x006D:
					case 0x004D:
						//006D 0303 	M~	 , 13 + minVal);  
						//004D 0303			 , 13 + minVal);  
						if ((i + 1 < key_length) && (key.charAt(i + 1) == 0x0303))
						{
							sb.append((char)(13 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					//////////////////////////////
					case 0x0072:
					case 0x0052:
						//0072 0303 	R~	 , 17 + minVal);  
						//0052 0303			 , 17 + minVal);  
						if ((i + 1 < key_length) && (key.charAt(i + 1) == 0x0303))
						{
							sb.append((char)(17 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					//////////////////////////////
					case 0x0173:
						//0173 0301 	U�	 , 21 + minVal);  
						//0173 0303 	U~	 , 21 + minVal);  
						if ((i + 1 < key_length) && ((key.charAt(i + 1) == 0x0301) || (key.charAt(i + 1) == 0x0303)))
						{
							sb.append((char)(21 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					case 0x0172:
						//0172 0301 	u~	 , 21 + minVal);  
						//0172 0303			 , 21 + minVal);  
						if ((i + 1 < key_length) && ((key.charAt(i + 1) == 0x0301) || (key.charAt(i + 1) == 0x0303)))
						{
							sb.append((char)(21 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					case 0x016B:
						//016B 0301 	U�	 , 21 + minVal);  				
						//016B 0303 	U~	 , 21 + minVal);  
						if ((i + 1 < key_length) && ((key.charAt(i + 1) == 0x0301) || (key.charAt(i + 1) == 0x0303)))
						{
							sb.append((char)(21 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					case 0x016A:
						//016A 0301 	u~	 , 21 + minVal);  
						//016A 0303			 , 21 + minVal);  
						if ((i + 1 < key_length) && ((key.charAt(i + 1) == 0x0301) || (key.charAt(i + 1) == 0x0303)))
						{
							sb.append((char)(21 + minVal));
							
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
