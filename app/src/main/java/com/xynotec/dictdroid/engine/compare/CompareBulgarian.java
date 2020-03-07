package com.xynotec.dictdroid.engine.compare;

import java.util.HashMap;

public class CompareBulgarian extends CompareBase
{
	char[] charCollation = 
	{		
		0x0430, 	
		0x0410, 	
		//0430 0300 	
		//0410 0300
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
		//0435 0300 	
		//0415 0300
		0x0436, 	
		0x0416,
		0x0437, 	
		0x0417,
		0x0438, 	
		0x0418, 	
		//0438 0300 	
		//0418 0300
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
		0x043E, 	
		0x041E, 	
		//043E 0300 	
		//041E 0300
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
		//0443 0300 	
		//0423 0300
		0x0444, 	
		0x0424,
		0x0445, 	
		0x0425,
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
		//044A 0300 	
		//042A 0300
		0x044C, 	
		0x042C,
		0x044E, 	
		0x042E, 	
		//044E 0300 	
		//042E 0300
		0x044F, 	
		0x042F, 	
		//044F 0300 	
		//042F 0300 			
	};	

	public CompareBulgarian()
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
		//0430 0300 		 , (char)(0 + minVal));	
		//0410 0300			 , (char)(0 + minVal));	

		charMap.put((char)0x0431, (char)(1 + minVal));	 	
		charMap.put((char)0x0411, (char)(1 + minVal));	

		charMap.put((char)0x0432, (char)(2 + minVal));	 	
		charMap.put((char)0x0412, (char)(2 + minVal));	

		charMap.put((char)0x0433, (char)(3 + minVal));	 	
		charMap.put((char)0x0413, (char)(3 + minVal));	

		charMap.put((char)0x0434, (char)(4 + minVal));	 	
		charMap.put((char)0x0414, (char)(4 + minVal));	

		charMap.put((char)0x0435, (char)(5 + minVal));	 	
		charMap.put((char)0x0415, (char)(5 + minVal));	 	
		//0435 0300 		 , (char)(5 + minVal));	
		//0415 0300			 , (char)(5 + minVal));	

		charMap.put((char)0x0436, (char)(6 + minVal));	 	
		charMap.put((char)0x0416, (char)(6 + minVal));	

		charMap.put((char)0x0437, (char)(7 + minVal));	 	
		charMap.put((char)0x0417, (char)(7 + minVal));	

		charMap.put((char)0x0438, (char)(8 + minVal));	 	
		charMap.put((char)0x0418, (char)(8 + minVal));	 	
		//0438 0300 		 , (char)(8 + minVal));	
		//0418 0300			 , (char)(8 + minVal));	

		charMap.put((char)0x0439, (char)(9 + minVal));	 	
		charMap.put((char)0x0419, (char)(9 + minVal));	

		charMap.put((char)0x043A, (char)(10 + minVal));	 	
		charMap.put((char)0x041A, (char)(10 + minVal));	

		charMap.put((char)0x043B, (char)(11 + minVal));	 	
		charMap.put((char)0x041B, (char)(11 + minVal));	

		charMap.put((char)0x043C, (char)(12 + minVal));	 	
		charMap.put((char)0x041C, (char)(12 + minVal));	

		charMap.put((char)0x043D, (char)(13 + minVal));	 	
		charMap.put((char)0x041D, (char)(13 + minVal));	

		charMap.put((char)0x043E, (char)(14 + minVal));	 	
		charMap.put((char)0x041E, (char)(14 + minVal));	 	
		//043E 0300 		 , (char)(14 + minVal));	
		//041E 0300			 , (char)(14 + minVal));	

		charMap.put((char)0x043F, (char)(15 + minVal));	 	
		charMap.put((char)0x041F, (char)(15 + minVal));	

		charMap.put((char)0x0440, (char)(16 + minVal));	 	
		charMap.put((char)0x0420, (char)(16 + minVal));	

		charMap.put((char)0x0441, (char)(17 + minVal));	 	
		charMap.put((char)0x0421, (char)(17 + minVal));	

		charMap.put((char)0x0442, (char)(18 + minVal));	 	
		charMap.put((char)0x0422, (char)(18 + minVal));	

		charMap.put((char)0x0443, (char)(19 + minVal));	 	
		charMap.put((char)0x0423, (char)(19 + minVal));	 	
		//0443 0300 		 , (char)(19 + minVal));	
		//0423 0300			 , (char)(19 + minVal));	

		charMap.put((char)0x0444, (char)(20 + minVal));	 	
		charMap.put((char)0x0424, (char)(20 + minVal));	

		charMap.put((char)0x0445, (char)(21 + minVal));	 	
		charMap.put((char)0x0425, (char)(21 + minVal));	

		charMap.put((char)0x0446, (char)(22 + minVal));	 	
		charMap.put((char)0x0426, (char)(22 + minVal));	

		charMap.put((char)0x0447, (char)(23 + minVal));	 	
		charMap.put((char)0x0427, (char)(23 + minVal));	

		charMap.put((char)0x0448, (char)(24 + minVal));	 	
		charMap.put((char)0x0428, (char)(24 + minVal));	

		charMap.put((char)0x0449, (char)(25 + minVal));	 	
		charMap.put((char)0x0429, (char)(25 + minVal));	

		charMap.put((char)0x044A, (char)(26 + minVal));	 	
		charMap.put((char)0x042A, (char)(26 + minVal));	 	
		//044A 0300 		 , (char)(26 + minVal));	
		//042A 0300			 , (char)(26 + minVal));	

		charMap.put((char)0x044C, (char)(27 + minVal));	 	
		charMap.put((char)0x042C, (char)(27 + minVal));	

		charMap.put((char)0x044E, (char)(28 + minVal));	 	
		charMap.put((char)0x042E, (char)(28 + minVal));	 	
		//044E 0300 		 , (char)(28 + minVal));	
		//042E 0300			 , (char)(28 + minVal));	

		charMap.put((char)0x044F, (char)(29 + minVal));	 	
		charMap.put((char)0x042F, (char)(29 + minVal));	 	
		//044F 0300 		 , (char)(29 + minVal));	
		//042F 0300			 , (char)(29 + minVal));
		
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

					case 0x0430:
					case 0x0410:			

					case 0x0435:
					case 0x0415:

					case 0x0438:
					case 0x0418:

					case 0x043E:
					case 0x041E:

					case 0x0443:
					case 0x0423:

					case 0x044A:
					case 0x042A:

					case 0x044E:
					case 0x042E:

					case 0x044F:
					case 0x042F:
						//044F 0300 		 , 29 + minVal);	
						//042F 0300			 , 29 + minVal);
						if ((i + 1 < key_length) && (key.charAt(i + 1) == 0x0300))
							i++;

						sb.append(val.charValue());
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
