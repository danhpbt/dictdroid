package com.xynotec.dictdroid.data;

import java.util.HashMap;

public class GlobalData
{
	public static final String DICT1_PATH = "ende.mdo";
	public static final String DICT2_PATH = "deen.mdo";
	public static String colorBackground = "#FAFAFA";

	public static String[] mLanguages = new String[]
	{
		"Afrikaans"	 	,
		"Albanian"	 	,
		"Arabic"		,
		"Armenian"	 	,
		"Azerbaijani" 	,
		"Basque"	 	,
		"Belarusian" 	,
		"Bulgarian"	 	,
		"Catalan"	 	,
		"Chinese"	 	,
		"Croatian"	 	,
		"Czech"		 	,
		"Danish"	 	,
		"Dutch"		 	,
		"English"	 	,
		"Estonian"	 	,
		"Filipino"	 	,
		"Finnish"	 	,
		"French"	 	,
		"Galician"	 	,
		"Georgian"	 	,
		"German"	 	,
		"Greek"		 	,
		//"Haitian_creole",
		"Hebrew"		,
		"Hindi"			,
		"Hungarian"		,
		"Icelandic"		,
		"Indonesian"	,
		"Irish"			,
		"Italian"		,
		"Japanese"		,
		"Korean"		,
		"Latin"			,
		"Latvian"		,
		"Lithuanian"	,
		"Macedonian"	,
		"Malay"			,
		"Maltese"		,
		"Mongolian"		,
		"Norwegian"		,
		"Persian"		,
		"Polish"		,
		"Portuguese"	,
		"Romanian"		,
		"Russian"		,
		"Serbian"		,
		"Slovak"		,
		"Slovenian"		,
		"Spanish"		,
		"Swahili"		,
		"Swedish"		,
		"Thai"			,
		"Turkish"		,
		"Ukrainian"		,
		"Urdu"			,
		"Vietnamese"	,
		"Welsh"			,
		"Yiddish"		,
	};

	private static HashMap<Integer, String> mIndexToSymbol = new HashMap<Integer, String>();

	static
	{
		mIndexToSymbol.put(Integer.valueOf(0), 			"af");
		mIndexToSymbol.put(Integer.valueOf(1), 			"sq");
		mIndexToSymbol.put(Integer.valueOf(2), 			"ar");
		mIndexToSymbol.put(Integer.valueOf(3), 			"hy");
		mIndexToSymbol.put(Integer.valueOf(4), 			"az");
		mIndexToSymbol.put(Integer.valueOf(5), 			"eu");
		mIndexToSymbol.put(Integer.valueOf(6), 			"be");
		mIndexToSymbol.put(Integer.valueOf(7), 			"bg");
		mIndexToSymbol.put(Integer.valueOf(8), 			"ca");
		mIndexToSymbol.put(Integer.valueOf(9), 			"zh-CN");
		mIndexToSymbol.put(Integer.valueOf(10), 		"hr");
		mIndexToSymbol.put(Integer.valueOf(11), 		"cs");
		mIndexToSymbol.put(Integer.valueOf(12), 		"da");
		mIndexToSymbol.put(Integer.valueOf(13), 		"nl");
		mIndexToSymbol.put(Integer.valueOf(14), 		"en");
		mIndexToSymbol.put(Integer.valueOf(15), 		"et");
		mIndexToSymbol.put(Integer.valueOf(16), 		"tl");
		mIndexToSymbol.put(Integer.valueOf(17), 		"fi");
		mIndexToSymbol.put(Integer.valueOf(18), 		"fr");
		mIndexToSymbol.put(Integer.valueOf(19), 		"gl");
		mIndexToSymbol.put(Integer.valueOf(20), 		"ka");
		mIndexToSymbol.put(Integer.valueOf(21), 		"de");
		mIndexToSymbol.put(Integer.valueOf(22), 		"el");
		//mIndexToSymbol.put(Integer.valueOf("Haitian_creole"), "ht");
		mIndexToSymbol.put(Integer.valueOf(23), 		"iw");
		mIndexToSymbol.put(Integer.valueOf(24), 		"hi");
		mIndexToSymbol.put(Integer.valueOf(25), 		"hu");
		mIndexToSymbol.put(Integer.valueOf(26), 		"is");
		mIndexToSymbol.put(Integer.valueOf(27), 		"id");
		mIndexToSymbol.put(Integer.valueOf(28), 		"ga");
		mIndexToSymbol.put(Integer.valueOf(29), 		"it");
		mIndexToSymbol.put(Integer.valueOf(30), 		"ja");
		mIndexToSymbol.put(Integer.valueOf(31), 		"ko");
		mIndexToSymbol.put(Integer.valueOf(32), 		"la");
		mIndexToSymbol.put(Integer.valueOf(33), 		"lv");
		mIndexToSymbol.put(Integer.valueOf(34), 		"lt");
		mIndexToSymbol.put(Integer.valueOf(35), 		"mk");
		mIndexToSymbol.put(Integer.valueOf(36), 		"ms");
		mIndexToSymbol.put(Integer.valueOf(37), 		"mt");
		mIndexToSymbol.put(Integer.valueOf(38),			"mn");
		mIndexToSymbol.put(Integer.valueOf(39), 		"no");
		mIndexToSymbol.put(Integer.valueOf(40), 		"fa");
		mIndexToSymbol.put(Integer.valueOf(41), 		"pl");
		mIndexToSymbol.put(Integer.valueOf(42), 		"pt");
		mIndexToSymbol.put(Integer.valueOf(43), 		"ro");
		mIndexToSymbol.put(Integer.valueOf(44), 		"ru");
		mIndexToSymbol.put(Integer.valueOf(45), 		"sr");
		mIndexToSymbol.put(Integer.valueOf(46), 		"sk");
		mIndexToSymbol.put(Integer.valueOf(47), 		"sl");
		mIndexToSymbol.put(Integer.valueOf(48), 		"es");
		mIndexToSymbol.put(Integer.valueOf(49), 		"sw");
		mIndexToSymbol.put(Integer.valueOf(50), 		"sv");
		mIndexToSymbol.put(Integer.valueOf(51), 		"th");
		mIndexToSymbol.put(Integer.valueOf(52), 		"tr");
		mIndexToSymbol.put(Integer.valueOf(53), 		"uk");
		mIndexToSymbol.put(Integer.valueOf(54), 		"ur");
		mIndexToSymbol.put(Integer.valueOf(55), 		"vi");
		mIndexToSymbol.put(Integer.valueOf(56), 		"cy");
		mIndexToSymbol.put(Integer.valueOf(57), 		"yi");

	}

	static public String getSymbolLanguage(int index)
	{
		return (String)mIndexToSymbol.get(index);
	}

}


