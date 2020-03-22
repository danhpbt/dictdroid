package com.xynotec.dictdroid.ui.main.favorite;

import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xynotec.dagger.BaseViewHolder;
import com.xynotec.dictdroid.data.model.Favorite;
import com.xynotec.dictdroid.data.model.History;
import com.xynotec.dictdroid.ende.databinding.FavoriteFragmentRvItemBinding;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFragmentAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    List<Favorite> favorites = new ArrayList<>();
    private SparseBooleanArray mSelectedItemsIds;

    private FavoriteFragmentAdapterListener mListener;

    private FavoriteViewModel mFavoriteViewModel;

    public FavoriteFragmentAdapter(FavoriteViewModel favoriteViewModel)
    {
        this.mFavoriteViewModel = favoriteViewModel;
        mSelectedItemsIds = new SparseBooleanArray();

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
        favorites.clear();

        if ((data != null) && (data.size() != 0))
        {
            favorites.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void setListener(FavoriteFragmentAdapterListener listener)
    {
        mListener = listener;
    }

    public Favorite getItem(int position)
    {
        return favorites.get(position);
    }

    //////////////////Selection
    public void clearSelections() {
        mSelectedItemsIds.clear();
        notifyDataSetChanged();
    }

    public void selectAll()
    {
        mSelectedItemsIds.clear();
        for(int i = 0; i < favorites.size(); i++)
            mSelectedItemsIds.put(i, true);

        notifyDataSetChanged();
    }

    public void deleteSelectedItem()
    {
        for (int i =  (favorites.size() - 1); i >= 0; i--)
        {
            boolean bSelected = mSelectedItemsIds.get(i);
            if  (bSelected) {
                Favorite favorite = favorites.get(i);
                favorites.remove(i);
                mFavoriteViewModel.getDataManager().deleteFavorite(favorite.getWord());
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
    public interface FavoriteFragmentAdapterListener
    {
        void onClickListener(int index);
        void onItemLongClick(int index);
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

        @Override
        public void onItemLongClick(int index) {
            mListener.onItemLongClick(index);
        }
    }
}