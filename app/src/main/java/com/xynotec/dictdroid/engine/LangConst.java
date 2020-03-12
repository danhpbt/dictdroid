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
	
	public static HashMap<Integer, String> langToLocale = new HashMap<Integer, String>();
	static
	{
		langToLocale.put(Integer.valueOf(AFRIKAANS)        ,"af");
		langToLocale.put(Integer.valueOf(ALBANIAN)         ,"sq");
		langToLocale.put(Integer.valueOf(ARABIC)           ,"ar");
		langToLocale.put(Integer.valueOf(ARMENIAN)         ,"hy");
		langToLocale.put(Integer.valueOf(AZERBAIJANI)      ,"az");
		langToLocale.put(Integer.valueOf(BASQUE)           ,"eu");
		langToLocale.put(Integer.valueOf(BELARUSIAN)       ,"be");
		langToLocale.put(Integer.valueOf(BULGARIAN)        ,"bg");
		langToLocale.put(Integer.valueOf(CATALAN)          ,"ca");
		langToLocale.put(Integer.valueOf(CHINESE)          ,"zh-CN");
		langToLocale.put(Integer.valueOf(CROATIAN)         ,"hr");
		langToLocale.put(Integer.valueOf(CZECH)            ,"cs");
		langToLocale.put(Integer.valueOf(DANISH)           ,"da");
		langToLocale.put(Integer.valueOf(DUTCH)            ,"nl");
		langToLocale.put(Integer.valueOf(ENGLISH)          ,"en");
		langToLocale.put(Integer.valueOf(ESTONIAN)         ,"et");
		langToLocale.put(Integer.valueOf(FILIPINO)         ,"tl");
		langToLocale.put(Integer.valueOf(FINNISH)          ,"fi");
		langToLocale.put(Integer.valueOf(FRENCH)           ,"fr");
		langToLocale.put(Integer.valueOf(GALICIAN)         ,"gl");
		langToLocale.put(Integer.valueOf(GEORGIAN)         ,"ka");
		langToLocale.put(Integer.valueOf(GERMAN)           ,"de");
		langToLocale.put(Integer.valueOf(GREEK)            ,"el");
		langToLocale.put(Integer.valueOf(HAITIAN_CREOLE)   , "ht");
		langToLocale.put(Integer.valueOf(HEBREW)           ,"iw");
		langToLocale.put(Integer.valueOf(HINDI)            ,"hi");
		langToLocale.put(Integer.valueOf(HUNGARIAN)        ,"hu");
		langToLocale.put(Integer.valueOf(ICELANDIC)        ,"is");
		langToLocale.put(Integer.valueOf(INDONESIAN)       ,"id");
		langToLocale.put(Integer.valueOf(IRISH)            ,"ga");
		langToLocale.put(Integer.valueOf(ITALIAN)          ,"it");
		langToLocale.put(Integer.valueOf(JAPANESE)         ,"ja");
		langToLocale.put(Integer.valueOf(KOREAN)           ,"ko");
		langToLocale.put(Integer.valueOf(LATIN)            ,"la");
		langToLocale.put(Integer.valueOf(LATVIAN)          ,"lv");
		langToLocale.put(Integer.valueOf(LITHUANIAN)       ,"lt");
		langToLocale.put(Integer.valueOf(MACEDONIAN)       ,"mk");
		langToLocale.put(Integer.valueOf(MALAY)            ,"ms");
		langToLocale.put(Integer.valueOf(MALTESE)          ,"mt");
		langToLocale.put(Integer.valueOf(NORWEGIAN)        ,"no");
		langToLocale.put(Integer.valueOf(PERSIAN)          ,"fa");
		langToLocale.put(Integer.valueOf(POLISH)           ,"pl");
		langToLocale.put(Integer.valueOf(PORTUGUESE)       ,"pt");
		langToLocale.put(Integer.valueOf(ROMANIAN)         ,"ro");
		langToLocale.put(Integer.valueOf(RUSSIAN)          ,"ru");
		langToLocale.put(Integer.valueOf(SERBIAN)          ,"sr");
		langToLocale.put(Integer.valueOf(SLOVAK)           ,"sk");
		langToLocale.put(Integer.valueOf(SLOVENIAN)        ,"sl");
		langToLocale.put(Integer.valueOf(SPANISH)          ,"es");
		langToLocale.put(Integer.valueOf(SWAHILI)          ,"sw");
		langToLocale.put(Integer.valueOf(SWEDISH)          ,"sv");
		langToLocale.put(Integer.valueOf(THAI)             ,"th");
		langToLocale.put(Integer.valueOf(TURKISH)          ,"tr");
		langToLocale.put(Integer.valueOf(UKRAINIAN)        ,"uk");
		langToLocale.put(Integer.valueOf(URDU)             ,"ur");
		langToLocale.put(Integer.valueOf(VIETNAMESE)       ,"vi");
		langToLocale.put(Integer.valueOf(WELSH)            ,"cy");
		langToLocale.put(Integer.valueOf(YIDDISH)          ,"yi");	
        langToLocale.put(Integer.valueOf(MONGOLIAN)        ,"mn");
	}

	public static HashMap<Integer, String> index2STTLocale = new HashMap<Integer, String>();
	static
	{
		//http://stackoverflow.com/questions/7973023/what-is-the-list-of-supported-languages-locales-on-android
		//https://github.com/championswimmer/android-locales

		index2STTLocale.put(Integer.valueOf(LangConst.AFRIKAANS)		, "af_NA");
		index2STTLocale.put(Integer.valueOf(LangConst.ALBANIAN)			, "sq_AL");
		index2STTLocale.put(Integer.valueOf(LangConst.ARABIC)			, "ar_IL");
		index2STTLocale.put(Integer.valueOf(LangConst.ARMENIAN)			, "hy_AM");
		index2STTLocale.put(Integer.valueOf(LangConst.AZERBAIJANI)		, "az_AZ");
		index2STTLocale.put(Integer.valueOf(LangConst.BASQUE)			, "eu_ES");
		index2STTLocale.put(Integer.valueOf(LangConst.BELARUSIAN)		, "be_BY");
		index2STTLocale.put(Integer.valueOf(LangConst.BULGARIAN)		, "bg_BG");
		index2STTLocale.put(Integer.valueOf(LangConst.CATALAN)			, "ca_ES");
		index2STTLocale.put(Integer.valueOf(LangConst.CHINESE)			, "zh_CN");
		index2STTLocale.put(Integer.valueOf(LangConst.CROATIAN)			, "hr_HR");
		index2STTLocale.put(Integer.valueOf(LangConst.CZECH)			, "cs_CZ");
		index2STTLocale.put(Integer.valueOf(LangConst.DANISH)			, "da_DK");
		index2STTLocale.put(Integer.valueOf(LangConst.DUTCH)			, "nl_NL");
		index2STTLocale.put(Integer.valueOf(LangConst.ENGLISH)			, "en_US");			
		index2STTLocale.put(Integer.valueOf(LangConst.ESTONIAN)			, "et_EE");
		index2STTLocale.put(Integer.valueOf(LangConst.FILIPINO)			, "fil_PH");
		index2STTLocale.put(Integer.valueOf(LangConst.FINNISH)			, "fi_FI");
		index2STTLocale.put(Integer.valueOf(LangConst.FRENCH)			, "fr_FR");	
		index2STTLocale.put(Integer.valueOf(LangConst.GALICIAN)			, "gl_ES");
		index2STTLocale.put(Integer.valueOf(LangConst.GEORGIAN)			, "ka_GE");
		index2STTLocale.put(Integer.valueOf(LangConst.GERMAN)			, "de_DE");			
		index2STTLocale.put(Integer.valueOf(LangConst.GREEK)			, "el_GR");
		index2STTLocale.put(Integer.valueOf(LangConst.HAITIAN_CREOLE)	, null);
		index2STTLocale.put(Integer.valueOf(LangConst.HEBREW)			, "iw_IL");
		index2STTLocale.put(Integer.valueOf(LangConst.HINDI)			, "hi_IN");
		index2STTLocale.put(Integer.valueOf(LangConst.HUNGARIAN)		, "hu_HU");
		index2STTLocale.put(Integer.valueOf(LangConst.ICELANDIC)		, "is_IS");
		index2STTLocale.put(Integer.valueOf(LangConst.INDONESIAN)		, "in_ID");
		index2STTLocale.put(Integer.valueOf(LangConst.IRISH)			, "ga_IE");
		index2STTLocale.put(Integer.valueOf(LangConst.ITALIAN)			, "it_IT");
		index2STTLocale.put(Integer.valueOf(LangConst.JAPANESE)			, "ja_JP");
		index2STTLocale.put(Integer.valueOf(LangConst.KOREAN)			, "ko_KR");
		index2STTLocale.put(Integer.valueOf(LangConst.LATIN)			, null);
		index2STTLocale.put(Integer.valueOf(LangConst.LATVIAN)			, "lv_LV");
		index2STTLocale.put(Integer.valueOf(LangConst.LITHUANIAN)		, "lt_LT");
		index2STTLocale.put(Integer.valueOf(LangConst.MACEDONIAN)		, "mk_MK");
		index2STTLocale.put(Integer.valueOf(LangConst.MALAY)			, "ms_MY");
		index2STTLocale.put(Integer.valueOf(LangConst.MALTESE)			, "mt_MT");
		index2STTLocale.put(Integer.valueOf(LangConst.NORWEGIAN)		, "nb_NO");
		index2STTLocale.put(Integer.valueOf(LangConst.PERSIAN)			, "fa_IR");
		index2STTLocale.put(Integer.valueOf(LangConst.POLISH)			, "pl_PL");
		index2STTLocale.put(Integer.valueOf(LangConst.PORTUGUESE)		, "pt_PT");
		index2STTLocale.put(Integer.valueOf(LangConst.ROMANIAN)			, "ro_RO");
		index2STTLocale.put(Integer.valueOf(LangConst.RUSSIAN)			, "ru_RU");
		index2STTLocale.put(Integer.valueOf(LangConst.SERBIAN)			, "sr_RS");
		index2STTLocale.put(Integer.valueOf(LangConst.SLOVAK)			, "sk_SK");
		index2STTLocale.put(Integer.valueOf(LangConst.SLOVENIAN)		, "sl_SI");
		index2STTLocale.put(Integer.valueOf(LangConst.SPANISH)			, "es_ES");
		index2STTLocale.put(Integer.valueOf(LangConst.SWAHILI)			, "sw_CD");
		index2STTLocale.put(Integer.valueOf(LangConst.SWEDISH)			, "sv_SE");			
		index2STTLocale.put(Integer.valueOf(LangConst.THAI)				, "th_TH");
		index2STTLocale.put(Integer.valueOf(LangConst.TURKISH)			, "tr_TR");
		index2STTLocale.put(Integer.valueOf(LangConst.UKRAINIAN)		, "uk_UA");
		index2STTLocale.put(Integer.valueOf(LangConst.URDU)				, "ur_IN");
		index2STTLocale.put(Integer.valueOf(LangConst.VIETNAMESE)		, "vi_VN");
		index2STTLocale.put(Integer.valueOf(LangConst.WELSH)			, "cy_GB");
		index2STTLocale.put(Integer.valueOf(LangConst.YIDDISH)			, "ji_001");
		index2STTLocale.put(Integer.valueOf(LangConst.MONGOLIAN)		, "mn_MN");
	}

	public static HashMap<Integer, Locale> index2TTSLocale = new HashMap<Integer, Locale>();
	static 
	{
		index2TTSLocale.put(Integer.valueOf(LangConst.AFRIKAANS)			, new Locale("af", "NA"));
		index2TTSLocale.put(Integer.valueOf(LangConst.ALBANIAN)				, new Locale("sq" ,"AL"));
		index2TTSLocale.put(Integer.valueOf(LangConst.ARABIC)				, new Locale("ar", "IL"));
		index2TTSLocale.put(Integer.valueOf(LangConst.ARMENIAN)				, new Locale("hy", "AM"));
		index2TTSLocale.put(Integer.valueOf(LangConst.AZERBAIJANI)			, new Locale("az", "AZ"));
		index2TTSLocale.put(Integer.valueOf(LangConst.BASQUE)				, new Locale("eu", "ES"));
		index2TTSLocale.put(Integer.valueOf(LangConst.BELARUSIAN)			, new Locale("be", "BY"));
		index2TTSLocale.put(Integer.valueOf(LangConst.BULGARIAN)			, new Locale("bg", "BG"));
		index2TTSLocale.put(Integer.valueOf(LangConst.CATALAN)				, new Locale("ca", "ES"));
		index2TTSLocale.put(Integer.valueOf(LangConst.CHINESE)				, new Locale("zh", "CN"));
		index2TTSLocale.put(Integer.valueOf(LangConst.CROATIAN)				, new Locale("hr", "HR"));
		index2TTSLocale.put(Integer.valueOf(LangConst.CZECH)				, new Locale("cs", "CZ"));
		index2TTSLocale.put(Integer.valueOf(LangConst.DANISH)				, new Locale("da", "DK"));
		index2TTSLocale.put(Integer.valueOf(LangConst.DUTCH)				, new Locale("nl", "NL"));
		index2TTSLocale.put(Integer.valueOf(LangConst.ENGLISH)				, new Locale("en", "US"));
		index2TTSLocale.put(Integer.valueOf(LangConst.ESTONIAN)				, new Locale("et", "EE"));
		index2TTSLocale.put(Integer.valueOf(LangConst.FILIPINO)				, new Locale("fil", "PH"));
		index2TTSLocale.put(Integer.valueOf(LangConst.FINNISH)				, new Locale("fi", "FI"));
		index2TTSLocale.put(Integer.valueOf(LangConst.FRENCH)				, new Locale("fr", "FR"));
		index2TTSLocale.put(Integer.valueOf(LangConst.GALICIAN)				, new Locale("gl", "ES"));
		index2TTSLocale.put(Integer.valueOf(LangConst.GEORGIAN)				, new Locale("ka", "GE"));
		index2TTSLocale.put(Integer.valueOf(LangConst.GERMAN)				, new Locale("de", "DE"));
		index2TTSLocale.put(Integer.valueOf(LangConst.GREEK)				, new Locale("el", "GR"));
		index2TTSLocale.put(Integer.valueOf(LangConst.HAITIAN_CREOLE)		, null);
		index2TTSLocale.put(Integer.valueOf(LangConst.HEBREW)				, new Locale("iw", "IL"));
		index2TTSLocale.put(Integer.valueOf(LangConst.HINDI)				, new Locale("hi", "IN"));
		index2TTSLocale.put(Integer.valueOf(LangConst.HUNGARIAN)			, new Locale("hu", "HU"));
		index2TTSLocale.put(Integer.valueOf(LangConst.ICELANDIC)			, new Locale("is", "IS"));
		index2TTSLocale.put(Integer.valueOf(LangConst.INDONESIAN)			, new Locale("in", "ID"));
		index2TTSLocale.put(Integer.valueOf(LangConst.IRISH)				, new Locale("ga", "IE"));
		index2TTSLocale.put(Integer.valueOf(LangConst.ITALIAN)				, new Locale("it", "IT"));
		index2TTSLocale.put(Integer.valueOf(LangConst.JAPANESE)				, new Locale("ja", "JP"));
		index2TTSLocale.put(Integer.valueOf(LangConst.KOREAN)				, new Locale("ko", "KR"));
		index2TTSLocale.put(Integer.valueOf(LangConst.LATIN)				, null);
		index2TTSLocale.put(Integer.valueOf(LangConst.LATVIAN)				, new Locale("lv", "LV"));
		index2TTSLocale.put(Integer.valueOf(LangConst.LITHUANIAN)			, new Locale("lt", "LT"));
		index2TTSLocale.put(Integer.valueOf(LangConst.MACEDONIAN)			, new Locale("mk", "MK"));
		index2TTSLocale.put(Integer.valueOf(LangConst.MALAY)				, new Locale("ms", "MY"));
		index2TTSLocale.put(Integer.valueOf(LangConst.MALTESE)				, new Locale("mt", "MT"));
		index2TTSLocale.put(Integer.valueOf(LangConst.NORWEGIAN)			, new Locale("nb", "NO"));
		index2TTSLocale.put(Integer.valueOf(LangConst.PERSIAN)				, new Locale("fa", "IR"));
		index2TTSLocale.put(Integer.valueOf(LangConst.POLISH)				, new Locale("pl", "PL"));
		index2TTSLocale.put(Integer.valueOf(LangConst.PORTUGUESE)			, new Locale("pt", "PT"));
		index2TTSLocale.put(Integer.valueOf(LangConst.ROMANIAN)				, new Locale("ro", "RO"));
		index2TTSLocale.put(Integer.valueOf(LangConst.RUSSIAN)				, new Locale("ru", "RU"));
		index2TTSLocale.put(Integer.valueOf(LangConst.SERBIAN)				, new Locale("sr", "RS"));
		index2TTSLocale.put(Integer.valueOf(LangConst.SLOVAK)				, new Locale("sk", "SK"));
		index2TTSLocale.put(Integer.valueOf(LangConst.SLOVENIAN)			, new Locale("sl", "SI"));
		index2TTSLocale.put(Integer.valueOf(LangConst.SPANISH)				, new Locale("es", "ES"));
		index2TTSLocale.put(Integer.valueOf(LangConst.SWAHILI)				, new Locale("sw", "CD"));
		index2TTSLocale.put(Integer.valueOf(LangConst.SWEDISH)				, new Locale("sv", "SE"));
		index2TTSLocale.put(Integer.valueOf(LangConst.THAI)					, new Locale("th", "TH"));
		index2TTSLocale.put(Integer.valueOf(LangConst.TURKISH)				, new Locale("tr", "TR"));
		index2TTSLocale.put(Integer.valueOf(LangConst.UKRAINIAN)			, new Locale("uk", "UA"));
		index2TTSLocale.put(Integer.valueOf(LangConst.URDU)					, new Locale("ur", "IN"));
		index2TTSLocale.put(Integer.valueOf(LangConst.VIETNAMESE)			, new Locale("vi", "VN"));
		index2TTSLocale.put(Integer.valueOf(LangConst.WELSH)				, new Locale("cy", "GB"));
		index2TTSLocale.put(Integer.valueOf(LangConst.YIDDISH)				, new Locale("ji", "001"));
		index2TTSLocale.put(Integer.valueOf(LangConst.MONGOLIAN)			, new Locale("mn", "MN"));
	}
	
}