package com.xynotec.dictdroid.utils;

import android.content.Context;

import com.xynotec.dictdroid.data.GlobalData;

public class HtmlConverter
{
	final static int LINGOES = 0;
	final static int LINGVOSOFT = 1;
	
	final static String META_VIEW_PORT = "<meta name=\"viewport\" content=\"width=device-width, initial-scale=%f, minimum-scale=0.5, maximum-scale=2.0\">";

//	final static String HTML_HEADER = "<html>" + 
//							   "<head>";
	final static String LINGOES_HTML = 	"<html xmlns=\"http://www.w3.org/1999/xhtml\">" + 
									   	//"\n" + 
										"<head>" +
										//"\n" +
										"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />" +
										//"\n" +
										"<title>OM Dictionary</title>" +
										//"\n" +
										"<style type=\"text/css\">" +
										//"\n" +										
										"body {" +
										"	margin-left: 2px;" +
										"	margin-top: 2px;" +
										"	margin-right: 2px;" +
										"	margin-bottom: 2px;" +
										"   BACKGROUND-COLOR: " + GlobalData.colorBackground+
										"}" +									
										"ul {" +
										"padding-left: 16px;" +
										"}" +									
										"li {" +
										"list-style-position: outside;" +
										//"font-family: Verdana, Arial, Helvetica, sans-serif;" +
										"font-size: 12px;" +
										"color: #000000;" +
										"padding-left: 2px;" +
										"line-height: 18px;" +
										"}" +									
										"</style>" +
										//"\n" +
										"</head>" +
										//"\n" +	
										"<body>";
										//"<body>" +
										//"\n";
	
	final static String LINGVOSOFT_HTML = 	"<html>" + 
											"<head>" +
											"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\">" +
											"<title>New Page 1</title>" +
											"<STYLE id=trstyle>BODY {" +
											//"	FONT-SIZE: 18px; OVERFLOW: auto; BACKGROUND-COLOR: #ffffff" +
											"	FONT-SIZE: 18px; OVERFLOW: auto; BACKGROUND-COLOR: " +  GlobalData.colorBackground +
											"}" +
											".outerbox {" +
											"	FONT-SIZE: 16px; CURSOR: default; FONT-FAMILY: Tahoma" +
											"}" +
											".mainsection {" +
											"	DISPLAY: none; FONT-SIZE: 85%; COLOR: #808080" +
											"}" +
											".mainsectiontable {" +
											"	MARGIN-LEFT: 1em" +
											"}" +
											".mainsectiontabletext {" +
											"	MARGIN-TOP: 0.4em; FONT-SIZE: 85%; MARGIN-BOTTOM: 0.4em; MARGIN-LEFT: 0.7em" +
											"}" +
											".section {" +
											"	MARGIN-LEFT: 2em" +
											"}" +
											".dictblock {" +
											"	CLEAR: both; MARGIN-TOP: 0.7em; MARGIN-BOTTOM: 1em" +
											"}" +
											".dictname {" +
											"	DISPLAY: block; FONT-SIZE: 75%; CURSOR: text; COLOR: #808080; FONT-FAMILY: monospace" +
											"}" +
											".srcword {" +
											"	DISPLAY: inline; FONT-WEIGHT: bolder; FLOAT: left; CURSOR: text" +
											"}" +
											".rtlsrcword {" +
											"	DISPLAY: inline; FONT-WEIGHT: bolder; FLOAT: right; CURSOR: text; MARGIN-RIGHT: 0.5em" +
											"}" +
											".transword {" +
											"	DISPLAY: inline; MARGIN-LEFT: 1em; CURSOR: text" +
											"}" +
											".rtltransword {" +
											"	DISPLAY: inline; FLOAT: right; CURSOR: text; MARGIN-RIGHT: 1em" +
											"}" +
											".transcription {" +
											"	DISPLAY: block; FLOAT: left; MARGIN-LEFT: 0.5em; CURSOR: text; COLOR: #00309c; FONT-FAMILY: Lucida Sans Unicode" +
											"}" +
											".sex {" +
											"	CURSOR: text; COLOR: #cc3333; FONT-STYLE: italic" +
											"}" +
											".pofs {" +
											"	DISPLAY: inline; CURSOR: text; COLOR: #10a208" +
											"}" +
											".comment {" +
											"	MARGIN-TOP: 10px; FONT-SIZE: 80%; CURSOR: text; COLOR: #004080; FONT-STYLE: italic" +
											"}" +
											".noreg {" +
											"	COLOR: red" +
											"}" +
											".pp_pp {" +
											"	DISPLAY: inline; MARGIN-LEFT: 1em; CURSOR: hand; COLOR: #002c94; FONT-STYLE: italic" +
											"}" +
											".phrase_sample {" +
											"	DISPLAY: none; FONT-SIZE: 85%; MARGIN-LEFT: 1em; COLOR: #002c94" +
											"}" +
											".rtlpp_pp {" +
											"	DISPLAY: inline; FLOAT: right; CURSOR: hand; COLOR: #002c94; MARGIN-RIGHT: 1em; FONT-STYLE: italic" +
											"}" +
											".rtlphrase_sample {" +
											"	DISPLAY: inline; FLOAT: right; CURSOR: hand; COLOR: #002c94; MARGIN-RIGHT: 1em; FONT-STYLE: italic" +
											"}" +
											"</STYLE>" +
											"</head>" +
											"<body>";

