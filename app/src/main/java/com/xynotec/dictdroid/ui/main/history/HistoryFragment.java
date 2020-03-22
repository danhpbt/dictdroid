package com.xynotec.dictdroid.ui.main.history;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

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
import com.xynotec.dictdroid.control.MeanView;
import com.xynotec.dictdroid.data.model.History;
import com.xynotec.dictdroid.ende.BR;
import com.xynotec.dictdroid.ende.R;
import com.xynotec.dictdroid.ende.databinding.FragmentHistoryBinding;
import com.xynotec.dictdroid.ui.main.MainActivity;
import com.xynotec.dictdroid.ui.main.MainViewModel;
import com.xynotec.dictdroid.ui.mean.MeanActivity;

import javax.inject.Inject;

import butterknife.BindView;

public class HistoryFragment extends BaseFragment<FragmentHistoryBinding, HistoryViewModel> implements
        HistoryFragmentAdapter.HistoryFragmentAdapterListener, ActionMode.Callback {

    LinearLayoutManager linearLayoutManager;

    @BindView(R.id.rvHistory)
    RecyclerView rvHistory;

    HistoryFragmentAdapter mHistoryFragmentAdapter;

    @Inject
    ViewModelProviderFactory factory;
    HistoryViewModel mHistoryViewModel;

    private ActionMode actionMode;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_history;
    }

    @Override
    public int getBindingVariable() {
        return BR.historyVM;
    }

    @Override
    public HistoryViewModel getViewModel() {
        mHistoryViewModel = new ViewModelProvider(this, factory).get(HistoryViewModel.class);
        return mHistoryViewModel;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        Context context = getContext();

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);

        linearLayoutManager = new LinearLayoutManager(context);

        mHistoryFragmentAdapter  = new HistoryFragmentAdapter(mHistoryViewModel);

        rvHistory.setLayoutManager(linearLayoutManager);
        rvHistory.addItemDecoration(dividerItemDecoration);
        rvHistory.setAdapter(mHistoryFragmentAdapter);

        mHistoryFragmentAdapter.setListener(this);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mHistoryFragmentAdapter.loadHistories();
    }

    @Override
    public void onClickListener(int index) {
        if (mHistoryFragmentAdapter.getSelectedItemCount() > 0)
            enableActionMode(index);
        else
            showMean(index);
    }

    @Override
    public void onItemLongClick(int index) {
        enableActionMode(index);
    }

    void showMean(int index) {

        History history = mHistoryFragmentAdapter.getItem(index);

        MainActivity activity = (MainActivity)getBaseActivity();
        MainViewModel mainViewModel = activity.getViewModel();
        String activityTitle = mainViewModel.getDictLongName().get();

        Intent intent = new Intent(activity, MeanActivity.class);
        intent.putExtra("title", activityTitle);
        intent.putExtra("word", history.getWord());
        intent.putExtra("mean", history.getMean());
        intent.putExtra("lang", history.getDictLang());
        startActivity(intent);
    }

    void doSelectAll(ActionMode mode)
    {
        mHistoryFragmentAdapter.selectAll();

        int count = mHistoryFragmentAdapter.getSelectedItemCount();

        if (count == 0)
            actionMode.finish();
        else
            actionMode.setTitle(count + "  selected");
    }

    void doDelete(final ActionMode mode)
    {
        AlertDialog clearAlertDlg = new AlertDialog.Builder(getActivity(), R.style.AlertDialogInfoStyle)
                .setIcon(R.drawable.ic_alert_info)
                .setTitle(R.string.delete_history)
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
        mHistoryFragmentAdapter.deleteSelectedItem();

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
        mHistoryFragmentAdapter.toggleSelection(position);
        int count = mHistoryFragmentAdapter.getSelectedItemCount();

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
        mHistoryFragmentAdapter.clearSelections();
        actionMode = null;
    }

}
