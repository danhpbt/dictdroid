package com.xynotec.dictdroid.engine.compare;

import java.util.HashMap;

public class CompareHungarian extends CompareBase
{
	
	char[] charCollation = 
	{
		0x0061, 	
		0x0041,	
		0x00E1,
		0x00C1,
		0x0062, 	
		0x0042,
		0x0063, 	
		0x0043,
		//0063 0073 	Cs
		//0043 0073 	CS
		//0043 0053 	ccs
		//0063 0063 0073 	Ccs
		//0043 0063 0073 	CCS
		//0043 0043 0053
		0x0064, 	
		0x0044,
		//0064 007A 	Dz
		//0044 007A 	DZ
		//0044 005A 	ddz
		//0064 0064 007A 	Ddz
		//0044 0064 007A 	DDZ
		//0044 0044 005A
		//0064 007A 0073 	Dzs
		//0044 007A 0073 	DZS
		//0044 005A 0053 	ddzs
		//0064 0064 007A 0073 	Ddzs
		//0044 0064 007A 0073 	DDZS
		//0044 0044 005A 0053
		0x0065, 	
		0x0045, 	
		0x00E9, 	
		0x00C9,
		0x0066, 	
		0x0046,
		0x0067, 	
		0x0047,
		//0067 0079 	Gy
		//0047 0079 	GY
		//0047 0059 	ggy
		//0067 0067 0079 	Ggy
		//0047 0067 0079 	GGY
		//0047 0047 0059
		0x0068, 	
		0x0048,
		0x0069, 	
		0x0049, 	
		0x00ED, 	
		0x00CD,
		0x006A, 	
		0x004A,
		0x006B, 	
		0x004B,
		0x006C, 	
		0x004C,
		//006C 0079 	Ly
		//004C 0079 	LY
		//004C 0059 	lly
		//006C 006C 0079 	Lly
		//004C 006C 0079 	LLY
		//004C 004C 0059
		0x006D, 	
		0x004D,
		0x006E, 	
		0x004E,
		//006E 0079 	Ny
		//004E 0079 	NY
		//004E 0059 	nny
		//006E 006E 0079 	Nny
		//004E 006E 0079 	NNY
		//004E 004E 0059
		0x006F, 	
		0x004F, 	
		0x00F3, 	
		0x00D3,
		0x00F6, 	
		0x00D6, 	
		0x0151, 	
		0x0150,
		0x0070, 	
		0x0050,
		0x0072, 	
		0x0052,
		0x0073, 	
		0x0053,
		//0073 007A 	Sz
		//0053 007A 	SZ
		//0053 005A 	ssz
		//0073 0073 007A 	Ssz
		//0053 0073 007A 	SSZ
		//0053 0053 005A
		0x0074, 	
		0x0054,
		//0074 0079 	Ty
		//0054 0079 	TY
		//0054 0059 	tty
		//0074 0074 0079 	Tty
		//0054 0074 0079 	TTY
		//0054 0054 0059
		0x0075, 	
		0x0055, 	
		0x00FA, 	
		0x00DA,
		0x00FC, 	
		0x00DC, 	
		0x0171, 	
		0x0170,
		0x0076, 	
		0x0056,
		0x007A, 	
		0x005A,
		//007A 0073 	Zs
		//005A 0073 	ZS
		//005A 0053 	zzs
		//007A 007A 0073 	Zzs
		//005A 007A 0073 	ZZS
		//005A 005A 0053
				
	};	

	public CompareHungarian()
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

		charMap.put((char)0x0062, (char)(1 + minVal)); 	
		charMap.put((char)0x0042, (char)(1 + minVal));

		charMap.put((char)0x0063, (char)(2 + minVal)); 	
		charMap.put((char)0x0043, (char)(2 + minVal));

		//0063 0073 	Cs			3 + minVal
		//0043 0073 	CS			3 + minVal
		//0043 0053 	ccs			3 + minVal
		//0063 0063 0073 	Ccs		3 + minVal
		//0043 0063 0073 	CCS		3 + minVal
		//0043 0043 0053			3 + minVal

		charMap.put((char)0x0064, (char)(4 + minVal)); 	
		charMap.put((char)0x0044, (char)(4 + minVal));

