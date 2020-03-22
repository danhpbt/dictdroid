package com.xynotec.dictdroid.ui.main.translate;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.xynotec.dagger.BaseViewModel;
import com.xynotec.dictdroid.data.DataManager;
import com.xynotec.dictdroid.data.GlobalData;
import com.xynotec.dictdroid.utils.HtmlConverter;

import org.json.JSONArray;

import java.net.URLEncoder;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TranslateViewModel extends BaseViewModel {

    final ObservableInt fromLang = new ObservableInt();
    final ObservableInt toLang = new ObservableInt();
    final ObservableField<String> strInput = new ObservableField<>();
    final ObservableField<String> strOutput = new ObservableField<>();

    TranslateViewModelListener mListener;

    public TranslateViewModel(DataManager dataManager) {
        super(dataManager);

        fromLang.set(getDataManager().getFromLangRecentIndex());
        toLang.set(getDataManager().getToLangRecentIndex());
    }

    public ObservableInt getFromLang()
    {
        return fromLang;
    }

    public ObservableInt getToLang() {
        return toLang;
    }

    public ObservableField<String> getStrInput() {
        return strInput;
    }

    public ObservableField<String> getStrOutput() {
        return strOutput;
    }

    public void swap()
    {
        int from = fromLang.get();
        int to = toLang.get();

        fromLang.set(Integer.valueOf(to));
        toLang.set(Integer.valueOf(from));
    }

    public void clearInput()
    {
        strInput.set("");
    }

    public void setListener(TranslateViewModelListener listener)
    {
        mListener = listener;
    }

    public void setIsLoading(boolean isLoading) {
        if (mListener != null)
            this.mListener.onShowProgressDlg(isLoading);
    }

    public void translate()
    {
        try
        {
            String url = generateUrl();

            setIsLoading(true);
            getCompositeDisposable().add(getDataManager()
                    .doTranslateApiCall(url)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(s -> {
                                setIsLoading(false);
                                //save language
                                getDataManager().setFromLangRecentIndex(fromLang.get());
                                getDataManager().setToLangRecentIndex(toLang.get());

                                String wv_content = parseTranslateText(s);
                                strOutput.set(wv_content);
                            }
                            , throwable -> {
                                setIsLoading(false);
                                String err = HtmlConverter.String_htmlEncodeGoogle(HtmlConverter.FormatError(throwable.getLocalizedMessage()));
                                strOutput.set(err);
                            }));
        }
        catch (Exception ex)
        {
            String err = HtmlConverter.String_htmlEncodeGoogle(HtmlConverter.FormatError(ex.getMessage()));
            strOutput.set(err);
        }

    }

    private String generateUrl() throws Exception
    {
        String fromSymbol = GlobalData.getSymbolLanguage(fromLang.get());
        String toSymbol = GlobalData.getSymbolLanguage(toLang.get());
        String input = strInput.get();
        String text = String.format("http://translate.googleapis.com/translate_a/single?client=gtx&sl=%s&tl=%s&dt=t&q=%s",
                fromSymbol, toSymbol, URLEncoder.encode(input, "UTF-8"));
        return text;
    }

    String parseTranslateText(String json) throws Exception
    {
        final String transFmt = "<DIV style=\"MARGIN: 0px 0px 5px; COLOR: #808080; LINE-HEIGHT: normal\"><SPAN style=\"FONT-SIZE: 28px; COLOR: #000000; LINE-HEIGHT: normal\"><B>%s</B></SPAN> &nbsp;</DIV></DIV>\n";
        final String posFmt = "<UL><LI><B><I>%s:</I></B>\n";
        final String valFmt = "<UL><LI><FONT color=#0099FF><B>%s</B></FONT></LI></UL>\n";
        final String endPosFmt = "</LI></UL>\n";
        final String beginFmt = "<DIV style=\"OVERFLOW-X: hidden; WIDTH: 100%\">\n";
        final String endFmt = "\n";

        StringBuilder sb = new StringBuilder();
        sb.append(beginFmt);

        JSONArray jsonArr = new JSONArray(json);
        String trans = jsonArr.getJSONArray(0).getJSONArray(0).get(0).toString();
        String transStr = String.format(transFmt, trans);
        sb.append(transStr);
        sb.append("<DIV style=\"MARGIN: 0px 0px 5px\">\n");

        sb.append(endFmt);

        return sb.toString();
    }

    interface TranslateViewModelListener{
        void onShowProgressDlg(boolean bShow);
    }
}
