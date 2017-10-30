package com.kami.fileexplorer.dialog.auth;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kami.fileexplorer.R;
import com.kami.fileexplorer.widget.FSEditText;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * author: youyi_sizuru
 * data: 2017/8/13
 */

public class CIFSAuthDialog extends AuthDialog {
    @BindView(R.id.cifs_area_text)
    FSEditText mAreaText;
    @BindView(R.id.cifs_username_text)
    FSEditText mUsernameText;
    @BindView(R.id.cifs_password_text)
    FSEditText mPasswordText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        return inflater.inflate(R.layout.dialog_cifs_auth, container, false);
    }

    @OnClick(R.id.cancel_btn)
    public void onCancel() {
        this.dismiss();
    }

    @OnClick(R.id.link_btn)
    public void onLink() {
        this.dismiss();
        OnAuthListener listener = getAuthListener();
        if (listener == null) {
            return;
        }
        getAuthListener().onAuth(mAreaText.getText().toString().trim(), mUsernameText.getText().toString().trim(),
                mPasswordText.getText().toString().trim());
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setTitle("连接到");
        return dialog;
    }

}
