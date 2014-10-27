package com.royal.mukhi.homework;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class AlertDialogFragment extends DialogFragment
{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        DialogInterface.OnClickListener positiveClick = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity().getBaseContext(), "Exiting...", Toast.LENGTH_SHORT).show();
                getActivity().finish();        }   };
        DialogInterface.OnClickListener negativeClick = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity().getBaseContext(), "Returning to the App", Toast.LENGTH_SHORT).show();
            }   };

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Do you want to exit the app?");
        builder.setPositiveButton("Yes", positiveClick);
        builder.setNegativeButton("No", negativeClick);
        builder.setTitle("Confirmation");
        Dialog dialog = builder.create();
        return dialog;  }
}


