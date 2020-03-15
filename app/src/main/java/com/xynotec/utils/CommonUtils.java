package com.xynotec.utils;

import android.app.AlertDialog;
import android.content.Context;

import com.xynotec.dictdroid.ende.R;

public class CommonUtils {

    public static void showErrorDlg(Context context, String msg)
    {
        AlertDialog infoDlg = new AlertDialog.Builder(context, R.style.AlertDialogErrorStyle)
                .setIcon(R.drawable.ic_alert_error)
                .setTitle(R.string.app_name)
                .setMessage(msg)
                .setPositiveButton(R.string.str_ok, null)
                .setCancelable(false)
                .create();

        infoDlg.show();
    }

    public static void showWarningDlg(Context context, String msg)
    {
        AlertDialog infoDlg = new AlertDialog.Builder(context, R.style.AlertDialogWarningStyle)
                .setIcon(R.drawable.ic_alert_warning)
                .setTitle(R.string.app_name)
                .setMessage(msg)
                .setPositiveButton(R.string.str_ok, null)
                .setCancelable(false)
                .create();

        infoDlg.show();
    }

    public static void showInfoDlg(Context context, String msg)
    {
        AlertDialog infoDlg = new AlertDialog.Builder(context, R.style.AlertDialogInfoStyle)
                .setIcon(R.drawable.ic_alert_info)
                .setTitle(R.string.app_name)
                .setMessage(msg)
                .setPositiveButton(R.string.str_ok, null)
                .setCancelable(false)
                .create();

        infoDlg.show();
    }

    public static void showSuccessDlg(Context context, String msg)
    {
        AlertDialog infoDlg = new AlertDialog.Builder(context, R.style.AlertDialogSuccessStyle)
                .setIcon(R.drawable.ic_alert_success)
                .setTitle(R.string.app_name)
                .setMessage(msg)
                .setPositiveButton(R.string.str_ok, null)
                .setCancelable(false)
                .create();

        infoDlg.show();
    }
}
