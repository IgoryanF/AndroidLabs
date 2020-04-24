package com.example.lab5_1;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogWin extends DialogFragment {

    private DialogWinListener mListener;

    // pass the interface to Activity

    public static interface DialogWinListener {
        void onDialogWinResult(String choice);
    }

    public static DialogWin newInstance(String param1) {
        DialogWin fragment = new DialogWin();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mParam1 = getArguments() == null ? "null" : getArguments().getString(ARG_PARAM1);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //print a specific digit / number

        builder.setTitle("You choose number: " + mParam1);
        builder.setPositiveButton("confirm", null);
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (DialogWinListener) context;
        } catch (ClassCastException ex) {
            throw new ClassCastException(context.toString() + " must implement DialogWin.DialogWinListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
