package com.dicoding.reminderapps;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import java.util.Objects;

public class DialogFragment extends BaseDialog<DialogFragment.OnDialogFragmentClickListener> {

    public interface OnDialogFragmentClickListener {
        void onOkClicked(DialogFragment dialog);
        void onCancelClicked(DialogFragment dialog);
    }

    static DialogFragment newInstance(String title, String message) {
        DialogFragment frag = new DialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("msg", message);
        frag.setArguments(args);
        return frag;
    }
    // Create a Dialog using default AlertDialog builder , if not inflate custom view in onCreateView
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        assert getArguments() != null;
        return new AlertDialog.Builder(Objects.requireNonNull(getActivity()))
                .setTitle(getArguments().getString("title"))
                .setMessage(getArguments().getString("msg"))
                .setCancelable(false)
                .setPositiveButton("OK",
                        (dialog, whichButton) -> {
                            // Positive button clicked
                            getActivityInstance().onOkClicked(DialogFragment.this);
                        }
                )
                .setNegativeButton("Cancel",
                        (dialog, whichButton) -> {
                            // negative button clicked
                            getActivityInstance().onCancelClicked(DialogFragment.this);
                        }
                )
                .create();
    }
}
