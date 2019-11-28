package com.example.healthapp.ui.Glucose;

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

public class Glucose_Form extends Fragment {
    private GlucoseViewModel mViewModel;

    // Input
    EditText previousGlucoseInput;
    EditText currentGlucoseInput;

    public static Glucose newInstance() {
        return new Glucose();
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {



        return inflater.inflate(R.layout.fragment_glucose__form, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(GlucoseViewModel.class);
        // TODO: Use the ViewModel

        previousGlucoseInput = getView().findViewById(R.id.previousGlucose);
        currentGlucoseInput = getView().findViewById(R.id.currentGlucose);

        Button button = getView().findViewById(R.id.submitBtn);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(previousGlucoseInput.getText() != null && currentGlucoseInput.getText() != null)
                {
                    Log.d("Glucose", previousGlucoseInput.getText().toString()+ " " +  currentGlucoseInput.getText().toString());
                    boolean success = mViewModel.saveGlucose(previousGlucoseInput.getText().toString(), currentGlucoseInput.getText().toString(), getActivity().getApplicationContext());
                    if(success == true)
                    {
                        previousGlucoseInput.setText("");
                        currentGlucoseInput.setText("");
                    }
                    else
                    {
                        Toast.makeText(getActivity(), "DataEntry Unsuccessfull", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
