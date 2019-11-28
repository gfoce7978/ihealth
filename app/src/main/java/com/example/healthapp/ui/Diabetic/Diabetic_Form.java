package com.example.healthapp.ui.Diabetic;

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


public class Diabetic_Form extends Fragment {
    private DiabeticViewModel mViewModel;

    // Reading Input
    EditText diabeticInput;

    public static Diabetic newInstance() {
        return new Diabetic();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {



        View view =  inflater.inflate(R.layout.fragment_diabetic__form, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DiabeticViewModel.class);
        // TODO: Use the ViewModel

        diabeticInput = getView().findViewById(R.id.diabeticInput);
        Button button = getView().findViewById(R.id.submitBtn);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(diabeticInput.getText() != null)
                {
                    Log.d("Diabetic", diabeticInput.getText().toString());
                    boolean success = mViewModel.saveDiabetic(diabeticInput.getText().toString(), getActivity().getApplicationContext());
                    if(success == true)
                    {
                        diabeticInput.setText("");
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
