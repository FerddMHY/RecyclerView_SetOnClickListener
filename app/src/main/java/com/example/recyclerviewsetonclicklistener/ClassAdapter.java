package com.example.recyclerviewsetonclicklistener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.MyViewHolder> {
    private ArrayList<User> usersList;
    private RecyclerViewClickListener listener;

    public ClassAdapter(ArrayList<User> usersList, RecyclerViewClickListener listener){
        this.usersList = usersList;
        this.listener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView nameTxt;
        private TextView powerTxt;
        private ImageView imagee;

        public MyViewHolder(final View view){
            super(view);
            nameTxt = view.findViewById(R.id.nama);
            powerTxt = view.findViewById(R.id.power);
            imagee = view.findViewById(R.id.imageview);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onCLick(view, getAdapterPosition());
        }
    }


    @NonNull
    @Override
    public ClassAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassAdapter.MyViewHolder holder, int position) {
        String name = usersList.get(position).getUsername();
        String powerr = usersList.get(position).getEmail();
        int imageee = usersList.get(position).getImage();
        holder.nameTxt.setText(name);
        holder.powerTxt.setText(powerr);
        holder.imagee.setImageResource(imageee);

    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public interface RecyclerViewClickListener{
        void onCLick(View v, int position);
    }
}
