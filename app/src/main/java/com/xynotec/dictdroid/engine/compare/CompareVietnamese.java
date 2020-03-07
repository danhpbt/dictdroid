package com.xynotec.dictdroid.engine.compare;

import java.util.HashMap;

public class CompareVietnamese extends CompareBase
{
	char[] charCollation = 
	{
		0x0061,
		0x0041,
		0x00E0,
		0x00C0,
		0x1EA3,
		0x1EA2,
		0x00E3,
		0x00C3,
		0x00E1,
		0x00C1,
		0x1EA1,
		0x1EA0,
		0x0103,
		0x0102,
		0x1EB1,
		0x1EB0,
		0x1EB3,
		0x1EB2,
		0x1EB5,
		0x1EB4,
		0x1EAF,
		0x1EAE,
		0x1EB7,
		0x1EB6,
		0x00E2, 
		0x00C2, 
		0x1EA7, 
		0x1EA6, 
		0x1EA9, 
		0x1EA8, 
		0x1EAB, 
		0x1EAA, 
		0x1EA5, 
		0x1EA4, 
		0x1EAD, 
		0x1EAC,
		0x0062, 
		0x0042,
		0x0063, 
		0x0043,
		0x0064, 
		0x0044,
		0x0111, 
		0x0110,
		0x0065,
		0x0045,
		0x00E8,
		0x00C8,
		0x1EBB,
		0x1EBA,
		0x1EBD,
		0x1EBC,
		0x00E9,
		0x00C9,
		0x1EB9,
		0x1EB8,
		0x00EA,
		0x00CA,
		0x1EC1,
		0x1EC0,
		0x1EC3,
		0x1EC2,
		0x1EC5,
		0x1EC4,
		0x1EBF,
		0x1EBE,
		0x1EC7,
		0x1EC6,
		0x0067,
		0x0047,
		0x0068,
		0x0048,
		0x0069,
		0x0049,
		0x00EC,
		0x00CC,
		0x1EC9,
		0x1EC8,
		0x0129,
		0x0128,
		0x00ED,
		0x00CD,
		0x1ECB,
		0x1ECA,
		0x006B,
		0x004B,
		0x006C,
		0x004C,
		0x006D,
		0x004D,
		0x006E,
		0x004E,
		0x006F,
		0x004F,
		0x00F2,
		0x00D2,
		0x1ECF,
		0x1ECE,
		0x00F5,
		0x00D5,
		0x00F3,
		0x00D3,
		0x1ECD,
		0x1ECC,
		0x00F4,
		0x00D4,
		0x1ED3,
		0x1ED2,
		0x1ED5,
		0x1ED4,
		0x1ED7,
		0x1ED6,
		0x1ED1,
		0x1ED0,
		0x1ED9,
		0x1ED8,
		0x01A1,
		0x01A0,
		0x1EDD,
		0x1EDC,
		0x1EDF,
		0x1EDE,
		0x1EE1,
		0x1EE0,
		0x1EDB,
		0x1EDA,
		0x1EE3,
		0x1EE2,
		0x0070,
		0x0050,
		0x0071,
		0x0051,
		0x0072,
		0x0052,
		0x0073,
		0x0053,
		0x0074,
		0x0054,
		0x0075,
		0x0055,
		0x00F9,
		0x00D9,
		0x1EE7,
		0x1EE6,
		0x0169,
		0x0168,
		0x00FA,
		0x00DA,
		0x1EE5,
		0x1EE4,
		0x01B0,
		0x01AF,
		0x1EEB,
		0x1EEA,
		0x1EED,
		0x1EEC,
		0x1EEF,
		0x1EEE,
		0x1EE9,
		0x1EE8,
		0x1EF1,
		0x1EF0,
		0x0076,
		0x0056,
		0x0078,
		0x0058,
		0x0079,
		0x0059,
		0x1EF3,
		0x1EF2,
		0x1EF7,
		0x1EF6,
		0x1EF9,
		0x1EF8,
		0x00FD,
		0x00DD,
		0x1EF5,
		0x1EF4,	 
	};	
	
