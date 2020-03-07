package com.xynotec.dictdroid.engine.compare;

public class CompareKorean extends CompareBase
{
	public CompareKorean()
	{
	
	}
	
	public int compare(String s1, String s2)
	{
		int s1_length = s1.length();
		int s2_length = s2.length();
		int n = Math.min(s1_length, s2_length);
		int i = 0;
		int j = 0;

		while (n-- != 0) 
		{
			char c1 = s1.charAt(i); i++;
			char c2 = s2.charAt(j); j++;
			if (c1 != c2) 
				return c1 - c2;
		}
		return s1_length - s2_length;

	}
}
