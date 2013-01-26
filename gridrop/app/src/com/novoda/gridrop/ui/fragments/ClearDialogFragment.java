package com.novoda.gridrop.ui.fragments;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.novoda.gridrop.MainActivity;
import com.novoda.gridrop.R;

public class ClearDialogFragment extends DialogFragment {
    
    public static ClearDialogFragment newInstance() {
        ClearDialogFragment fragment = new ClearDialogFragment();
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
    
        Builder builder = new Builder(getActivity());
        builder.setTitle(R.string.clear_all);
        builder.setMessage(R.string.clear_all_dialog);
        builder.setNegativeButton(android.R.string.cancel, null);
        builder.setPositiveButton(R.string.clear_all, new OnClickListener() {
            
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Activity a = getActivity();
                if(a != null && !a.isFinishing() && a instanceof MainActivity) {
                    ((MainActivity)a).clear();
                }
            }
        });
        
        return builder.create();
    }
}
