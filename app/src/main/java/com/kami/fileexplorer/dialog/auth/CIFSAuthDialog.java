package com.kami.fileexplorer.dialog.auth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kami.fileexplorer.R;
import com.kami.fileexplorer.dialog.BaseDialogFragment;

/**
 * author: youyi_sizuru
 * data: 2017/8/13
 */

public class CIFSAuthDialog extends BaseDialogFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_cifs_auth, container, false);
    }
}
