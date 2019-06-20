package com.example.atulc.red;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.atulc.blackspot_sih.R;

import java.io.FileReader;

public class RegisterFragment extends Fragment {
    EditText nameedittext;
    EditText emailedittext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.registration_fragment_layout,container,false);


        RelativeLayout relativeLayout = view.findViewById(R.id.fragment_main_layout);
        relativeLayout.clearFocus();

        nameedittext = view.findViewById(R.id.name_edit_text);
        emailedittext = view.findViewById(R.id.email_id_edit_text);

        Spinner blood_select_spinner = view.findViewById(R.id.select_blood_spinner);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getContext(),R.array.blood_types,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        blood_select_spinner.setAdapter(arrayAdapter);

        Button done_btn_register_fragment = (Button)view.findViewById(R.id.done_btn_register_fragment);
        done_btn_register_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nameedittext.getText().toString()!=null && emailedittext.getText().toString()!=null) {

                    Toast.makeText(getContext(), "Your Values Are adding in database", Toast.LENGTH_SHORT).show();
                }
                else{

                    Toast.makeText(getContext(),"Please enter the name and email",Toast.LENGTH_SHORT).show();
                }

            }
        });



        return view;
    }
}
