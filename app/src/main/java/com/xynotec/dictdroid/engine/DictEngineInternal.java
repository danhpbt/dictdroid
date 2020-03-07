package com.xynotec.dictdroid.engine;

import java.io.DataInputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.xynotec.dictdroid.engine.compare.CompareAlbanian;
import com.xynotec.dictdroid.engine.compare.CompareArabic;
import com.xynotec.dictdroid.engine.compare.CompareArmenian;
import com.xynotec.dictdroid.engine.compare.CompareAzerbaijani;
import com.xynotec.dictdroid.engine.compare.CompareBulgarian;
import com.xynotec.dictdroid.engine.compare.CompareCroatian;
import com.xynotec.dictdroid.engine.compare.CompareCzech;
import com.xynotec.dictdroid.engine.compare.CompareDanish;
import com.xynotec.dictdroid.engine.compare.CompareDutch;
import com.xynotec.dictdroid.engine.compare.CompareEnglish;
import com.xynotec.dictdroid.engine.compare.CompareEstonian;
import com.xynotec.dictdroid.engine.compare.CompareFilipino;
import com.xynotec.dictdroid.engine.compare.CompareFinnish;
import com.xynotec.dictdroid.engine.compare.CompareFrench;
import com.xynotec.dictdroid.engine.compare.CompareGerman;
import com.xynotec.dictdroid.engine.compare.CompareGreek;
import com.xynotec.dictdroid.engine.compare.CompareHebrew;
import com.xynotec.dictdroid.engine.compare.CompareHungarian;
import com.xynotec.dictdroid.engine.compare.CompareIndonesian;
import com.xynotec.dictdroid.engine.compare.CompareItalian;
import com.xynotec.dictdroid.engine.compare.CompareKorean;
import com.xynotec.dictdroid.engine.compare.CompareLatin;
import com.xynotec.dictdroid.engine.compare.CompareLatvian;
import com.xynotec.dictdroid.engine.compare.CompareLithuanian;
import com.xynotec.dictdroid.engine.compare.CompareMongolian;
import com.xynotec.dictdroid.engine.compare.CompareNorwegian;
import com.xynotec.dictdroid.engine.compare.ComparePersian;
import com.xynotec.dictdroid.engine.compare.ComparePolish;
import com.xynotec.dictdroid.engine.compare.ComparePortuguese;
import com.xynotec.dictdroid.engine.compare.CompareRomanian;
import com.xynotec.dictdroid.engine.compare.CompareRussian;
import com.xynotec.dictdroid.engine.compare.CompareSerbian;
import com.xynotec.dictdroid.engine.compare.CompareSlovak;
import com.xynotec.dictdroid.engine.compare.CompareSlovenian;
import com.xynotec.dictdroid.engine.compare.CompareSpanish;
import com.xynotec.dictdroid.engine.compare.CompareSwedish;
import com.xynotec.dictdroid.engine.compare.CompareTurkish;
import com.xynotec.dictdroid.engine.compare.CompareUkrainian;
import com.xynotec.dictdroid.engine.compare.CompareVietnamese;
import com.xynotec.dictdroid.engine.compare.CompareYiddish;

public class DictEngineInternal extends DictEngine
{
	Context mContext;
	DataInputStream fDic = null;
	
	public DictEngineInternal(Context context)
	{
		mContext = context;
	}
	
