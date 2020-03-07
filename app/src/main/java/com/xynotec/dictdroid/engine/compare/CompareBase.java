package com.xynotec.dictdroid.engine.compare;

import java.util.HashMap;

public abstract class CompareBase
{
	protected char minVal;
	char[] specialChar = 
	{
		'\'',
		0x2019,//'�',
		'-',
		' ',	
		'&',
		'.',
		'/',
		'!',
		'@',
		'#',
		'$',
		'%',
		'^',	
		'*',
		'(',
		')',	
		'_',
		'=',
		'+',
		'[',
		']',
		'{',
		'}',
		'\\',
		'|',
		';',
		':',	
		'"',
		',',
		'<',	
		'>'/*,	
		'?'*/
	};
	
	HashMap specialCharMap = null;
	public HashMap charMap = null;
	
	public CompareBase()
	{
		specialCharMap = new HashMap(specialChar.length);
		for(int i = 0; i < specialChar.length; i++)
			specialCharMap.put(specialChar[i], (char)i);		
	}
	
	public int compare(String s1, String s2)
	{
		String v1 = getComparableKey(s1);		
		String v2 = getComparableKey(s2);
		
		int v1_length = v1.length();
		int v2_length = v2.length();

		int n = Math.min(v1_length, v2_length);
		int i = 0;
		int j = 0;

		while (n-- != 0) 
		{
			char c1 = v1.charAt(i); i++;
			char c2 = v2.charAt(j); j++;
			if (c1 != c2) 
				return c1 - c2;
		}
		return v1_length - v2_length;
	}
	
	protected String getComparableKey(String key)
	{
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < key.length(); ++i) 
		{
			char c = key.charAt(i);
			Character val = 0;
			boolean bLookup = charMap.containsKey(c);
			if (bLookup)
			{
				val = (Character)charMap.get(c);
				sb.append(val.charValue());
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
