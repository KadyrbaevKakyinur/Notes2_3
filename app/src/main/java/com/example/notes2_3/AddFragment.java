package com.example.notes2_3;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddFragment extends Fragment {

    private String imageUri;
    EditText title;
    EditText date;
    EditText desc;

    AppCompatButton save;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        save = view.findViewById(R.id.save);
        title = view.findViewById(R.id.edit_title);
        date = view.findViewById(R.id.edit_date);
        desc = view.findViewById(R.id.edit_description);
        Bundle bundle = new Bundle();

        if (getArguments() != null) {
            save.setText("Edit");
            Note note = (Note) getArguments().getSerializable("editNote");
            title.setText(note.getTitle());
            desc.setText(note.getDesc());
            save.setOnClickListener(view1 -> {
                int position = getArguments().getInt("position");
                bundle.putInt("position", position);

                String _titleEdit = title.getText().toString();
                String _descEdit = desc.getText().toString();
                String _dateEdit = date.getText().toString();
                Note editNote = new Note("", _titleEdit, _descEdit, _dateEdit);
                bundle.putSerializable("changeNote", editNote);

                requireActivity().getSupportFragmentManager().setFragmentResult("edit", bundle);
                requireActivity().getSupportFragmentManager().popBackStack();
            });
        } else {
            save.setOnClickListener(v -> {
                Toast.makeText(requireActivity(), "Ура", Toast.LENGTH_SHORT).show();
                String _title = title.getText().toString();
                String _desc = desc.getText().toString();
                String _date = date.getText().toString();
                Note note = new Note("", _title, _desc, _date);
                bundle.putSerializable("model", note);

                requireActivity().getSupportFragmentManager().setFragmentResult("note", bundle);
                requireActivity().getSupportFragmentManager().popBackStack();
            });
        }

    }
/*
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        imageUri = data.getDataString();
    }*/
}