		//0064 007A 	Dz			5 + minVal
		//0044 007A 	DZ			5 + minVal
		//0044 005A 	ddz			5 + minVal
		//0064 0064 007A 	Ddz		5 + minVal
		//0044 0064 007A 	DDZ		5 + minVal
		//0044 0044 005A			5 + minVal

		//0064 007A 0073 	Dzs			6 + minVal
		//0044 007A 0073 	DZS			6 + minVal
		//0044 005A 0053 	ddzs		6 + minVal
		//0064 0064 007A 0073 	Ddzs	6 + minVal
		//0044 0064 007A 0073 	DDZS	6 + minVal
		//0044 0044 005A 0053			6 + minVal

		charMap.put((char)0x0065, (char)(7 + minVal)); 	
		charMap.put((char)0x0045, (char)(7 + minVal)); 	
		charMap.put((char)0x00E9, (char)(7 + minVal)); 	
		charMap.put((char)0x00C9, (char)(7 + minVal));

		charMap.put((char)0x0066, (char)(8 + minVal)); 	
		charMap.put((char)0x0046, (char)(8 + minVal));

		charMap.put((char)0x0067, (char)(9 + minVal)); 	
		charMap.put((char)0x0047, (char)(9 + minVal));

		//0067 0079 	Gy			10 + minVal
		//0047 0079 	GY			10 + minVal
		//0047 0059 	ggy			10 + minVal
		//0067 0067 0079 	Ggy		10 + minVal
		//0047 0067 0079 	GGY		10 + minVal
		//0047 0047 0059			10 + minVal

		charMap.put((char)0x0068, (char)(11 + minVal)); 	
		charMap.put((char)0x0048, (char)(11 + minVal));

		charMap.put((char)0x0069, (char)(12 + minVal)); 	
		charMap.put((char)0x0049, (char)(12 + minVal)); 	
		charMap.put((char)0x00ED, (char)(12 + minVal)); 	
		charMap.put((char)0x00CD, (char)(12 + minVal));

		charMap.put((char)0x006A, (char)(13 + minVal)); 	
		charMap.put((char)0x004A, (char)(13 + minVal));

		charMap.put((char)0x006B, (char)(14 + minVal)); 	
		charMap.put((char)0x004B, (char)(14 + minVal));

		charMap.put((char)0x006C, (char)(15 + minVal)); 	
		charMap.put((char)0x004C, (char)(15 + minVal));

		//006C 0079 	Ly			16 + minVal
		//004C 0079 	LY			16 + minVal
		//004C 0059 	lly			16 + minVal
		//006C 006C 0079 	Lly		16 + minVal
		//004C 006C 0079 	LLY		16 + minVal
		//004C 004C 0059			16 + minVal

		charMap.put((char)0x006D, (char)(17 + minVal)); 	
		charMap.put((char)0x004D, (char)(17 + minVal));

		charMap.put((char)0x006E, (char)(18 + minVal)); 	
		charMap.put((char)0x004E, (char)(18 + minVal));

		//006E 0079 	Ny			19 + minVal
		//004E 0079 	NY			19 + minVal
		//004E 0059 	nny			19 + minVal
		//006E 006E 0079 	Nny		19 + minVal
		//004E 006E 0079 	NNY		19 + minVal
		//004E 004E 0059			19 + minVal

		charMap.put((char)0x006F, (char)(20 + minVal)); 	
		charMap.put((char)0x004F, (char)(20 + minVal)); 	
		charMap.put((char)0x00F3, (char)(20 + minVal)); 	
		charMap.put((char)0x00D3, (char)(20 + minVal));

		charMap.put((char)0x00F6, (char)(21 + minVal)); 	
		charMap.put((char)0x00D6, (char)(21 + minVal)); 	
		charMap.put((char)0x0151, (char)(21 + minVal)); 	
		charMap.put((char)0x0150, (char)(21 + minVal));

		charMap.put((char)0x0070, (char)(22 + minVal)); 	
		charMap.put((char)0x0050, (char)(22 + minVal));

		charMap.put((char)0x0072, (char)(23 + minVal)); 	
		charMap.put((char)0x0052, (char)(23 + minVal));

