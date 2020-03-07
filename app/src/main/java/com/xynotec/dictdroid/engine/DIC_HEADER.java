package com.xynotec.dictdroid.engine;

public class DIC_HEADER
{
	public final static int RES_SIZE = 44; 
	public int numEntry;
	public int numBlock;
	public int sourceLang;
	public int destinationLang;
	public int dataSource;
	public byte[] bRes = new byte[RES_SIZE];
	
	public DIC_HEADER()
	{
		
	}

}
