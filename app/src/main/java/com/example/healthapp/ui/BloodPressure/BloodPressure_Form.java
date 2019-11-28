package com.example.healthapp.ui.BloodPressure;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.healthapp.R;

public class BloodPressure_Form extends Fragment {

    public BloodPressure_Form() {
        // Required empty public constructor
    }
    private BloodPressureViewModel mViewModel;

    // Reading Input
    EditText bloodPressureInput;
    Button submitButton;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View bloodPressureForm = inflater.inflate(R.layout.fragment_blood_pressure__form, container, false);

        bloodPressureInput = bloodPressureForm.findViewById(R.id.bloodPrsInput);
        submitButton = bloodPressureForm.findViewById(R.id.submitBtn);

        return bloodPressureForm;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(BloodPressureViewModel.class);
        // TODO: Use the ViewModel

        submitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(bloodPressureInput.getText() != null)
                {
                    Log.d("BloodPressure", bloodPressureInput.getText().toString());
                    boolean success = mViewModel.saveBloodPressure(bloodPressureInput.getText().toString(), getActivity().getApplicationContext());
                    if(success == true)
                    {
                        bloodPressureInput.setText("");
                    }
                    else
                    {
                        Toast.makeText(getActivity(), "DataEntry Unsuccessfull", Toast.LENGTH_SHORT).show();
                    }
                }
                Log.d("fragmentChecker", bloodPressureInput.getText().toString());
            }
        });

    }

}