	@Override
	public void OpenDict(String path)
	{
		// TODO Auto-generated method stub
		try
		{
			if (fDic != null)
			{
				fDic.close();
				fDic = null;
			}

			AssetManager am = mContext.getAssets();
			fDic = new DataInputStream(am.open(path, AssetManager.ACCESS_RANDOM));
			
			DIC_HEADER dicHeader = new DIC_HEADER();
			fDic.reset();
			dicHeader.numEntry = IntC2Java(fDic.readInt());
			dicHeader.numBlock = IntC2Java(fDic.readInt());
			dicHeader.sourceLang = IntC2Java(fDic.readInt());
			dicHeader.destinationLang = IntC2Java(fDic.readInt());
			dicHeader.dataSource = IntC2Java(fDic.readInt());
			
			sourceLang = compareType = dicHeader.sourceLang;
			destinationLang = dicHeader.destinationLang;
			dataSource = dicHeader.dataSource;
				
			fDic.read(dicHeader.bRes, 0, DIC_HEADER.RES_SIZE);
			
			numWordInDic = dicHeader.numEntry;
			numblockInDic = dicHeader.numBlock;
			dataBlockInfo = new BLOCK_INFO[numblockInDic];
			
			for(int i = 0; i < numblockInDic; i++)
			{
				dataBlockInfo[i] = new BLOCK_INFO();
				dataBlockInfo[i].blockAdress = IntC2Java(fDic.readInt());
				dataBlockInfo[i].blockSize = IntC2Java(fDic.readInt());
				dataBlockInfo[i].numWord = IntC2Java(fDic.readInt());
			}
			
			indexInBlock = 0;
			currentblockID = 1;			
		
			switch (compareType)
			{
				case LangConst.ALBANIAN:
					compare = new CompareAlbanian();
					break;
	
				case LangConst.ARABIC:
					compare = new CompareArabic();
					break;
	
				case LangConst.ARMENIAN:
					compare = new CompareArmenian();
					break;
	
				case LangConst.AZERBAIJANI:
					compare = new CompareAzerbaijani();
					break;
	
				case LangConst.BULGARIAN:
					compare = new CompareBulgarian();
					break;
	
				case LangConst.CROATIAN:
					compare = new CompareCroatian();
					break;
	
				case LangConst.CZECH:
					compare = new CompareCzech();
					break;
	
				case LangConst.DANISH:
					compare = new CompareDanish();
					break;
	
				case LangConst.DUTCH:
					compare = new CompareDutch();
					break;
	
//				case LangConst.ENGLISH:
//					compare = new CompareEnglish();
//					break;
	
				case LangConst.ESTONIAN:
					compare = new CompareEstonian();
					break;
	
				case LangConst.FILIPINO:
					compare = new CompareFilipino();
					break;
					
				case LangConst.FINNISH:
					compare = new CompareFinnish();
					break;
	
				case LangConst.FRENCH:
					compare = new CompareFrench();
					break;
	
				case LangConst.GERMAN:
					compare = new CompareGerman();
					break;
	
				case LangConst.GREEK:
					compare = new CompareGreek();
					break;
	
				case LangConst.HEBREW:
					compare = new CompareHebrew();
					break;
	
				case LangConst.HUNGARIAN:
					compare = new CompareHungarian();
					break;
	
				case LangConst.INDONESIAN:
					compare = new CompareIndonesian();
					break;
	
				case LangConst.ITALIAN:
					compare = new CompareItalian();
					break;
	
				case LangConst.KOREAN:
					compare = new CompareKorean();
					break;
	
				case LangConst.LATIN:
					compare = new CompareLatin();
					break;
	
				case LangConst.LATVIAN:
					compare = new CompareLatvian();
					break;
	
				case LangConst.LITHUANIAN:
					compare = new CompareLithuanian();
					break;
	
				case LangConst.NORWEGIAN:
					compare = new CompareNorwegian();
					break;
	
				case LangConst.PERSIAN:
					compare = new ComparePersian();
					break;
	
				case LangConst.POLISH:
					compare = new ComparePolish();
					break;
	
				case LangConst.PORTUGUESE:
					compare = new ComparePortuguese();
					break;
	
				case LangConst.ROMANIAN:
					compare = new CompareRomanian();
					break;
	
				case LangConst.RUSSIAN:
					compare = new CompareRussian();
					break;
	
				case LangConst.SERBIAN:
					compare = new CompareSerbian();
					break;
	
				case LangConst.SLOVAK:
					compare = new CompareSlovak();
					break;
	
				case LangConst.SLOVENIAN:
					compare = new CompareSlovenian();
					break;
	
				case LangConst.SPANISH:
					compare = new CompareSpanish();
					break;
	
				case LangConst.SWEDISH:
					compare = new CompareSwedish();
					break;
	
				case LangConst.TURKISH:
					compare = new CompareTurkish();
					break;
	
				case LangConst.UKRAINIAN:
					compare = new CompareUkrainian();
					break;
	
				case LangConst.VIETNAMESE:
					compare = new CompareVietnamese();
					break;
	
				case LangConst.YIDDISH:
					compare = new CompareYiddish();
					break;
					
				case LangConst.MONGOLIAN:
					compare = new CompareMongolian();
					break;
	
				default:
					compare = new CompareEnglish();
					break;
			}
			
			indexWordNum = dataBlockInfo[0].numWord;
			lastblockID = 1;
			
			ReadDataAtBlock(indexData, 0);
			ReadDataAtBlock(dataBlock, 1);
		}
		catch (Exception ex)
		{
			Log.d("DictEngineInternal - OpenDict", ex.getMessage());
		}
	}

	@Override
	void ReadDataAtBlock(byte[] blockData, int block)
	{
		// TODO Auto-generated method stub
		try
		{
			int posInFile = dataBlockInfo[block].blockAdress;
			int dataSize = dataBlockInfo[block].blockSize;
			byte[] data = new byte[dataSize];
			
			fDic.reset();
			fDic.skip(posInFile);
			fDic.read(data, 0, dataSize);			
			
			//long time = System.currentTimeMillis();			
			DecoderLzma(data, dataSize, blockData, BLOCK_DATA_SIZE);
			//time = SystemClock.uptimeMillis() - time;
			//int size = 0;
		}
		catch (Exception ex)
		{
			Log.d("DictEngineInternal - ReadDataAtBlock", ex.getMessage());						
		}
	}

}
