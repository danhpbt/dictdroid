package com.xynotec.dictdroid.engine;

import java.util.HashMap;
import java.util.Locale;

public class LangConst
{
	//data from http://translate.google.com
	public final static int 	AFRIKAANS	 	= 0;
	public final static int 	ALBANIAN	 	= 1;
	public final static int 	ARABIC		 	= 2;
	public final static int 	ARMENIAN	 	= 3;
	public final static int 	AZERBAIJANI	 	= 4;
	public final static int 	BASQUE		 	= 5;
	public final static int 	BELARUSIAN	 	= 6;
	public final static int 	BULGARIAN	 	= 7;
	public final static int 	CATALAN		 	= 8;
	public final static int 	CHINESE		 	= 9;
	public final static int 	CROATIAN	 	= 10;
	public final static int 	CZECH		 	= 11;
	public final static int 	DANISH		 	= 12;
	public final static int 	DUTCH		 	= 13;
	public final static int 	ENGLISH		 	= 14;
	public final static int 	ESTONIAN	 	= 15;
	public final static int 	FILIPINO	 	= 16;
	public final static int 	FINNISH		 	= 17;
	public final static int 	FRENCH		 	= 18;
	public final static int 	GALICIAN	 	= 19;
	public final static int 	GEORGIAN	 	= 20;
	public final static int 	GERMAN		 	= 21;
	public final static int 	GREEK		 	= 22;
	public final static int 	HAITIAN_CREOLE	= 23;
	public final static int 	HEBREW			= 24;
	public final static int 	HINDI			= 25;
	public final static int 	HUNGARIAN		= 26;
	public final static int 	ICELANDIC		= 27;
	public final static int 	INDONESIAN		= 28;
	public final static int 	IRISH			= 29;
	public final static int 	ITALIAN			= 30;
	public final static int 	JAPANESE		= 31;
	public final static int 	KOREAN			= 32;
	public final static int 	LATIN			= 33;
	public final static int 	LATVIAN			= 34;
	public final static int 	LITHUANIAN		= 35;
	public final static int 	MACEDONIAN		= 36;
	public final static int 	MALAY			= 37;
	public final static int 	MALTESE			= 38;
	public final static int 	NORWEGIAN		= 39;
	public final static int 	PERSIAN			= 40;
	public final static int 	POLISH			= 41;
	public final static int 	PORTUGUESE		= 42;
	public final static int 	ROMANIAN		= 43;
	public final static int 	RUSSIAN			= 44;
	public final static int 	SERBIAN			= 45;
	public final static int 	SLOVAK			= 46;
	public final static int 	SLOVENIAN		= 47;
	public final static int 	SPANISH			= 48;
	public final static int 	SWAHILI			= 49;
	public final static int 	SWEDISH			= 50;
	public final static int 	THAI			= 51;
	public final static int 	TURKISH			= 52;
	public final static int 	UKRAINIAN		= 53;
	public final static int 	URDU			= 54;
	public final static int 	VIETNAMESE		= 55;
	public final static int 	WELSH			= 56;
	public final static int 	YIDDISH			= 57;
	public final static int 	MONGOLIAN		= 58;
	
