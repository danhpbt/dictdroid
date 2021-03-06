package com.xynotec.dictdroid.ui.main.favorite;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ActionMode;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xynotec.dagger.BaseFragment;
import com.xynotec.dictdroid.ViewModelProviderFactory;
import com.xynotec.dictdroid.data.model.Favorite;
import com.xynotec.dictdroid.ende.BR;
import com.xynotec.dictdroid.ende.R;
import com.xynotec.dictdroid.ende.databinding.FragmentFavoriteBinding;
import com.xynotec.dictdroid.ui.main.MainActivity;
import com.xynotec.dictdroid.ui.main.MainViewModel;
import com.xynotec.dictdroid.ui.mean.MeanActivity;

import javax.inject.Inject;

import butterknife.BindView;

public class FavoriteFragment extends BaseFragment<FragmentFavoriteBinding, FavoriteViewModel> implements
        FavoriteFragmentAdapter.FavoriteFragmentAdapterListener, ActionMode.Callback {

    LinearLayoutManager linearLayoutManager;

    @BindView(R.id.rvFavorite)
    RecyclerView rvFavorite;

    FavoriteFragmentAdapter mFavoriteFragmentAdapter;

    @Inject
    ViewModelProviderFactory factory;
    FavoriteViewModel mFavoriteViewModel;

    private ActionMode actionMode;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_favorite;
    }

    @Override
    public int getBindingVariable() {
        return BR.favoriteVM;
    }

    @Override
    public FavoriteViewModel getViewModel() {
        mFavoriteViewModel = new ViewModelProvider(this, factory).get(FavoriteViewModel.class);
        return mFavoriteViewModel;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        Context context = getContext();

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);

        linearLayoutManager = new LinearLayoutManager(context);

        mFavoriteFragmentAdapter  = new FavoriteFragmentAdapter(mFavoriteViewModel);

        rvFavorite.setLayoutManager(linearLayoutManager);
        rvFavorite.addItemDecoration(dividerItemDecoration);
        rvFavorite.setAdapter(mFavoriteFragmentAdapter);

        mFavoriteFragmentAdapter.setListener(this);

        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        mFavoriteFragmentAdapter.loadFavorites();
    }

    @Override
    public void onClickListener(int index) {
        showMean(index);
    }

    @Override
    public void onItemLongClick(int index) {
        enableActionMode(index);
    }

    void showMean(int index) {

        Favorite favorite = mFavoriteFragmentAdapter.getItem(index);

        MainActivity activity = (MainActivity)getBaseActivity();
        MainViewModel mainViewModel = activity.getViewModel();
        String activityTitle = mainViewModel.getDictLongName().get();

        Intent intent = new Intent(activity, MeanActivity.class);
        intent.putExtra("title", activityTitle);
        intent.putExtra("word", favorite.getWord());
        intent.putExtra("mean", favorite.getMean());
        intent.putExtra("lang", favorite.getDictLang());
        startActivity(intent);
    }

    void doSelectAll(ActionMode mode)
    {
        mFavoriteFragmentAdapter.selectAll();

        int count = mFavoriteFragmentAdapter.getSelectedItemCount();

        if (count == 0)
            actionMode.finish();
        else
            actionMode.setTitle(count + "  selected");
    }

    void doDelete(final ActionMode mode)
    {
        AlertDialog clearAlertDlg = new AlertDialog.Builder(getActivity(), R.style.AlertDialogInfoStyle)
                .setIcon(R.drawable.ic_alert_info)
                .setTitle(R.string.delete_favorite)
                .setMessage(R.string.alert_dialog_delete_confirm)
                .setPositiveButton(R.string.alert_dialog_yes,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                doPositiveClick(mode);
                            }
                        }
                )
                .setNegativeButton(R.string.alert_dialog_no,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                doNegativeClick();
                            }
                        }
                )
                .setCancelable(false)
                .create();

        clearAlertDlg.show();
    }

    public void doPositiveClick(ActionMode mode) {
        deleteSelected(mode);
    }

    public void doNegativeClick() {
        // Do stuff here.
    }

    private void deleteSelected(ActionMode mode)
    {
        mFavoriteFragmentAdapter.deleteSelectedItem();

        // Close CAB
        mode.finish();
    }

    private void enableActionMode(int position) {
        MainActivity activity = (MainActivity) getBaseActivity();
        if (actionMode == null)
            actionMode = activity.startSupportActionMode(this);
        toggleSelection(position);
    }

    private void toggleSelection(int position) {
        mFavoriteFragmentAdapter.toggleSelection(position);
        int count = mFavoriteFragmentAdapter.getSelectedItemCount();

        if (count == 0)
            actionMode.finish();
        else
            actionMode.setTitle(count + "  selected");
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        getActivity().getMenuInflater().inflate(R.menu.menu_del_item,menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch  (item.getItemId()) {
            case R.id.selectAll:
                doSelectAll(mode);
                return true;

            case R.id.delete:
                doDelete(mode);
                return true;
        }
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        mFavoriteFragmentAdapter.clearSelections();
        actionMode = null;
    }
}
