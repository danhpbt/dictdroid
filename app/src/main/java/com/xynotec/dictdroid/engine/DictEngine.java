package com.xynotec.dictdroid.engine;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import android.util.Log;

import com.xynotec.dictdroid.engine.compare.CompareBase;

public abstract class DictEngine
{
	final static int SIZEOF_BLOCK_INFO = 12;
	final static int SIZEOF_DIC_HEADER = 64;
	final static int SIZEOF_WORD_ITEM = 8;
	
	final static int WORD_LENGTH = 256;
	final static int WORD_SIZE = 2*WORD_LENGTH;
	
	final static int DICT_BLOCK_SIZE = 60000;
	final static int MAX_MEAN_SIZE = 60000;
	final static int BLOCK_DATA_SIZE = DICT_BLOCK_SIZE + MAX_MEAN_SIZE;	
	
	//Compare compare = null;
	CompareBase compare = null;
	
	BLOCK_INFO[] dataBlockInfo = null;
	
	byte[] dataBlock = new byte[BLOCK_DATA_SIZE];
	byte[] indexData = new byte[BLOCK_DATA_SIZE];
	byte[] meaning = new byte[MAX_MEAN_SIZE];
	
	int numblockInDic;
	int numWordInDic;
	int indexInBlock;
	int currentblockID;
	int compareType;
	int indexWordNum;
	int lastblockID;
	int dataWordNum;

	int sourceLang;
	int destinationLang;
	int dataSource;
	
	static native void DecoderLzma(byte[] data, int dataSize, byte[] outData, int outDataSize);

	public abstract void OpenDict(String path);
	
	abstract void ReadDataAtBlock(byte[] blockData, int block);

	public int GetNumWordInDic()
	{
		return numWordInDic;
	}
	
	private String GetIndexData(int numEntry)
	{
		try
		{
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(indexData, numEntry*SIZEOF_WORD_ITEM, SIZEOF_WORD_ITEM);
			DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
			
			WORD_ITEM wordItem = new WORD_ITEM();
			wordItem.pos =  IntC2Java(dataInputStream.readInt());
			wordItem.len =  IntC2Java(dataInputStream.readInt());
			
			//US-ASCII  	Seven-bit ASCII, a.k.a. ISO646-US, a.k.a. the Basic Latin block of the Unicode character set
			//ISO-8859-1   	ISO Latin Alphabet No. 1, a.k.a. ISO-LATIN-1
			//UTF-8 	Eight-bit UCS Transformation Format
			//UTF-16BE 	Sixteen-bit UCS Transformation Format, big-endian byte order
			//UTF-16LE 	Sixteen-bit UCS Transformation Format, little-endian byte order
			//UTF-16 	Sixteen-bit UCS Transformation Format, byte order identified by an optional byte-order mark
			
			String wordString = new String(indexData, wordItem.pos, wordItem.len, "UTF-16LE");
			
			dataInputStream.close();
			byteArrayInputStream.close();
			
			return wordString;
		}
		catch (Exception ex)
		{
			Log.d("DictEngine - GetIndexData", ex.getMessage());
			return null;
		}
	}
	
	private String GetWordData(int numEntry)
	{
		try
		{
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(dataBlock, numEntry*SIZEOF_WORD_ITEM, SIZEOF_WORD_ITEM);
			DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
			
			WORD_ITEM wordItem = new WORD_ITEM();
			wordItem.pos =  IntC2Java(dataInputStream.readInt());
			wordItem.len =  IntC2Java(dataInputStream.readInt());
			
			byte wordSize = dataBlock[wordItem.pos];
			
			String wordString = new String(dataBlock, wordItem.pos + 1, wordSize, "UTF-16LE");
			
			dataInputStream.close();
			byteArrayInputStream.close();
			
			return wordString;
			
		}
		catch (Exception ex)
		{
			Log.d("DictEngine - GetWordData", ex.getMessage());
			return null;
		}
	}
	
