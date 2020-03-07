package com.xynotec.dictdroid.ui.main.search;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xynotec.dagger.BaseFragment;
import com.xynotec.dictdroid.control.MeanView;
import com.xynotec.dictdroid.ende.R;

import javax.inject.Inject;

public class SearchFragment extends BaseFragment<SearchViewModel> implements
        SearchFragmentAdapter.SearchFragmentAdapterListener{
    final static int SEARCH_VIEW = 0;
    final static int MEAN_VIEW = 1;

    int curView = SEARCH_VIEW;


    LinearLayoutManager linearLayoutManager;
    ViewFlipper viewFlipper;
    RecyclerView rvWord;
    MeanView meanView;

    @Inject
    SearchFragmentAdapter mSearchFragmentAdapter;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_search;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Context context = getContext();

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);

        viewFlipper = view.findViewById(R.id.viewFlipper);

        linearLayoutManager =  new LinearLayoutManager(context);

        rvWord = view.findViewById(R.id.rvWord);
        rvWord.setLayoutManager(linearLayoutManager);
        rvWord.addItemDecoration(dividerItemDecoration);
        rvWord.setAdapter(mSearchFragmentAdapter);

        mSearchFragmentAdapter.setListener(this);

        meanView = view.findViewById(R.id.meanView);
    }

    @Override
    public void onClickListener(int index) {
        showMean(index);
    }

    public void OnEditSearch(String word)
    {
        showWordListView();
        int posWord = mSearchFragmentAdapter.getDictEngine().OnEditSearch(word);
        linearLayoutManager.scrollToPositionWithOffset(posWord, 0);
    }

    public void OnSubmitSearch(String word)
    {
        int posWord = mSearchFragmentAdapter.getDictEngine().OnEditSearch(word);
        String wordFind =mSearchFragmentAdapter.getDictEngine().GetWord(posWord);
        if (wordFind.compareToIgnoreCase(word) == 0)
            showMean(posWord);
    }

    void showMean(int index) {

//        Util.hideEmulatorKeyboard(getActivity());
//
//        viewFlipper.setDisplayedChild(MEAN_VIEW);
//        curView = MEAN_VIEW;
//
//        String word = mSearchFragmentAdapter.getDictEngine().GetWord(index);
//        String mean = HtmlConverter.String_htmlEncode(mSearchFragmentAdapter.getDictEngine().GetMeanWord(index));
//
//        //DictDbHelper.getInstance().AddHistory(word, mean);
//
//        meanView.setWordMean(word, mean);
    }

    void showWordListView()
    {
        if (curView != SEARCH_VIEW)
        {
            viewFlipper.setDisplayedChild(SEARCH_VIEW);
            curView = SEARCH_VIEW;
        }
    }
}