	public CompareVietnamese()
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
		charMap.put((char)0x00E0, (char)(0 + minVal)); 	
		charMap.put((char)0x00C0, (char)(0 + minVal)); 	
		charMap.put((char)0x1EA3, (char)(0 + minVal)); 	
		charMap.put((char)0x1EA2, (char)(0 + minVal)); 	
		charMap.put((char)0x00E3, (char)(0 + minVal)); 	
		charMap.put((char)0x00C3, (char)(0 + minVal)); 	
		charMap.put((char)0x00E1, (char)(0 + minVal)); 	
		charMap.put((char)0x00C1, (char)(0 + minVal)); 	
		charMap.put((char)0x1EA1, (char)(0 + minVal)); 	
		charMap.put((char)0x1EA0, (char)(0 + minVal));

		charMap.put((char)0x0103, (char)(1 + minVal)); 	
		charMap.put((char)0x0102, (char)(1 + minVal)); 	 	
		charMap.put((char)0x1EB1, (char)(1 + minVal)); 	 	
		charMap.put((char)0x1EB0, (char)(1 + minVal)); 	 	
		charMap.put((char)0x1EB3, (char)(1 + minVal)); 	 	
		charMap.put((char)0x1EB2, (char)(1 + minVal)); 	 	
		charMap.put((char)0x1EB5, (char)(1 + minVal)); 	 	
		charMap.put((char)0x1EB4, (char)(1 + minVal)); 	 	
		charMap.put((char)0x1EAF, (char)(1 + minVal)); 	 	
		charMap.put((char)0x1EAE, (char)(1 + minVal)); 	 	
		charMap.put((char)0x1EB7, (char)(1 + minVal)); 	 	
		charMap.put((char)0x1EB6, (char)(1 + minVal));
		
		charMap.put((char)0x00E2, (char)(2 + minVal)); 	
		charMap.put((char)0x00C2, (char)(2 + minVal));  	
		charMap.put((char)0x1EA7, (char)(2 + minVal));  	
		charMap.put((char)0x1EA6, (char)(2 + minVal));  	
		charMap.put((char)0x1EA9, (char)(2 + minVal));  	
		charMap.put((char)0x1EA8, (char)(2 + minVal));  	
		charMap.put((char)0x1EAB, (char)(2 + minVal));  	
		charMap.put((char)0x1EAA, (char)(2 + minVal));  	
		charMap.put((char)0x1EA5, (char)(2 + minVal));  	
		charMap.put((char)0x1EA4, (char)(2 + minVal));  	
		charMap.put((char)0x1EAD, (char)(2 + minVal));  	
		charMap.put((char)0x1EAC, (char)(2 + minVal));
		
		charMap.put((char)0x0062, (char)(3 + minVal)); 	
		charMap.put((char)0x0042, (char)(3 + minVal));

		charMap.put((char)0x0063, (char)(4 + minVal)); 	
		charMap.put((char)0x0043, (char)(4 + minVal));

		charMap.put((char)0x0064, (char)(5 + minVal)); 	
		charMap.put((char)0x0044, (char)(5 + minVal));

		charMap.put((char)0x0111, (char)(6 + minVal)); 	
		charMap.put((char)0x0110, (char)(6 + minVal));

		charMap.put((char)0x0065, (char)(7 + minVal));  	
		charMap.put((char)0x0045, (char)(7 + minVal));  	
		charMap.put((char)0x00E8, (char)(7 + minVal));  	
		charMap.put((char)0x00C8, (char)(7 + minVal));  	
		charMap.put((char)0x1EBB, (char)(7 + minVal));  	
		charMap.put((char)0x1EBA, (char)(7 + minVal));  	
		charMap.put((char)0x1EBD, (char)(7 + minVal));  	
		charMap.put((char)0x1EBC, (char)(7 + minVal));  	
		charMap.put((char)0x00E9, (char)(7 + minVal));  	
		charMap.put((char)0x00C9, (char)(7 + minVal));  	
		charMap.put((char)0x1EB9, (char)(7 + minVal));  	
		charMap.put((char)0x1EB8, (char)(7 + minVal));

