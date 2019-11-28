package com.example.healthapp.ui.CompleteBloodCount;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.healthapp.Modal.CompleteBloodCountModal;
import com.example.healthapp.R;


public class CompleteBloodCountForm extends Fragment {
    private CompleteBloodCountViewModel mViewModel;
    public CompleteBloodCountModal completeBloodCountModal;
    // All Readings input
    private EditText haemoglobin;
    private EditText haematocrit;
    private EditText RBC;
    private EditText MCV;
    private EditText MCH;
    private EditText MCHC;
    private EditText WBC;
    private EditText Neutrophils;
    private EditText Lymghocytes;
    private EditText eosinophils;
    private EditText Monocytes;
    private EditText Basophil;
    private Button submitButton;




    public static CompleteBloodCount newInstance() {
        return new CompleteBloodCount();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_complete_blood_count_form, container, false);

        haemoglobin = view.findViewById(R.id.Haemoglobin);
        haematocrit = view.findViewById(R.id.Hematocrit);
        RBC = view.findViewById(R.id.RBC);
        MCV = view.findViewById(R.id.MCV);
        MCH = view.findViewById(R.id.MCH);
        MCHC = view.findViewById(R.id.MCHC);
        WBC = view.findViewById(R.id.WBC);
        Neutrophils = view.findViewById(R.id.Neutrophils);
        Lymghocytes = view.findViewById(R.id.Lymghocytes);
        eosinophils = view.findViewById(R.id.Eosinophils);
        Monocytes = view.findViewById(R.id.Monocytes);
        Basophil = view.findViewById(R.id.Basophil);

        submitButton = view.findViewById(R.id.submitBtn);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(CompleteBloodCountViewModel.class);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkInputNotEmpty()) {
                    setCompleteBloodCountModal();

                    if (mViewModel.saveCompleteBloodCount(completeBloodCountModal, getActivity().getApplicationContext())) {
                        Toast.makeText(getActivity(), "Date Entered Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "Date Entered Unsuccessfully", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(getActivity(), "Field Empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // TODO: Use the ViewModel
    }

    private boolean checkInputNotEmpty() {

        if( haemoglobin.getText().toString().trim().equals("") ||
                haematocrit.getText().toString().trim().equals("") ||
                RBC.getText().toString().trim().equals("") ||
                MCV.getText().toString().trim().equals("") ||
                MCH.getText().toString().trim().equals("") ||
                MCHC.getText().toString().trim().equals("") ||
                WBC.getText().toString().trim().equals("") ||
                Neutrophils.getText().toString().trim().equals("") ||
                Lymghocytes.getText().toString().trim().equals("") ||
                eosinophils.getText().toString().trim().equals("") ||
                Monocytes.getText().toString().trim().equals("") ||
                Basophil.getText().toString().trim().equals("")){

            return false;

        }
        return true;
    }

    private void setCompleteBloodCountModal(){

        completeBloodCountModal = new CompleteBloodCountModal();

        completeBloodCountModal.setHaemoglobin(Double.parseDouble(haemoglobin.getText().toString().trim()));
        completeBloodCountModal.setHaematocrit(Double.parseDouble(haematocrit.getText().toString().trim()));
        completeBloodCountModal.setRBC(Double.parseDouble(RBC.getText().toString().trim()));
        completeBloodCountModal.setMCV(Double.parseDouble(MCV.getText().toString().trim()));
        completeBloodCountModal.setMCH(Double.parseDouble(MCH.getText().toString().trim()));
        completeBloodCountModal.setMCHC(Double.parseDouble(MCHC.getText().toString().trim()));
        completeBloodCountModal.setWBC(Double.parseDouble(WBC.getText().toString().trim()));
        completeBloodCountModal.setNeutrophils(Double.parseDouble(Neutrophils.getText().toString().trim()));
        completeBloodCountModal.setLymghocytes(Double.parseDouble(Lymghocytes.getText().toString().trim()));
        completeBloodCountModal.setEosinophils(Double.parseDouble(eosinophils.getText().toString().trim()));
        completeBloodCountModal.setMonocytes(Double.parseDouble(Monocytes.getText().toString().trim()));
        completeBloodCountModal.setBasophil(Double.parseDouble(Basophil.getText().toString().trim()));
    }
}
