package com.xynotec.dictdroid.ui.main.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import com.xynotec.dagger.BaseViewHolder;
import com.xynotec.dictdroid.ende.databinding.SearchFragmentRvItemBinding;
import com.xynotec.dictdroid.engine.DictEngine;


public class SearchFragmentAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private DictEngine mDictEngine;

    private SearchFragmentAdapterListener mListener;

    public SearchFragmentAdapter(DictEngine dictEngine)
    {
        this.mDictEngine = dictEngine;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SearchFragmentRvItemBinding wordItemBinding =
                SearchFragmentRvItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
        return new WordViewHolder(wordItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return mDictEngine.GetNumWordInDic();
    }

    public DictEngine getDictEngine()
    {
        return mDictEngine;
    }

    public void setListener(SearchFragmentAdapterListener listener)
    {
        mListener = listener;
    }

    public interface SearchFragmentAdapterListener
    {
        void onClickListener(int index);
    }

    public class WordViewHolder extends BaseViewHolder
            implements SearchViewItemModel.SearchViewItemModelListener {

        SearchFragmentRvItemBinding mBinding;
        SearchViewItemModel mSearchViewItemModel;

        public WordViewHolder(SearchFragmentRvItemBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            final String word = mDictEngine.GetWord(position);
            mSearchViewItemModel = new SearchViewItemModel(position, word , this);
            mBinding.setViewModel(mSearchViewItemModel);

            // Immediate Binding
            // When a variable or observable changes, the binding will be scheduled to change before
            // the next frame. There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            mBinding.executePendingBindings();
        }

        @Override
        public void onItemClick(int index) {
            mListener.onClickListener(index);
        }
    }


}