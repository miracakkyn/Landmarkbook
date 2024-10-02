package com.miracakkoyun.landmarkbook;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.miracakkoyun.landmarkbook.databinding.RecylerRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder> {
    ArrayList<Landmark> landmarkArrayList;

    public LandmarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }

    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecylerRowBinding recylerRowBinding=RecylerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LandmarkHolder(recylerRowBinding);
        //xml i bağlama işlemi burada yapıacak
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarkHolder holder, int position) {
        //layout içinde hangi verileri göstermek istiyorsak orda tutacağımız sınıf
        holder.binding.recylerViewTextView.setText(landmarkArrayList.get(position).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(holder.itemView.getContext(),DetailsActivity.class);
                intent.putExtra("landmark",landmarkArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        //xmlin kaç kere oluşturulacağını söyler
        return landmarkArrayList.size();
    }

    public class LandmarkHolder extends RecyclerView.ViewHolder{
        private RecylerRowBinding binding;

    //görünümlerimizi tutacak sınıf
        public LandmarkHolder(RecylerRowBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

}