		charMap.put((char)0x00EA, (char)(8 + minVal));  	
		charMap.put((char)0x00CA, (char)(8 + minVal));  	
		charMap.put((char)0x1EC1, (char)(8 + minVal));  	
		charMap.put((char)0x1EC0, (char)(8 + minVal));  	
		charMap.put((char)0x1EC3, (char)(8 + minVal));  	
		charMap.put((char)0x1EC2, (char)(8 + minVal));  	
		charMap.put((char)0x1EC5, (char)(8 + minVal));  	
		charMap.put((char)0x1EC4, (char)(8 + minVal));  	
		charMap.put((char)0x1EBF, (char)(8 + minVal));  	
		charMap.put((char)0x1EBE, (char)(8 + minVal));  	
		charMap.put((char)0x1EC7, (char)(8 + minVal));  	
		charMap.put((char)0x1EC6, (char)(8 + minVal));
		
		charMap.put((char)0x0067, (char)(9 + minVal));   	
		charMap.put((char)0x0047, (char)(9 + minVal));

		charMap.put((char)0x0068, (char)(10 + minVal));   	
		charMap.put((char)0x0048, (char)(10 + minVal));

		charMap.put((char)0x0069, (char)(11 + minVal));  	
		charMap.put((char)0x0049, (char)(11 + minVal));  	
		charMap.put((char)0x00EC, (char)(11 + minVal));  	
		charMap.put((char)0x00CC, (char)(11 + minVal));  	
		charMap.put((char)0x1EC9, (char)(11 + minVal));  	
		charMap.put((char)0x1EC8, (char)(11 + minVal));  	
		charMap.put((char)0x0129, (char)(11 + minVal));  	
		charMap.put((char)0x0128, (char)(11 + minVal));  	
		charMap.put((char)0x00ED, (char)(11 + minVal));  	
		charMap.put((char)0x00CD, (char)(11 + minVal));  	
		charMap.put((char)0x1ECB, (char)(11 + minVal));  	
		charMap.put((char)0x1ECA, (char)(11 + minVal));

		charMap.put((char)0x006B, (char)(12 + minVal));  
		charMap.put((char)0x004B, (char)(12 + minVal));
		
		charMap.put((char)0x006C, (char)(13 + minVal)); 
		charMap.put((char)0x004C, (char)(13 + minVal));
		
		charMap.put((char)0x006D, (char)(14 + minVal)); 
		charMap.put((char)0x004D, (char)(14 + minVal));
		
		charMap.put((char)0x006E, (char)(15 + minVal)); 
		charMap.put((char)0x004E, (char)(15 + minVal));

		charMap.put((char)0x006F, (char)(16 + minVal));   	
		charMap.put((char)0x004F, (char)(16 + minVal));   	
		charMap.put((char)0x00F2, (char)(16 + minVal));   	
		charMap.put((char)0x00D2, (char)(16 + minVal));   	
		charMap.put((char)0x1ECF, (char)(16 + minVal));   	
		charMap.put((char)0x1ECE, (char)(16 + minVal));   	
		charMap.put((char)0x00F5, (char)(16 + minVal));   	
		charMap.put((char)0x00D5, (char)(16 + minVal));   	
		charMap.put((char)0x00F3, (char)(16 + minVal));   	
		charMap.put((char)0x00D3, (char)(16 + minVal));   	
		charMap.put((char)0x1ECD, (char)(16 + minVal));   	
		charMap.put((char)0x1ECC, (char)(16 + minVal));
		
		charMap.put((char)0x00F4, (char)(17 + minVal));  	
		charMap.put((char)0x00D4, (char)(17 + minVal));  	
		charMap.put((char)0x1ED3, (char)(17 + minVal));  	
		charMap.put((char)0x1ED2, (char)(17 + minVal));  	
		charMap.put((char)0x1ED5, (char)(17 + minVal));  	
		charMap.put((char)0x1ED4, (char)(17 + minVal));  	
		charMap.put((char)0x1ED7, (char)(17 + minVal));  	
		charMap.put((char)0x1ED6, (char)(17 + minVal));  	
		charMap.put((char)0x1ED1, (char)(17 + minVal));  	
		charMap.put((char)0x1ED0, (char)(17 + minVal));  	
		charMap.put((char)0x1ED9, (char)(17 + minVal));  	
		charMap.put((char)0x1ED8, (char)(17 + minVal));