	static HashMap<Integer, String> langToSymbol = new HashMap<Integer, String>();
	static
	{
		langToSymbol.put(Integer.valueOf(AFRIKAANS)        ,"af");
		langToSymbol.put(Integer.valueOf(ALBANIAN)         ,"sq");
		langToSymbol.put(Integer.valueOf(ARABIC)           ,"ar");
		langToSymbol.put(Integer.valueOf(ARMENIAN)         ,"hy");
		langToSymbol.put(Integer.valueOf(AZERBAIJANI)      ,"az");
		langToSymbol.put(Integer.valueOf(BASQUE)           ,"eu");
		langToSymbol.put(Integer.valueOf(BELARUSIAN)       ,"be");
		langToSymbol.put(Integer.valueOf(BULGARIAN)        ,"bg");
		langToSymbol.put(Integer.valueOf(CATALAN)          ,"ca");
		langToSymbol.put(Integer.valueOf(CHINESE)          ,"zh-CN");
		langToSymbol.put(Integer.valueOf(CROATIAN)         ,"hr");
		langToSymbol.put(Integer.valueOf(CZECH)            ,"cs");
		langToSymbol.put(Integer.valueOf(DANISH)           ,"da");
		langToSymbol.put(Integer.valueOf(DUTCH)            ,"nl");
		langToSymbol.put(Integer.valueOf(ENGLISH)          ,"en");
		langToSymbol.put(Integer.valueOf(ESTONIAN)         ,"et");
		langToSymbol.put(Integer.valueOf(FILIPINO)         ,"tl");
		langToSymbol.put(Integer.valueOf(FINNISH)          ,"fi");
		langToSymbol.put(Integer.valueOf(FRENCH)           ,"fr");
		langToSymbol.put(Integer.valueOf(GALICIAN)         ,"gl");
		langToSymbol.put(Integer.valueOf(GEORGIAN)         ,"ka");
		langToSymbol.put(Integer.valueOf(GERMAN)           ,"de");
		langToSymbol.put(Integer.valueOf(GREEK)            ,"el");
		langToSymbol.put(Integer.valueOf(HAITIAN_CREOLE)   , "ht");
		langToSymbol.put(Integer.valueOf(HEBREW)           ,"iw");
		langToSymbol.put(Integer.valueOf(HINDI)            ,"hi");
		langToSymbol.put(Integer.valueOf(HUNGARIAN)        ,"hu");
		langToSymbol.put(Integer.valueOf(ICELANDIC)        ,"is");
		langToSymbol.put(Integer.valueOf(INDONESIAN)       ,"id");
		langToSymbol.put(Integer.valueOf(IRISH)            ,"ga");
		langToSymbol.put(Integer.valueOf(ITALIAN)          ,"it");
		langToSymbol.put(Integer.valueOf(JAPANESE)         ,"ja");
		langToSymbol.put(Integer.valueOf(KOREAN)           ,"ko");
		langToSymbol.put(Integer.valueOf(LATIN)            ,"la");
		langToSymbol.put(Integer.valueOf(LATVIAN)          ,"lv");
		langToSymbol.put(Integer.valueOf(LITHUANIAN)       ,"lt");
		langToSymbol.put(Integer.valueOf(MACEDONIAN)       ,"mk");
		langToSymbol.put(Integer.valueOf(MALAY)            ,"ms");
		langToSymbol.put(Integer.valueOf(MALTESE)          ,"mt");
		langToSymbol.put(Integer.valueOf(NORWEGIAN)        ,"no");
		langToSymbol.put(Integer.valueOf(PERSIAN)          ,"fa");
		langToSymbol.put(Integer.valueOf(POLISH)           ,"pl");
		langToSymbol.put(Integer.valueOf(PORTUGUESE)       ,"pt");
		langToSymbol.put(Integer.valueOf(ROMANIAN)         ,"ro");
		langToSymbol.put(Integer.valueOf(RUSSIAN)          ,"ru");
		langToSymbol.put(Integer.valueOf(SERBIAN)          ,"sr");
		langToSymbol.put(Integer.valueOf(SLOVAK)           ,"sk");
		langToSymbol.put(Integer.valueOf(SLOVENIAN)        ,"sl");
		langToSymbol.put(Integer.valueOf(SPANISH)          ,"es");
		langToSymbol.put(Integer.valueOf(SWAHILI)          ,"sw");
		langToSymbol.put(Integer.valueOf(SWEDISH)          ,"sv");
		langToSymbol.put(Integer.valueOf(THAI)             ,"th");
		langToSymbol.put(Integer.valueOf(TURKISH)          ,"tr");
		langToSymbol.put(Integer.valueOf(UKRAINIAN)        ,"uk");
		langToSymbol.put(Integer.valueOf(URDU)             ,"ur");
		langToSymbol.put(Integer.valueOf(VIETNAMESE)       ,"vi");
		langToSymbol.put(Integer.valueOf(WELSH)            ,"cy");
		langToSymbol.put(Integer.valueOf(YIDDISH)          ,"yi");	
        langToSymbol.put(Integer.valueOf(MONGOLIAN)        ,"mn");
	}

