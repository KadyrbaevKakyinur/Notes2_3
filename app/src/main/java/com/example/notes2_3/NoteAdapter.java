package com.example.notes2_3;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.viewHolder> {

    private List<Note> list = new ArrayList<>();
    private ItemClickListener listener;

    public NoteAdapter(ItemClickListener listener) {
        this.listener = listener;
    }

    public void addNote(Note note) {
        list.add(note);
        notifyDataSetChanged();
    }

    public void changeNote(int position, Note note) {
        list.set(position, note);
        notifyDataSetChanged();
    }
    public Note getItem(int pos) {
        return list.get(pos);
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title;
        private TextView desc;
 //       private EditText date;
        //new
        private ImageView delete;
        private ImageView pen;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_image);
            title = itemView.findViewById(R.id.item_title);
            desc = itemView.findViewById(R.id.item_desc);
  //          date = itemView.findViewById(R.id.edit_date);
            delete = itemView.findViewById(R.id.item_delete);
            pen = itemView.findViewById(R.id.item_pen);
        }


        void bind(int position) {
            title.setText(list.get(position).getTitle());
            desc.setText(list.get(position).getDesc());
 //           date.setText(list.get(position).getDate());
            Glide.with(itemView)
                    .load(list.get(position).getImage())
                    .transform(new CenterCrop(), new RoundedCorners(25))
                    .into(imageView);

            delete.setOnClickListener(v -> {
                list.remove(position);
                notifyItemRemoved(position);
            });
            pen.setOnClickListener(view -> {
                listener.updateNote(position);
            });

        }
    }

    interface ItemClickListener {
        void updateNote(int position);
    }
}
