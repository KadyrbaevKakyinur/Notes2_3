package com.example.notes2_3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MainFragment extends Fragment {

    Button add;
    Button sort;
    EditText editText;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       add = view.findViewById(R.id.add);
       add.setOnClickListener(v->{
           requireActivity().getSupportFragmentManager()
                   .beginTransaction()
                   .replace(R.id.main_container,new AddFragment())
                   .commit();
       });

       sort= view.findViewById(R.id.sort);
       sort.setOnClickListener(v->{

           String title= editText.getText().toString();
           AddFragment addFragment = new AddFragment();
           Bundle bundle = new Bundle();
           bundle.putString("text",title);
           addFragment.setArguments(bundle);
           requireActivity().getSupportFragmentManager()
                   .beginTransaction()
                   .replace(R.id.main_container,addFragment)
                   .commit();
       });


    }


}