	static HashMap<Integer, String> langToStrLocale = new HashMap<Integer, String>();
	static
	{
		//http://stackoverflow.com/questions/7973023/what-is-the-list-of-supported-languages-locales-on-android
		//https://github.com/championswimmer/android-locales

		langToStrLocale.put(Integer.valueOf(AFRIKAANS)			, "af_NA");
		langToStrLocale.put(Integer.valueOf(ALBANIAN)			, "sq_AL");
		langToStrLocale.put(Integer.valueOf(ARABIC)				, "ar_IL");
		langToStrLocale.put(Integer.valueOf(ARMENIAN)			, "hy_AM");
		langToStrLocale.put(Integer.valueOf(AZERBAIJANI)		, "az_AZ");
		langToStrLocale.put(Integer.valueOf(BASQUE)				, "eu_ES");
		langToStrLocale.put(Integer.valueOf(BELARUSIAN)			, "be_BY");
		langToStrLocale.put(Integer.valueOf(BULGARIAN)			, "bg_BG");
		langToStrLocale.put(Integer.valueOf(CATALAN)			, "ca_ES");
		langToStrLocale.put(Integer.valueOf(CHINESE)			, "zh_CN");
		langToStrLocale.put(Integer.valueOf(CROATIAN)			, "hr_HR");
		langToStrLocale.put(Integer.valueOf(CZECH)				, "cs_CZ");
		langToStrLocale.put(Integer.valueOf(DANISH)				, "da_DK");
		langToStrLocale.put(Integer.valueOf(DUTCH)				, "nl_NL");
		langToStrLocale.put(Integer.valueOf(ENGLISH)			, "en_US");
		langToStrLocale.put(Integer.valueOf(ESTONIAN)			, "et_EE");
		langToStrLocale.put(Integer.valueOf(FILIPINO)			, "fil_PH");
		langToStrLocale.put(Integer.valueOf(FINNISH)			, "fi_FI");
		langToStrLocale.put(Integer.valueOf(FRENCH)				, "fr_FR");
		langToStrLocale.put(Integer.valueOf(GALICIAN)			, "gl_ES");
		langToStrLocale.put(Integer.valueOf(GEORGIAN)			, "ka_GE");
		langToStrLocale.put(Integer.valueOf(GERMAN)				, "de_DE");
		langToStrLocale.put(Integer.valueOf(GREEK)				, "el_GR");
		langToStrLocale.put(Integer.valueOf(HAITIAN_CREOLE)		, null);
		langToStrLocale.put(Integer.valueOf(HEBREW)				, "iw_IL");
		langToStrLocale.put(Integer.valueOf(HINDI)				, "hi_IN");
		langToStrLocale.put(Integer.valueOf(HUNGARIAN)			, "hu_HU");
		langToStrLocale.put(Integer.valueOf(ICELANDIC)			, "is_IS");
		langToStrLocale.put(Integer.valueOf(INDONESIAN)			, "in_ID");
		langToStrLocale.put(Integer.valueOf(IRISH)				, "ga_IE");
		langToStrLocale.put(Integer.valueOf(ITALIAN)			, "it_IT");
		langToStrLocale.put(Integer.valueOf(JAPANESE)			, "ja_JP");
		langToStrLocale.put(Integer.valueOf(KOREAN)				, "ko_KR");
		langToStrLocale.put(Integer.valueOf(LATIN)				, null);
		langToStrLocale.put(Integer.valueOf(LATVIAN)			, "lv_LV");
		langToStrLocale.put(Integer.valueOf(LITHUANIAN)			, "lt_LT");
		langToStrLocale.put(Integer.valueOf(MACEDONIAN)			, "mk_MK");
		langToStrLocale.put(Integer.valueOf(MALAY)				, "ms_MY");
		langToStrLocale.put(Integer.valueOf(MALTESE)			, "mt_MT");
		langToStrLocale.put(Integer.valueOf(NORWEGIAN)			, "nb_NO");
		langToStrLocale.put(Integer.valueOf(PERSIAN)			, "fa_IR");
		langToStrLocale.put(Integer.valueOf(POLISH)				, "pl_PL");
		langToStrLocale.put(Integer.valueOf(PORTUGUESE)			, "pt_PT");
		langToStrLocale.put(Integer.valueOf(ROMANIAN)			, "ro_RO");
		langToStrLocale.put(Integer.valueOf(RUSSIAN)			, "ru_RU");
		langToStrLocale.put(Integer.valueOf(SERBIAN)			, "sr_RS");
		langToStrLocale.put(Integer.valueOf(SLOVAK)				, "sk_SK");
		langToStrLocale.put(Integer.valueOf(SLOVENIAN)			, "sl_SI");
		langToStrLocale.put(Integer.valueOf(SPANISH)			, "es_ES");
		langToStrLocale.put(Integer.valueOf(SWAHILI)			, "sw_CD");
		langToStrLocale.put(Integer.valueOf(SWEDISH)			, "sv_SE");
		langToStrLocale.put(Integer.valueOf(THAI)				, "th_TH");
		langToStrLocale.put(Integer.valueOf(TURKISH)			, "tr_TR");
		langToStrLocale.put(Integer.valueOf(UKRAINIAN)			, "uk_UA");
		langToStrLocale.put(Integer.valueOf(URDU)				, "ur_IN");
		langToStrLocale.put(Integer.valueOf(VIETNAMESE)			, "vi_VN");
		langToStrLocale.put(Integer.valueOf(WELSH)				, "cy_GB");
		langToStrLocale.put(Integer.valueOf(YIDDISH)			, "ji_001");
		langToStrLocale.put(Integer.valueOf(MONGOLIAN)			, "mn_MN");
	}
	
