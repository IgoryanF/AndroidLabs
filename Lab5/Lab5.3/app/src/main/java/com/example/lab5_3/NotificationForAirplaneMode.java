package com.example.lab5_3;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import java.util.Objects;

    //class for notice about switched Airplane mode

public class NotificationForAirplaneMode extends DialogFragment {
    boolean AirplaneModeSwitched;

    public NotificationForAirplaneMode(boolean AirplaneModeOn) {
        this.AirplaneModeSwitched = AirplaneModeOn;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
        builder.setTitle("Airplane mode");
        if(AirplaneModeSwitched) {
            builder.setMessage("Switched on");
        }
        else {
            builder.setMessage("Switched off");
        }
        builder.setPositiveButton("Confirm", null);
        return builder.create();
    }
}