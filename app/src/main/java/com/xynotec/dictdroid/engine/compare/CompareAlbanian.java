package com.xynotec.dictdroid.engine.compare;

import java.util.HashMap;

public class CompareAlbanian extends CompareBase
{
	
	char[] charCollation = 
	{		
		0x0061,
		0x0041,
		0x0062,
		0x0042,
		0x0063,
		0x0043,
		0x00E7,
		0x00C7,
		0x0064,
		0x0044,
		//0064 0068 	Dh
		//0044 0068 	DH
		//0044 0048
		0x0065,
		0x0045,
		0x00EB,
		0x00CB,
		0x0066,
		0x0046,
		0x0067,
		0x0047,
		//0067 006A 	Gj
		//0047 006A 	GJ
		//0047 004A
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
		//006C 006C 	Ll
		//004C 006C 	LL
		//004C 004C
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
		0x0071, 
		0x0051,
		0x0072, 
		0x0052,
		//0072 0072 	Rr
		//0052 0072 	RR
		//0052 0052
		0x0073, 
		0x0053,
		//0073 0068 	Sh
		//0053 0068 	SH
		//0053 0048
		0x0074, 
		0x0054,
		//0074 0068 	Th
		//0054 0068 	TH
		//0054 0048
		0x0075, 
		0x0055,
		0x0076, 
		0x0056,
		0x0078, 
		0x0058,
		//0078 0068 	Xh
		//0058 0068 	XH
		//0058 0048
		0x0079, 
		0x0059,
		0x007A, 
		0x005A,
		//007A 0068 	Zh
		//005A 0068 	ZH
		//005A 0048			
	};	

	public CompareAlbanian()
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

		charMap.put((char)0x00E7, (char)(3 + minVal));	
		charMap.put((char)0x00C7, (char)(3 + minVal));	

		charMap.put((char)0x0064, (char)(4 + minVal));	
		charMap.put((char)0x0044, (char)(4 + minVal));	

		//0064 0068 	Dh,	   5 + minVal));	   
		//0044 0068 	DH, (char)(   5 + minVal));	
		//0044 0048

		charMap.put((char)0x0065, (char)(6 + minVal));	 
		charMap.put((char)0x0045, (char)(6 + minVal));	

		charMap.put((char)0x00EB, (char)(7 + minVal));	 
		charMap.put((char)0x00CB, (char)(7 + minVal));	

		charMap.put((char)0x0066, (char)(8 + minVal));	 
		charMap.put((char)0x0046, (char)(8 + minVal));	

		charMap.put((char)0x0067, (char)(9 + minVal));	
		charMap.put((char)0x0047, (char)(9 + minVal));	

		//0067 006A 	Gj, (char)(   10 + minVal));	
		//0047 006A 	GJ, (char)(   10 + minVal));	
		//0047 004A

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

		//006C 006C 	Ll, (char)(   16 + minVal));	
		//004C 006C 	LL, (char)(   16 + minVal));	
		//004C 004C

		charMap.put((char)0x006D, (char)(17 + minVal));	 
		charMap.put((char)0x004D, (char)(17 + minVal));	

		charMap.put((char)0x006E, (char)(18 + minVal));	 
		charMap.put((char)0x004E, (char)(18 + minVal));	

		//006E 006A 	Nj, (char)(   19 + minVal));	
		//004E 006A 	NJ, (char)(   19 + minVal));	
		//004E 004A

		charMap.put((char)0x006F, (char)(20 + minVal));	 
		charMap.put((char)0x004F, (char)(20 + minVal));	

		charMap.put((char)0x0070, (char)(21 + minVal));	 
		charMap.put((char)0x0050, (char)(21 + minVal));	

		charMap.put((char)0x0071, (char)(22 + minVal));	 
		charMap.put((char)0x0051, (char)(22 + minVal));	

		charMap.put((char)0x0072, (char)(23 + minVal));	 
		charMap.put((char)0x0052, (char)(23 + minVal));	

		//0072 0072 	Rr, (char)(   24 + minVal));	
		//0052 0072 	RR, (char)(   24 + minVal));	
		//0052 0052

		charMap.put((char)0x0073, (char)(25 + minVal));	 
		charMap.put((char)0x0053, (char)(25 + minVal));	

		//0073 0068 	Sh, (char)(   26 + minVal));	
		//0053 0068 	SH, (char)(   26 + minVal));	
		//0053 0048

		charMap.put((char)0x0074, (char)(27 + minVal));	 
		charMap.put((char)0x0054, (char)(27 + minVal));	

		//0074 0068 	Th, (char)(   28 + minVal));	
		//0054 0068 	TH, (char)(   28 + minVal));	
		//0054 0048

		charMap.put((char)0x0075, (char)(29 + minVal));	 
		charMap.put((char)0x0055, (char)(29 + minVal));	

		charMap.put((char)0x0076, (char)(30 + minVal));	 
		charMap.put((char)0x0056, (char)(30 + minVal));	

		charMap.put((char)0x0078, (char)(31 + minVal));	 
		charMap.put((char)0x0058, (char)(31 + minVal));	

		//0078 0068 	Xh, (char)(   32 + minVal));	
		//0058 0068 	XH, (char)(   32 + minVal));	
		//0058 0048

