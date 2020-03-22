package com.xynotec.dictdroid.ui.main.history;

import android.graphics.Color;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.xynotec.dagger.BaseViewHolder;
import com.xynotec.dictdroid.data.model.History;
import com.xynotec.dictdroid.ende.databinding.HistoryFragmentRvItemBinding;
import com.xynotec.dictdroid.ui.main.search.SearchViewModel;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragmentAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    List<History> histories = new ArrayList<>();
    private SparseBooleanArray mSelectedItemsIds;

    private HistoryFragmentAdapterListener mListener;

    private HistoryViewModel mHistoryViewModel;

    public HistoryFragmentAdapter(HistoryViewModel historyViewModel)
    {
        this.mHistoryViewModel = historyViewModel;
        mSelectedItemsIds = new SparseBooleanArray();

        List<History> data = this.mHistoryViewModel.getDataManager().getHistories().getValue();

        if ((data != null) && (data.size() != 0))
            histories.addAll(data);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        HistoryFragmentRvItemBinding historyItemBinding =
                HistoryFragmentRvItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
        return new HistoryViewHolder(historyItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
        HistoryViewHolder historyViewHolder = (HistoryViewHolder)holder;
        historyViewHolder.setSelected(mSelectedItemsIds.get(position));
    }

    @Override
    public int getItemCount() {
        return histories.size();
    }

    public void loadHistories()
    {
        List<History> data = mHistoryViewModel.getDataManager().getHistories().getValue();
        histories.clear();

        if ((data != null) && (data.size() != 0))
        {
            histories.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void setListener(HistoryFragmentAdapterListener listener)
    {
        mListener = listener;
    }

    public History getItem(int position)
    {
        return histories.get(position);
    }


    //////////////////Selection
    public void clearSelections() {
        mSelectedItemsIds.clear();
        notifyDataSetChanged();
    }

    public void selectAll()
    {
        mSelectedItemsIds.clear();
        for(int i = 0; i < histories.size(); i++)
            mSelectedItemsIds.put(i, true);

        notifyDataSetChanged();
    }

    public void deleteSelectedItem()
    {
        for (int i =  (histories.size() - 1); i >= 0; i--)
        {
            boolean bSelected = mSelectedItemsIds.get(i);
            if  (bSelected) {
                History  history = histories.get(i);
                histories.remove(i);
                mHistoryViewModel.getDataManager().deleteHistory(history.getWord());
            }
        }

        mSelectedItemsIds.clear();
        notifyDataSetChanged();
    }

    public int getSelectedItemCount()
    {
        return mSelectedItemsIds.size();
    }
    public void  toggleSelection(int position) {
        selectView(position, !mSelectedItemsIds.get(position));
    }

    // Item checked on selection
    public void selectView(int position, boolean value) {
        if (value)
            mSelectedItemsIds.put(position,  value);
        else
            mSelectedItemsIds.delete(position);
        notifyDataSetChanged();
    }

    //////////////////////////////////////////////////
    public interface HistoryFragmentAdapterListener
    {
        void onClickListener(int index);
        void onItemLongClick(int index);
    }

    class HistoryViewHolder extends BaseViewHolder
            implements HistoryViewItemModel.HistoryViewItemModelListener {

        HistoryFragmentRvItemBinding mBinding;
        HistoryViewItemModel mHistoryViewItemModel;

        public HistoryViewHolder(HistoryFragmentRvItemBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        public void setSelected(boolean bSelect)
        {
            mHistoryViewItemModel.setSelected(bSelect);
        }

        @Override
        public void onBind(int position) {
            History history = histories.get(position);
            mHistoryViewItemModel = new HistoryViewItemModel(position, history.getWord(),
                    history.getDictLang(), history.getDateTime(), this);
            mBinding.setViewModel(mHistoryViewItemModel);

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

        @Override
        public void onItemLongClick(int index) {
            mListener.onItemLongClick(index);
        }
    }
}