	final static String END_HTML = 	"</body>" +
									"</html>";
	public static String String_htmlEncode(String inputStr, int dataSource)
	{
		StringBuilder enStr = new StringBuilder();
		if ((inputStr == null) || (inputStr.length() == 0))
		{
			return enStr.toString();
		}
		
		if (dataSource == LINGOES)
			enStr.append(LINGOES_HTML);
		else if (dataSource == LINGVOSOFT)
			enStr.append(LINGVOSOFT_HTML);
		else
			enStr.append(LINGOES_HTML);
			
		enStr.append(inputStr);

		enStr.append(END_HTML);
		return enStr.toString();
	}
	
	public static String update4ViewPort(String mean, float zoomScale)
	{
		StringBuilder meanBd = new StringBuilder(mean);

		String metaViewPort = String.format(META_VIEW_PORT, zoomScale);
		
		int index = meanBd.indexOf("<head>") + "<head>".length();
		
		meanBd.insert(index, metaViewPort);
		
		return meanBd.toString();
	}
	
	public static String GetEmptyWebPage(int dataSource)
	{
		StringBuilder enStr = new StringBuilder();

		if (dataSource == LINGOES)
			enStr.append(LINGOES_HTML);
		else if (dataSource == LINGVOSOFT)
			enStr.append(LINGVOSOFT_HTML);
		else
			enStr.append(LINGOES_HTML);
			
		enStr.append(END_HTML);
		return enStr.toString();
	}
	
	public static String FormatError(String errorStr)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("<DIV style=\"OVERFLOW-X: hidden; WIDTH: 100%\">\n");

        String error = String.format("<DIV style=\"MARGIN: 0px 0px 5px; COLOR: #808080; LINE-HEIGHT: normal\"><SPAN style=\"FONT-SIZE: 16px; COLOR: #FF0000; LINE-HEIGHT: normal\"><B>%s</B></SPAN> &nbsp;</DIV></DIV>\n", errorStr);
        sb.append(error);

        return sb.toString();
    }
	
	public static String FormatHint(String errorStr)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("<DIV style=\"OVERFLOW-X: hidden; WIDTH: 100%\">\n");

        String error = String.format("<DIV style=\"MARGIN: 0px 0px 5px; COLOR: #808080; LINE-HEIGHT: normal\"><SPAN style=\"FONT-SIZE: 16px; COLOR: #7F7F7F; LINE-HEIGHT: normal\"><B>%s</B></SPAN> &nbsp;</DIV></DIV>\n", errorStr);
        sb.append(error);

        return sb.toString();
    }
	
	public static String String_htmlEncodeGoogle(String inputStr)
	{
		StringBuilder enStr = new StringBuilder();
		if ((inputStr == null) || (inputStr.length() == 0))
		{
			return enStr.toString();
		}
		
		enStr.append(LINGOES_HTML);
			
		enStr.append(inputStr);

		enStr.append(END_HTML);
		return enStr.toString();
	} 

	static String GetStartTag(String style)
	{
		String strTag = "";

		if(style.equals("&"))
		{
			strTag = "<span class=\"styleheader\">";
		}
		else if(style.equals("@"))
		{
			strTag = "<span class=\"style1\">";
		}
		else if(style.equals("*"))
		{
			strTag = "<span class=\"style2\">";
		}
		else if(style.equals("-"))
		{
			strTag = "<span class=\"style3\">";
		}
		else if(style.equals("="))
		{
			strTag = "<span class=\"style4\">";
		}
		else if(style.equals("+"))
		{
			strTag = "<span class=\"style5\">";
		}
		return strTag;
	}

	static String GetEndTag(String style)
	{
		String strTag = "";

		if(style.equals("&"))
		{
			strTag = "</span>";
		}
		else if(style.equals("@"))
		{
			strTag = "</span>";
		}
		else if(style.equals("*"))
		{
			strTag = "</span>";
		}
		else if(style.equals("-"))
		{
			strTag = "</span>";
		}
		else if(style.equals("="))
		{
			strTag = "</span>";
		}
		else if(style.equals("+"))
		{
			strTag = "</span>";
		}
		return strTag;
	}
}