	static HashMap<Integer, Locale> index2Locale = new HashMap<Integer, Locale>();
	static 
	{
		index2Locale.put(Integer.valueOf(AFRIKAANS)				, new Locale("af", "NA"));
		index2Locale.put(Integer.valueOf(ALBANIAN)				, new Locale("sq" ,"AL"));
		index2Locale.put(Integer.valueOf(ARABIC)				, new Locale("ar", "IL"));
		index2Locale.put(Integer.valueOf(ARMENIAN)				, new Locale("hy", "AM"));
		index2Locale.put(Integer.valueOf(AZERBAIJANI)			, new Locale("az", "AZ"));
		index2Locale.put(Integer.valueOf(BASQUE)				, new Locale("eu", "ES"));
		index2Locale.put(Integer.valueOf(BELARUSIAN)			, new Locale("be", "BY"));
		index2Locale.put(Integer.valueOf(BULGARIAN)				, new Locale("bg", "BG"));
		index2Locale.put(Integer.valueOf(CATALAN)				, new Locale("ca", "ES"));
		index2Locale.put(Integer.valueOf(CHINESE)				, new Locale("zh", "CN"));
		index2Locale.put(Integer.valueOf(CROATIAN)				, new Locale("hr", "HR"));
		index2Locale.put(Integer.valueOf(CZECH)					, new Locale("cs", "CZ"));
		index2Locale.put(Integer.valueOf(DANISH)				, new Locale("da", "DK"));
		index2Locale.put(Integer.valueOf(DUTCH)					, new Locale("nl", "NL"));
		index2Locale.put(Integer.valueOf(ENGLISH)				, new Locale("en", "US"));
		index2Locale.put(Integer.valueOf(ESTONIAN)				, new Locale("et", "EE"));
		index2Locale.put(Integer.valueOf(FILIPINO)				, new Locale("fil", "PH"));
		index2Locale.put(Integer.valueOf(FINNISH)				, new Locale("fi", "FI"));
		index2Locale.put(Integer.valueOf(FRENCH)				, new Locale("fr", "FR"));
		index2Locale.put(Integer.valueOf(GALICIAN)				, new Locale("gl", "ES"));
		index2Locale.put(Integer.valueOf(GEORGIAN)				, new Locale("ka", "GE"));
		index2Locale.put(Integer.valueOf(GERMAN)				, new Locale("de", "DE"));
		index2Locale.put(Integer.valueOf(GREEK)					, new Locale("el", "GR"));
		index2Locale.put(Integer.valueOf(HAITIAN_CREOLE)		, null);
		index2Locale.put(Integer.valueOf(HEBREW)				, new Locale("iw", "IL"));
		index2Locale.put(Integer.valueOf(HINDI)					, new Locale("hi", "IN"));
		index2Locale.put(Integer.valueOf(HUNGARIAN)				, new Locale("hu", "HU"));
		index2Locale.put(Integer.valueOf(ICELANDIC)				, new Locale("is", "IS"));
		index2Locale.put(Integer.valueOf(INDONESIAN)			, new Locale("in", "ID"));
		index2Locale.put(Integer.valueOf(IRISH)					, new Locale("ga", "IE"));
		index2Locale.put(Integer.valueOf(ITALIAN)				, new Locale("it", "IT"));
		index2Locale.put(Integer.valueOf(JAPANESE)				, new Locale("ja", "JP"));
		index2Locale.put(Integer.valueOf(KOREAN)				, new Locale("ko", "KR"));
		index2Locale.put(Integer.valueOf(LATIN)					, null);
		index2Locale.put(Integer.valueOf(LATVIAN)				, new Locale("lv", "LV"));
		index2Locale.put(Integer.valueOf(LITHUANIAN)			, new Locale("lt", "LT"));
		index2Locale.put(Integer.valueOf(MACEDONIAN)			, new Locale("mk", "MK"));
		index2Locale.put(Integer.valueOf(MALAY)					, new Locale("ms", "MY"));
		index2Locale.put(Integer.valueOf(MALTESE)				, new Locale("mt", "MT"));
		index2Locale.put(Integer.valueOf(NORWEGIAN)				, new Locale("nb", "NO"));
		index2Locale.put(Integer.valueOf(PERSIAN)				, new Locale("fa", "IR"));
		index2Locale.put(Integer.valueOf(POLISH)				, new Locale("pl", "PL"));
		index2Locale.put(Integer.valueOf(PORTUGUESE)			, new Locale("pt", "PT"));
		index2Locale.put(Integer.valueOf(ROMANIAN)				, new Locale("ro", "RO"));
		index2Locale.put(Integer.valueOf(RUSSIAN)				, new Locale("ru", "RU"));
		index2Locale.put(Integer.valueOf(SERBIAN)				, new Locale("sr", "RS"));
		index2Locale.put(Integer.valueOf(SLOVAK)				, new Locale("sk", "SK"));
		index2Locale.put(Integer.valueOf(SLOVENIAN)				, new Locale("sl", "SI"));
		index2Locale.put(Integer.valueOf(SPANISH)				, new Locale("es", "ES"));
		index2Locale.put(Integer.valueOf(SWAHILI)				, new Locale("sw", "CD"));
		index2Locale.put(Integer.valueOf(SWEDISH)				, new Locale("sv", "SE"));
		index2Locale.put(Integer.valueOf(THAI)					, new Locale("th", "TH"));
		index2Locale.put(Integer.valueOf(TURKISH)				, new Locale("tr", "TR"));
		index2Locale.put(Integer.valueOf(UKRAINIAN)				, new Locale("uk", "UA"));
		index2Locale.put(Integer.valueOf(URDU)					, new Locale("ur", "IN"));
		index2Locale.put(Integer.valueOf(VIETNAMESE)			, new Locale("vi", "VN"));
		index2Locale.put(Integer.valueOf(WELSH)					, new Locale("cy", "GB"));
		index2Locale.put(Integer.valueOf(YIDDISH)				, new Locale("ji", "001"));
		index2Locale.put(Integer.valueOf(MONGOLIAN)				, new Locale("mn", "MN"));
	}