		charMap.put((char)0x0079, (char)(33 + minVal));	 
		charMap.put((char)0x0059, (char)(33 + minVal));	

		charMap.put((char)0x007A, (char)(34 + minVal));	 
		charMap.put((char)0x005A, (char)(34 + minVal));	

		//007A 0068 	Zh, (char)(   35 + minVal));	
		//005A 0068 	ZH, (char)(   35 + minVal));	
		//005A 0048		
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
						//dh	0064 0068 	
						if ((i + 1 < key_length) && (key.charAt(i + 1) == 0x0068))
						{
							sb.append((char)(5 + minVal));							
							i++;
						}
						else
						{
							sb.append(val.charValue());							
						}
						break;
					case 0x0044:					
						//Dh	0044 0068 	
						//DH	0044 0048
						if ((i + 1 < key_length) && ((key.charAt(i + 1) == 0x0068) || (key.charAt(i + 1) == 0x0048)))
						{
							sb.append((char)(5 + minVal));
							i++;
						}
						else
						{
							sb.append(val.charValue());
						}
						break;

					case 0x0067:
						//gj	0067 006A 	
						if ((i + 1 < key_length) && (key.charAt(i + 1) == 0x006A))
						{
							sb.append((char)(10 + minVal));
							i++;
						}
						else
						{
							sb.append(val.charValue());
						}
						break;
					
					case 0x0047:					
						//Gj	0047 006A 	
						//GJ	0047 004A
						if ((i + 1 < key_length) && ((key.charAt(i + 1) == 0x006A) || (key.charAt(i + 1) == 0x004A)))
						{
							sb.append((char)(10 + minVal));
							i++;
						}
						else
						{
							sb.append(val.charValue());
						}
						break;

					case 0x006C:
						//ll	006C 006C 	
						if ((i + 1 < key_length) && (key.charAt(i + 1) == 0x006C))
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
						//Ll	004C 006C 	
						//LL	004C 004C
						if ((i + 1 < key_length) && ((key.charAt(i + 1) == 0x006C) || (key.charAt(i + 1) == 0x004C)))
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
						//nj	006E 006A 	
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
						//Nj	004E 006A 	
						//NJ	004E 004A
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

					case 0x0072:
						//rr	0072 0072 	
						if ((i + 1 < key_length) && (key.charAt(i + 1) == 0x0072))
						{
							sb.append((char)(24 + minVal));							
							i++;
						}
						else
						{
							sb.append(val.charValue());							
						}
						break;
					case 0x0052:					
						//Rr	0052 0072 	
						//RR	0052 0052
						if ((i + 1 < key_length) && ((key.charAt(i + 1) == 0x0072) || (key.charAt(i + 1) == 0x0052)))
						{
							sb.append((char)(24 + minVal));							
							i++;
						}
						else
						{
							sb.append(val.charValue());							
						}
						break;

					case 0x0073:
						//sh	0073 0068 	
						if ((i + 1 < key_length) && (key.charAt(i + 1) == 0x0068))
						{
							sb.append((char)(26 + minVal));							
							i++;
						}
						else
						{
							sb.append(val.charValue());							
						}
						break;
					case 0x0053:					
						//Sh	0053 0068 	
						//SH	0053 0048
						if ((i + 1 < key_length) && ((key.charAt(i + 1) == 0x0068) || (key.charAt(i + 1) == 0x0048)))
						{
							sb.append((char)(26 + minVal));							
							i++;
						}
						else
						{
							sb.append(val.charValue());							
						}
						break;

					case 0x0074:
						//th	0074 0068 	
						if ((i + 1 < key_length) && (key.charAt(i + 1) == 0x0068))
						{
							sb.append((char)(28 + minVal));							
							i++;
						}
						else
						{
							sb.append(val.charValue());							
						}
						break;
					case 0x0054:					
						//Th	0054 0068 	
						//TH	0054 0048
						if ((i + 1 < key_length) && ((key.charAt(i + 1) == 0x0068) || (key.charAt(i + 1) == 0x0048)))
						{
							sb.append((char)(28 + minVal));							
							i++;
						}
						else
						{
							sb.append(val.charValue());							
						}
						break;

					case 0x0078:
						//xh	0078 0068 	
						if ((i + 1 < key_length) && (key.charAt(i + 1) == 0x0068))
						{
							sb.append((char)(32 + minVal));							
							i++;
						}
						else
						{
							sb.append(val.charValue());							
						}
						break;
					case 0x0058:					
						//Xh	0058 0068 	
						//XH	0058 0048
						if ((i + 1 < key_length) && ((key.charAt(i + 1) == 0x0068) || (key.charAt(i + 1) == 0x0048)))
						{
							sb.append((char)(32 + minVal));							
							i++;
						}
						else
						{
							sb.append(val.charValue());							
						}
						break;

					case 0x007A:
						//zh	007A 0068 	
						if ((i + 1 < key_length) && (key.charAt(i + 1) == 0x0068))
						{
							sb.append((char)(35 + minVal));							
							i++;
						}
						else
						{
							sb.append(val.charValue());							
						}
						break;
					case 0x005A:					
						//Zh	005A 0068 	
						//ZH	0048
						if ((i + 1 < key_length) && ((key.charAt(i + 1) == 0x0068) || (key.charAt(i + 1) == 0x0048)))
						{
							sb.append((char)(35 + minVal));							
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
