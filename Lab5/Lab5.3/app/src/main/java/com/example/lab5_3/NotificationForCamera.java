package com.example.lab5_3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

   //class for notice about launched Camera

public class NotificationForCamera extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Camera");
        builder.setMessage("Launched the camera app");
        builder.setPositiveButton("Confirm", null);
        return builder.create();
    }
}