	public String GetWord(int index)
	{
		int wordNum = 0;
		int i = 1;
		String word = "NULL";
		while (i < numblockInDic)
		{
			wordNum += dataBlockInfo[i].numWord;
			if(wordNum > index)
			{				
				int wordID = (dataBlockInfo[i].numWord) - (wordNum - index);

				if(lastblockID != i)
				{
					lastblockID = i;
					ReadDataAtBlock(dataBlock, i);
				}
				
				try
				{
					ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(dataBlock, wordID*SIZEOF_WORD_ITEM, SIZEOF_WORD_ITEM);
					DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
					
					WORD_ITEM wordItem = new WORD_ITEM();
					wordItem.pos =  IntC2Java(dataInputStream.readInt());
					wordItem.len =  IntC2Java(dataInputStream.readInt());
					
					byte wordSize = dataBlock[wordItem.pos];
					word = new String(dataBlock, wordItem.pos + 1, wordSize, "UTF-16LE");
	
					dataInputStream.close();
					byteArrayInputStream.close();
				}
				catch (Exception ex)
				{					
					Log.d("DictEngine - GetWord", ex.getMessage());
				}
				
				break;
			}
			i++;
		}
		return word;
	}
	
	private String GetMeanData(int numEntry)
	{
		try
		{
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(dataBlock, numEntry*SIZEOF_WORD_ITEM, SIZEOF_WORD_ITEM);
			DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
			
			WORD_ITEM wordItem = new WORD_ITEM();
			wordItem.pos =  IntC2Java(dataInputStream.readInt());
			wordItem.len =  IntC2Java(dataInputStream.readInt());
			
			byte wordSize = dataBlock[wordItem.pos];
			int sizeMean = (wordItem.len - wordSize - 1);
			
			String meanString = new String(dataBlock, wordItem.pos + 1 + wordSize, sizeMean, "UTF-16LE");
			//String meanString = new String(dataBlock, wordItem.pos + 1 + wordSize, sizeMean, "UTF-8");
						
			dataInputStream.close();
			byteArrayInputStream.close();
			
			return meanString;			
		}
		catch (Exception ex)
		{
			Log.d("DictEngine - GetMeanData", ex.getMessage());
			return null;
		}
	}
	public String GetMeanWord(int index)
	{
		int wordNum = 0;
		int i = 1;
		while (i < numblockInDic)
		{
			wordNum += dataBlockInfo[i].numWord;
			if(wordNum > index)
			{
				int wordID = (dataBlockInfo[i].numWord) - (wordNum - index);

				if(lastblockID != i)
				{
					lastblockID = i;
					ReadDataAtBlock(dataBlock, i);
				}				
				return GetMeanData(wordID);
			}
			i++;
		}
		return null;
	}
	
	private int CompareString(String text1, String text2)
	{
		return compare.compare(text1, text2);
	}

	public int OnEditSearch(String editText)
	{		
		int l1 = 1;
		int l2 = indexWordNum;
		int maxBlock = l2;
		int l3 = 0;
		int lCmp;
		String word = null;
		while (l2>=l1)
		{
			l3 = (l1 + l2)/2;
			if (l3 == maxBlock)
				break;			
			
			word = GetIndexData(l3);
			lCmp = CompareString(editText, word);
			if (lCmp == 0)
				break;
			else if (lCmp<0)
				l2 = l3 - 1;
			else
				l1 = l3 + 1;
		}

		if (l1 > l2)
			l3++;
		if (l3 > l2)
			l3 = l2 + 1;

		currentblockID = l3;
		lastblockID = l3;
		ReadDataAtBlock(dataBlock, currentblockID);

		l1 = 0;
		l2 = dataBlockInfo[currentblockID].numWord - 1;
		dataWordNum = l2;

		while (l2>=l1)
		{
			l3 = (l1 + l2)/2;
			
			word = GetWordData(l3);
			lCmp = CompareString(editText, word);
			if (lCmp == 0)
				break;
			else if (lCmp<0)
				l2 = l3 - 1;
			else
				l1 = l3 + 1;
		}

		if (l1 > l2)
			l3++;
		if (l3 > l2)
			l3 = l2 + 1;

		indexInBlock = l3;		
		return GetWordIndex();		
	}


	int GetWordIndex()
	{
		int wordIndex = 0;
		int i = 1;
		while (i < currentblockID)
		{
			wordIndex += dataBlockInfo[i].numWord;
			i++;
		}
		wordIndex = wordIndex + indexInBlock;
		return wordIndex;
	}

	public int getSourceLang()
	{
		return sourceLang;
	}

	public int getDestinationLang()
	{
		return destinationLang;
	}

	public int getDataSource()
	{
		return dataSource;
	}

	// 4-byte number
	public static int IntC2Java(int i)
	{
		return((i&0xff)<<24)|((i&0xff00)<<8)|((i&0xff0000)>>8)|((i>>24)&0xff);
	}
	
}

