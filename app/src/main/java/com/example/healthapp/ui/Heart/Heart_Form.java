package com.example.healthapp.ui.Heart;

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

public class Heart_Form extends Fragment {

    private HeartViewModel mViewModel;

    // Reading Input
    EditText heartInput;

    public static Heart newInstance() {
        return new Heart();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {



        View view =  inflater.inflate(R.layout.fragment_heart__form, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HeartViewModel.class);
        // TODO: Use the ViewModel

        heartInput = getView().findViewById(R.id.heartInput);
        Button button = getView().findViewById(R.id.submitBtn);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(heartInput.getText() != null)
                {
                    Log.d("Heart", heartInput.getText().toString());
                    boolean success = mViewModel.saveHeart(heartInput.getText().toString(), getActivity().getApplicationContext());
                    if(success == true)
                    {
                        heartInput.setText("");
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
