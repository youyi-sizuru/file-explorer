package com.kami.fileexplorer.dialog.auth;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import com.kami.fileexplorer.Constants;
import com.kami.fileexplorer.dialog.BaseDialogFragment;

import jcifs.smb.NtlmPasswordAuthentication;

/**
 * author: youyi_sizuru
 * data: 2017/9/11
 */

public abstract class AuthDialog extends BaseDialogFragment {
    private OnAuthListener mAuthListener;

    public void setAuthListener(OnAuthListener listener) {
        this.mAuthListener = listener;
    }


    public OnAuthListener getAuthListener() {
        return mAuthListener;
    }

    public interface OnAuthListener {
        void onAuth(String... args);
    }
}