		charMap.put((char)0x01A1, (char)(18 + minVal));  	
		charMap.put((char)0x01A0, (char)(18 + minVal));  	
		charMap.put((char)0x1EDD, (char)(18 + minVal));  	
		charMap.put((char)0x1EDC, (char)(18 + minVal));  	
		charMap.put((char)0x1EDF, (char)(18 + minVal));  	
		charMap.put((char)0x1EDE, (char)(18 + minVal));  	
		charMap.put((char)0x1EE1, (char)(18 + minVal));  	
		charMap.put((char)0x1EE0, (char)(18 + minVal));  	
		charMap.put((char)0x1EDB, (char)(18 + minVal));  	
		charMap.put((char)0x1EDA, (char)(18 + minVal));  	
		charMap.put((char)0x1EE3, (char)(18 + minVal));  	
		charMap.put((char)0x1EE2, (char)(18 + minVal));
		
		charMap.put((char)0x0070, (char)(19 + minVal)); 	
		charMap.put((char)0x0050, (char)(19 + minVal));

		charMap.put((char)0x0071, (char)(20 + minVal)); 	
		charMap.put((char)0x0051, (char)(20 + minVal));

		charMap.put((char)0x0072, (char)(21 + minVal)); 	
		charMap.put((char)0x0052, (char)(21 + minVal));

		charMap.put((char)0x0073, (char)(22 + minVal)); 	
		charMap.put((char)0x0053, (char)(22 + minVal));

		charMap.put((char)0x0074, (char)(23 + minVal)); 	
		charMap.put((char)0x0054, (char)(23 + minVal));
		
		charMap.put((char)0x0075, (char)(24 + minVal));   	
		charMap.put((char)0x0055, (char)(24 + minVal));   	
		charMap.put((char)0x00F9, (char)(24 + minVal));   	
		charMap.put((char)0x00D9, (char)(24 + minVal));   	
		charMap.put((char)0x1EE7, (char)(24 + minVal));   	
		charMap.put((char)0x1EE6, (char)(24 + minVal));   	
		charMap.put((char)0x0169, (char)(24 + minVal));   	
		charMap.put((char)0x0168, (char)(24 + minVal));   	
		charMap.put((char)0x00FA, (char)(24 + minVal));   	
		charMap.put((char)0x00DA, (char)(24 + minVal));   	
		charMap.put((char)0x1EE5, (char)(24 + minVal));   	
		charMap.put((char)0x1EE4, (char)(24 + minVal));

		charMap.put((char)0x01B0, (char)(25 + minVal));  	
		charMap.put((char)0x01AF, (char)(25 + minVal));  	
		charMap.put((char)0x1EEB, (char)(25 + minVal));  	
		charMap.put((char)0x1EEA, (char)(25 + minVal));  	
		charMap.put((char)0x1EED, (char)(25 + minVal));  	
		charMap.put((char)0x1EEC, (char)(25 + minVal));  	
		charMap.put((char)0x1EEF, (char)(25 + minVal));  	
		charMap.put((char)0x1EEE, (char)(25 + minVal));  	
		charMap.put((char)0x1EE9, (char)(25 + minVal));  	
		charMap.put((char)0x1EE8, (char)(25 + minVal));  	
		charMap.put((char)0x1EF1, (char)(25 + minVal));  	
		charMap.put((char)0x1EF0, (char)(25 + minVal));

		charMap.put((char)0x0076, (char)(26 + minVal));  	 	
		charMap.put((char)0x0056, (char)(26 + minVal));

		charMap.put((char)0x0078, (char)(27 + minVal));  	 	
		charMap.put((char)0x0058, (char)(27 + minVal));

		charMap.put((char)0x0079, (char)(28 + minVal)); 	
		charMap.put((char)0x0059, (char)(28 + minVal)); 	
		charMap.put((char)0x1EF3, (char)(28 + minVal)); 	
		charMap.put((char)0x1EF2, (char)(28 + minVal)); 	
		charMap.put((char)0x1EF7, (char)(28 + minVal)); 	
		charMap.put((char)0x1EF6, (char)(28 + minVal)); 	
		charMap.put((char)0x1EF9, (char)(28 + minVal)); 	
		charMap.put((char)0x1EF8, (char)(28 + minVal)); 	
		charMap.put((char)0x00FD, (char)(28 + minVal)); 	
		charMap.put((char)0x00DD, (char)(28 + minVal)); 	
		charMap.put((char)0x1EF5, (char)(28 + minVal)); 	
		charMap.put((char)0x1EF4, (char)(28 + minVal));
	
	}

}