	static HashMap<String, String> mSymbolToName = new HashMap<String, String>();
	static
	{
		mSymbolToName.put("af", 	"Afrikaans");
		mSymbolToName.put("sq", 	"Albanian");
		mSymbolToName.put("ar",		"Arabic");
		mSymbolToName.put("hy",		"Armenian");
		mSymbolToName.put("az",		"Azerbaijani");
		mSymbolToName.put("eu",		"Basque");
		mSymbolToName.put("be",		"Belarusian");
		mSymbolToName.put("bg",		"Bulgarian");
		mSymbolToName.put("ca",		"Catalan");
		mSymbolToName.put("zh-CN",	"Chinese");
		mSymbolToName.put("hr",		"Croatian");
		mSymbolToName.put("cs",		"Czech");
		mSymbolToName.put("da",		"Danish");
		mSymbolToName.put("nl",		"Dutch");
		mSymbolToName.put("en",		"English");
		mSymbolToName.put("et", 	"Estonian");
		mSymbolToName.put("tl",		"Filipino");
		mSymbolToName.put("fi",		"Finnish");
		mSymbolToName.put("fr",		"French");
		mSymbolToName.put("gl",		"Galician");
		mSymbolToName.put("ka",		"Georgian");
		mSymbolToName.put("de",		"German");
		mSymbolToName.put("el",		"Greek");
		//mSymbolToName.put("ht",	"Haitian_creole");
		mSymbolToName.put("iw",		"Hebrew");
		mSymbolToName.put("hi",		"Hindi");
		mSymbolToName.put("hu",		"Hungarian");
		mSymbolToName.put("is",		"Icelandic");
		mSymbolToName.put("id",		"Indonesian");
		mSymbolToName.put("ga",		"Irish");
		mSymbolToName.put("it",		"Italian");
		mSymbolToName.put("ja",		"Japanese");
		mSymbolToName.put("ko",		"Korean");
		mSymbolToName.put("la", 	"Latin");
		mSymbolToName.put("lv",		"Latvian");
		mSymbolToName.put("lt",		"Lithuanian");
		mSymbolToName.put("mk",		"Macedonian");
		mSymbolToName.put("ms",		"Malay");
		mSymbolToName.put("mt",		"Maltese");
		mSymbolToName.put("mn",		"Mongolian");
		mSymbolToName.put("no",		"Norwegian");
		mSymbolToName.put("fa",		"Persian");
		mSymbolToName.put("pl",		"Polish");
		mSymbolToName.put("pt",		"Portuguese");
		mSymbolToName.put("ro",		"Romanian");
		mSymbolToName.put("ru",		"Russian");
		mSymbolToName.put("sr",		"Serbian");
		mSymbolToName.put("sk",		"Slovak");
		mSymbolToName.put("sl",		"Slovenian");
		mSymbolToName.put("es",		"Spanish");
		mSymbolToName.put("sw",		"Swahili");
		mSymbolToName.put("sv",		"Swedish");
		mSymbolToName.put("th",		"Thai");
		mSymbolToName.put("tr",		"Turkish");
		mSymbolToName.put("uk",		"Ukrainian");
		mSymbolToName.put("ur",		"Urdu");
		mSymbolToName.put("vi",		"Vietnamese");
		mSymbolToName.put("cy",		"Welsh");
		mSymbolToName.put("yi",		"Yiddish");

	}

	public static String getSymbol(int sourceLang)
	{
		return langToSymbol.get(Integer.valueOf(sourceLang));
	}

	public static String getLanguage(String symbol)
	{
		return mSymbolToName.get(symbol);
	}
	
	public static String getStringLocale(int sourceLang)
	{
		return langToStrLocale.get(Integer.valueOf(sourceLang));
	}

	public static String getLocale(String symbol)
	{
		return mSymbolToName.get(symbol);
	}
}
