package com.dicoding.reminderapps.fragmentBottomSheets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dicoding.reminderapps.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheets_Login extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.bottom_sheet, container, false);
        /*Context context = new ContextThemeWrapper(getActivity(), getTheme());
        LayoutInflater localInflater = inflater.cloneInContext(context);
        return localInflater.inflate(R.layout.bottom_sheet, container, false);*/
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //getTheme();
        super.onViewCreated(view, savedInstanceState);
    }
}
