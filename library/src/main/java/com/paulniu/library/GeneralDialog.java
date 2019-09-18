package com.paulniu.library;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import com.paulniu.library.callbacks.IBaseDialogClickCallback;
import com.paulniu.library.callbacks.IDialogListClickCallback;
import com.paulniu.library.callbacks.IListDialogSelectCallback;
import com.paulniu.library.callbacks.IThreeBtnDialogClickCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Coder: niupuyue
 * Date: 2019/9/18
 * Time: 14:49
 * Desc: 原生弹出框
 * Version:
 */
public class GeneralDialog {

    /**
     * 带有两个按钮的弹出框
     *
     * @param context
     * @param title
     * @param message
     * @param callback
     */
    public static void dialogWithTwoBtn(Context context, String title, String message, IBaseDialogClickCallback callback) {
        dialogWithTwoBtn(context, title, message, "确定", "取消", true, callback);
    }

    /**
     * 带有两个按钮的弹出框
     *
     * @param context
     * @param title
     * @param message
     * @param strPositive
     * @param strNegative
     * @param isCancelable
     * @param callback
     */
    public static void dialogWithTwoBtn(Context context, String title, String message, String strPositive, String strNegative, boolean isCancelable, final IBaseDialogClickCallback callback) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(isCancelable);
        builder.setPositiveButton(strPositive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (null != callback) {
                    callback.onClickPositive();
                }
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(strNegative, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (null != callback) {
                    callback.onClickNegative();
                }
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    /**
     * 有三个按钮的弹窗
     *
     * @param context
     * @param title
     * @param message
     * @param strNeutral
     * @param callback
     */
    public static void dialogWithThreeBtn(Context context, String title, String message, String strNeutral, IThreeBtnDialogClickCallback callback) {
        dialogWithThreeBtn(context, title, message, "确定", "取消", strNeutral, true, callback);
    }

    /**
     * 有三个按钮的弹窗
     *
     * @param context
     * @param title
     * @param message
     * @param strPositive
     * @param strNegative
     * @param strNeutral
     * @param isCancelable
     * @param callback
     */
    public static void dialogWithThreeBtn(Context context, String title, String message, String strPositive, String strNegative, String strNeutral, boolean isCancelable, final IThreeBtnDialogClickCallback callback) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(isCancelable);
        builder.setPositiveButton(strPositive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (null != callback) {
                    callback.onClickPositive();
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNeutralButton(strNeutral, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (null != callback) {
                    callback.onClickNeutral();
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton(strNegative, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (null != callback) {
                    callback.onClickNegative();
                }
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    /**
     * 列表弹框
     *
     * @param context
     * @param title
     * @param items
     * @param callback
     */
    public static void dialogWithList(Context context, String title, String[] items, IDialogListClickCallback callback) {
        dialogWithList(context, title, items, false, callback);
    }

    /**
     * 列表弹框
     *
     * @param context
     * @param title
     * @param items
     * @param callback
     */
    public static void dialogWithList(Context context, String title, List<String> items, IDialogListClickCallback callback) {
        dialogWithList(context, title, (String[]) items.toArray(), true, callback);
    }

    /**
     * 列表弹框
     *
     * @param context
     * @param title
     * @param items
     * @param isCancalable
     * @param callback
     */
    public static void dialogWithList(Context context, String title, String[] items, boolean isCancalable, final IDialogListClickCallback callback) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setCancelable(isCancalable);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position) {
                if (null != callback) {
                    callback.onClickDialogList(position);
                }
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    /**
     * 单选列表弹窗
     *
     * @param context
     * @param title
     * @param items
     * @param callback
     */
    public static void dialogSingleSelect(Context context, String title, String[] items, IListDialogSelectCallback callback) {
        dialogSingleSelect(context, title, items, false, callback);
    }

    /**
     * 单选列表弹窗
     *
     * @param context
     * @param title
     * @param items
     * @param callback
     */
    public static void dialogSingleSelect(Context context, String title, List<String> items, IListDialogSelectCallback callback) {
        dialogSingleSelect(context, title, (String[]) items.toArray(), false, callback);
    }

    /**
     * 单选列表弹窗
     *
     * @param context
     * @param title
     * @param items
     * @param isCancelable
     * @param callback
     */
    public static void dialogSingleSelect(Context context, String title, String[] items, boolean isCancelable, final IListDialogSelectCallback callback) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setCancelable(isCancelable);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position) {
                if (null != callback) {
                    List<Integer> res = new ArrayList<>();
                    res.add(position);
                    callback.onListDialogClick(res);
                }
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    /**
     * 多选列表弹窗
     *
     * @param context
     * @param title
     * @param items
     * @param callback
     */
    public static void dialogMultiSelect(Context context, String title, String[] items, IListDialogSelectCallback callback) {
        if (items == null || items.length == 0) {
            return;
        }
        int len = items.length;
        boolean[] selects = new boolean[len];
        for (int i = 0; i < len; i++) {
            selects[i] = false;
        }
        dialogMultiSelect(context, title, items, selects, false, callback);
    }

    /**
     * 多选列表弹窗
     *
     * @param context
     * @param title
     * @param items
     * @param selects
     * @param callback
     */
    public static void dialogMultiSelect(Context context, String title, String[] items, boolean[] selects, IListDialogSelectCallback callback) {
        if (items == null || items.length == 0 || selects == null || selects.length == 0 || items.length != selects.length) {
            return;
        }
        dialogMultiSelect(context, title, items, selects, false, callback);
    }

    /**
     * 多选列表弹窗
     *
     * @param context
     * @param title
     * @param items
     * @param selects
     * @param isCancelable
     * @param callback
     */
    public static void dialogMultiSelect(Context context, String title, String[] items, boolean[] selects, boolean isCancelable, final IListDialogSelectCallback callback) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setCancelable(isCancelable);
        final List<Integer> res = new ArrayList<>();
        builder.setMultiChoiceItems(items, selects, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position, boolean isSelect) {
                if (isSelect) {
                    res.add(((Integer) position));
                } else {
                    res.remove(((Integer) position));
                }
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (null != callback) {
                    callback.onListDialogClick(res);
                }
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    public static final int MAX_VALUE = 100;

    public static void dialogProgress(Context context, String title) {
        final ProgressDialog dialog = new ProgressDialog(context);
        dialog.setProgress(0);
        dialog.setTitle("带有加载进度dialog");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setMax(MAX_VALUE);
        dialog.show();
    }

}
