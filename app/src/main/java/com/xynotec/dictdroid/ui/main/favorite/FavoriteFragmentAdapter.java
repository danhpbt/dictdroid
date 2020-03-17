package com.xynotec.dictdroid.ui.main.favorite;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xynotec.dagger.BaseViewHolder;
import com.xynotec.dictdroid.data.model.Favorite;
import com.xynotec.dictdroid.ende.databinding.FavoriteFragmentRvItemBinding;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFragmentAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    List<Favorite> favorites = new ArrayList<>();

    private HistoryFragmentAdapterListener mListener;

    private FavoriteViewModel mFavoriteViewModel;

    public FavoriteFragmentAdapter(FavoriteViewModel favoriteViewModel)
    {
        this.mFavoriteViewModel = favoriteViewModel;
        List<Favorite> data = this.mFavoriteViewModel.getDataManager().getFavorites().getValue();

        if ((data != null) && (data.size() != 0))
            favorites.addAll(data);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FavoriteFragmentRvItemBinding favoriteItemBinding =
                FavoriteFragmentRvItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
        return new FavoriteViewHolder(favoriteItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return favorites.size();
    }

    public void loadFavorites()
    {
        List<Favorite> data = mFavoriteViewModel.getDataManager().getFavorites().getValue();

        if ((data != null) && (data.size() != 0))
        {
            favorites.clear();
            favorites.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void setListener(HistoryFragmentAdapterListener listener)
    {
        mListener = listener;
    }

    public Favorite getItem(int position)
    {
        return favorites.get(position);
    }

    public interface HistoryFragmentAdapterListener
    {
        void onClickListener(int index);
    }

    class FavoriteViewHolder extends BaseViewHolder
            implements FavoriteViewItemModel.FavoriteViewItemModelListener {

        FavoriteFragmentRvItemBinding mBinding;
        FavoriteViewItemModel mFavoriteViewItemModel;

        public FavoriteViewHolder(FavoriteFragmentRvItemBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            Favorite favorite = favorites.get(position);
            mFavoriteViewItemModel = new FavoriteViewItemModel(position, favorite.getWord(),
                    favorite.getDictLang(), favorite.getDateTime(), this);
            mBinding.setViewModel(mFavoriteViewItemModel);

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