		charMap.put((char)0x0073, (char)(24 + minVal)); 	
		charMap.put((char)0x0053, (char)(24 + minVal));

		//0073 007A 	Sz			25 + minVal
		//0053 007A 	SZ			25 + minVal
		//0053 005A 	ssz			25 + minVal
		//0073 0073 007A 	Ssz		25 + minVal
		//0053 0073 007A 	SSZ		25 + minVal
		//0053 0053 005A			25 + minVal

		charMap.put((char)0x0074, (char)(26 + minVal)); 	
		charMap.put((char)0x0054, (char)(26 + minVal));

		//0074 0079 	Ty			27 + minVal
		//0054 0079 	TY			27 + minVal
		//0054 0059 	tty			27 + minVal
		//0074 0074 0079 	Tty		27 + minVal
		//0054 0074 0079 	TTY		27 + minVal
		//0054 0054 0059			27 + minVal

		charMap.put((char)0x0075, (char)(28 + minVal)); 	
		charMap.put((char)0x0055, (char)(28 + minVal)); 	
		charMap.put((char)0x00FA, (char)(28 + minVal)); 	
		charMap.put((char)0x00DA, (char)(28 + minVal));

		charMap.put((char)0x00FC, (char)(29 + minVal)); 	
		charMap.put((char)0x00DC, (char)(29 + minVal)); 	
		charMap.put((char)0x0171, (char)(29 + minVal)); 	
		charMap.put((char)0x0170, (char)(29 + minVal));

		charMap.put((char)0x0076, (char)(30 + minVal)); 	
		charMap.put((char)0x0056, (char)(30 + minVal));

		charMap.put((char)0x007A, (char)(31 + minVal)); 	
		charMap.put((char)0x005A, (char)(31 + minVal));

