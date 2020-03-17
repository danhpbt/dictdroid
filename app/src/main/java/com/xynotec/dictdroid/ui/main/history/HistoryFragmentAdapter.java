package com.xynotec.dictdroid.ui.main.history;

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

    private HistoryFragmentAdapterListener mListener;

    private HistoryViewModel mHistoryViewModel;

    public HistoryFragmentAdapter(HistoryViewModel historyViewModel)
    {
        this.mHistoryViewModel = historyViewModel;
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
    }

    @Override
    public int getItemCount() {
        return histories.size();
    }

    public void loadHistories()
    {
        List<History> data = mHistoryViewModel.getDataManager().getHistories().getValue();

        if ((data != null) && (data.size() != 0))
        {
            histories.clear();
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

    public interface HistoryFragmentAdapterListener
    {
        void onClickListener(int index);
    }

    class HistoryViewHolder extends BaseViewHolder
            implements HistoryViewItemModel.HistoryViewItemModelListener {

        HistoryFragmentRvItemBinding mBinding;
        HistoryViewItemModel mHistoryViewItemModel;

        public HistoryViewHolder(HistoryFragmentRvItemBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
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
    }
}