		//007A 0073 	Zs			32 + minVal
		//005A 0073 	ZS			32 + minVal
		//005A 0053 	zzs			32 + minVal
		//007A 007A 0073 	Zzs		32 + minVal
		//005A 007A 0073 	ZZS		32 + minVal
		//005A 005A 0053			32 + minVal	
	
		
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
					case 0x0063:
						//0063 0073 	Cs			3 + minVal
						//0063 0063 0073 	Ccs		3 + minVal
						if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x0063) && (key.charAt(i+2) == 0x0073)))
						{
							sb.append((char)(3 + minVal));
							
							i += 2;
						}
						else if ((i + 1 < key_length) && (key.charAt(i+1) == 0x0063)) 
						{
							sb.append((char)(3 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					case 0x0043:
						//0043 0073 	CS			3 + minVal
						//0043 0053 	ccs			3 + minVal
						//0043 0063 0073 	CCS		3 + minVal
						//0043 0043 0053			3 + minVal
						if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x0063) && (key.charAt(i+2) == 0x0073)))
						{
							sb.append((char)(3 + minVal));
							
							i += 2;
						}
						else if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x0043) && (key.charAt(i+2) == 0x0053)))
						{
							sb.append((char)(3 + minVal));
							
							i += 2;
						}
						else if ((i + 1 < key_length) && ((key.charAt(i+1) == 0x0073) || (key.charAt(i+1) == 0x0053)))  
						{
							sb.append((char)(3 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;				

					case 0x0064:
						//0064 007A 	Dz			5 + minVal
						//0064 0064 007A 	Ddz		5 + minVal
						//0064 007A 0073 	Dzs			6 + minVal
						//0064 0064 007A 0073 	Ddzs	6 + minVal
						if ((i + 3 < key_length) && ((key.charAt(i+1) == 0x0064) && (key.charAt(i+2) == 0x007A) && (key.charAt(i+3) == 0x0073)))
						{
							sb.append((char)(6 + minVal));
							
							i += 3;
						}
						else if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x007A) && (key.charAt(i+2) == 0x0073)))
						{
							sb.append((char)(6 + minVal));
							
							i += 2;
						}
						else if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x0064) && (key.charAt(i+2) == 0x007A)))
						{
							sb.append((char)(5 + minVal));
							
							i += 2;
						}
						else if ((i + 1 < key_length) && (key.charAt(i+1) == 0x007A)) 
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
						//0044 007A 	DZ			5 + minVal
						//0044 005A 	ddz			5 + minVal					
						//0044 0064 007A 	DDZ		5 + minVal
						//0044 0044 005A			5 + minVal					
						//0044 007A 0073 	DZS			6 + minVal
						//0044 005A 0053 	ddzs		6 + minVal					
						//0044 0064 007A 0073 	DDZS	6 + minVal
						//0044 0044 005A 0053			6 + minVal
						if ((i + 3 < key_length) && ((key.charAt(i+1) == 0x0044) && (key.charAt(i+2) == 0x005A) && (key.charAt(i+3) == 0x0053)))
						{
							sb.append((char)(6 + minVal));
							
							i += 3;
						}
						else if ((i + 3 < key_length) && ((key.charAt(i+1) == 0x0064) && (key.charAt(i+2) == 0x007A) && (key.charAt(i+3) == 0x0073)))
						{
							sb.append((char)(6 + minVal));
							
							i += 3;
						}
						else if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x005A) && (key.charAt(i+2) == 0x0053)))
						{
							sb.append((char)(6 + minVal));
							
							i += 2;
						}
						else if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x007A) && (key.charAt(i+2) == 0x0073)))
						{
							sb.append((char)(6 + minVal));
							
							i += 2;
						}
						else if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x0044) && (key.charAt(i+2) == 0x005A)))
						{
							sb.append((char)(5 + minVal));
							
							i += 2;
						}
						else if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x0064) && (key.charAt(i+2) == 0x007A)))
						{
							sb.append((char)(5 + minVal));
							
							i += 2;
						}
						else if ((i + 1 < key_length) && ((key.charAt(i+1) == 0x005A) || (key.charAt(i+1) == 0x007A)))  
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
						//0067 0079 	Gy			10 + minVal
						//0067 0067 0079 	Ggy		10 + minVal
						if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x0067) && (key.charAt(i+2) == 0x0079)))
						{
							sb.append((char)(10 + minVal));
							
							i += 2;
						}
						else if ((i + 1 < key_length) && (key.charAt(i+1) == 0x0079)) 
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
						//0047 0079 	GY			10 + minVal
						//0047 0059 	ggy			10 + minVal					
						//0047 0067 0079 	GGY		10 + minVal
						//0047 0047 0059			10 + minVal
						if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x0047) && (key.charAt(i+2) == 0x0059)))
						{
							sb.append((char)(10 + minVal));
							
							i += 2;
						}
						else if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x0067) && (key.charAt(i+2) == 0x0079)))
						{
							sb.append((char)(10 + minVal));
							
							i += 2;
						}
						else if ((i + 1 < key_length) && ((key.charAt(i+1) == 0x0079) || (key.charAt(i+1) == 0x0059)))  
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
						//006C 0079 	Ly			16 + minVal
						//006C 006C 0079 	Lly		16 + minVal
						if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x006C) && (key.charAt(i+2) == 0x0079)))
						{
							sb.append((char)(16 + minVal));
							
							i += 2;
						}
						else if ((i + 1 < key_length) && (key.charAt(i+1) == 0x0079)) 
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
						//004C 0079 	LY			16 + minVal
						//004C 0059 	lly			16 + minVal					
						//004C 006C 0079 	LLY		16 + minVal
						//004C 004C 0059			16 + minVal
						if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x004C) && (key.charAt(i+2) == 0x0059)))
						{
							sb.append((char)(16 + minVal));
							
							i += 2;
						}
						else if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x006C) && (key.charAt(i+2) == 0x0079)))
						{
							sb.append((char)(16 + minVal));
							
							i += 2;
						}
						else if ((i + 1 < key_length) && ((key.charAt(i+1) == 0x0059) || (key.charAt(i+1) == 0x0079)))  
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
						//006E 0079 	Ny			19 + minVal
						//006E 006E 0079 	Nny		19 + minVal
						if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x006E) && (key.charAt(i+2) == 0x0079)))
						{
							sb.append((char)(19 + minVal));
							
							i += 2;
						}
						else if ((i + 1 < key_length) && (key.charAt(i+1) == 0x0079)) 
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
						//004E 0079 	NY			19 + minVal
						//004E 0059 	nny			19 + minVal					
						//004E 006E 0079 	NNY		19 + minVal
						//004E 004E 0059			19 + minVal
						if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x004E) && (key.charAt(i+2) == 0x0059)))
						{
							sb.append((char)(19 + minVal));
							
							i += 2;
						}
						else if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x006E) && (key.charAt(i+2) == 0x0079)))
						{
							sb.append((char)(19 + minVal));
							
							i += 2;
						}
						else if ((i + 1 < key_length) && ((key.charAt(i+1) == 0x0059) || (key.charAt(i+1) == 0x0079)))  
						{
							sb.append((char)(19 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					case 0x0073:
						//0073 007A 	Sz			25 + minVal
						//0073 0073 007A 	Ssz		25 + minVal
						if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x0073) && (key.charAt(i+2) == 0x007A)))
						{
							sb.append((char)(25 + minVal));
							
							i += 2;
						}
						else if ((i + 1 < key_length) && (key.charAt(i+1) == 0x007A)) 
						{
							sb.append((char)(25 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					case 0x0053:
						//0053 007A 	SZ			25 + minVal
						//0053 005A 	ssz			25 + minVal					
						//0053 0073 007A 	SSZ		25 + minVal
						//0053 0053 005A			25 + minVal
						if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x0053) && (key.charAt(i+2) == 0x005A)))
						{
							sb.append((char)(25 + minVal));
							
							i += 2;
						}
						else if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x0073) && (key.charAt(i+2) == 0x007A)))
						{
							sb.append((char)(25 + minVal));
							
							i += 2;
						}
						else if ((i + 1 < key_length) && ((key.charAt(i+1) == 0x005A) || (key.charAt(i+1) == 0x007A)))  
						{
							sb.append((char)(25 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;
						
					case 0x0074:
						//0074 0079 	Ty			27 + minVal
						//0074 0074 0079 	Tty		27 + minVal
						if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x0074) && (key.charAt(i+2) == 0x0079)))
						{
							sb.append((char)(27 + minVal));
							
							i += 2;
						}
						else if ((i + 1 < key_length) && (key.charAt(i+1) == 0x0079)) 
						{
							sb.append((char)(27 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					case 0x0054:
						//0054 0079 	TY			27 + minVal
						//0054 0059 	tty			27 + minVal					
						//0054 0074 0079 	TTY		27 + minVal
						//0054 0054 0059			27 + minVal
						if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x0054) && (key.charAt(i+2) == 0x0059)))
						{
							sb.append((char)(27 + minVal));
							
							i += 2;
						}
						else if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x0074) && (key.charAt(i+2) == 0x0079)))
						{
							sb.append((char)(27 + minVal));
							
							i += 2;
						}
						else if ((i + 1 < key_length) && ((key.charAt(i+1) == 0x0059) || (key.charAt(i+1) == 0x0079)))  
						{
							sb.append((char)(27 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					case 0x007A:
						//007A 0073 	Zs			32 + minVal
						//007A 007A 0073 	Zzs		32 + minVal
						if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x007A) && (key.charAt(i+2) == 0x0073)))
						{
							sb.append((char)(32 + minVal));
							
							i += 2;
						}
						else if ((i + 1 < key_length) && (key.charAt(i+1) == 0x0073)) 
						{
							sb.append((char)(32 + minVal));
							
							i++;
						}
						else
						{
							sb.append(val.charValue());
							
						}
						break;

					case 0x005A:
						//005A 0073 	ZS			32 + minVal
						//005A 0053 	zzs			32 + minVal					
						//005A 007A 0073 	ZZS		32 + minVal
						//005A 005A 0053			32 + minVal
						if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x005A) && (key.charAt(i+2) == 0x0053)))
						{
							sb.append((char)(32 + minVal));
							
							i += 2;
						}
						else if ((i + 2 < key_length) && ((key.charAt(i+1) == 0x007A) && (key.charAt(i+2) == 0x0073)))
						{
							sb.append((char)(32 + minVal));
							
							i += 2;
						}
						else if ((i + 1 < key_length) && ((key.charAt(i+1) == 0x0053) || (key.charAt(i+1) == 0x0073)))  
						{
							sb.append((char)(32 + minVal));
							
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
