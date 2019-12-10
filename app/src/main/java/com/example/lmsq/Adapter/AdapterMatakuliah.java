package com.example.lmsq.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lmsq.Model.MatakuliahModel;
import com.example.lmsq.R;

import java.util.List;

public class AdapterMatakuliah extends RecyclerView.Adapter<AdapterMatakuliah.MyViewHolder> {
    List<MatakuliahModel> matakuliahList;

    public AdapterMatakuliah(List<MatakuliahModel> matakuliahList) {
        this.matakuliahList = matakuliahList;
    }

    @NonNull
    @Override
    public AdapterMatakuliah.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View matakuliahView = layoutInflater.inflate(R.layout.cardmatakuliah,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(matakuliahView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMatakuliah.MyViewHolder holder, int position) {
        //ambil satu item hero
        MatakuliahModel mk = matakuliahList.get(position);
        //set text heroName berdasarkan data dari model hero
        holder.matakuliahname.setText(mk.getMatakuliah());
    }

    @Override
    public int getItemCount()    {
        return matakuliahList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView matakuliahname;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            matakuliahname = itemView.findViewById(R.id.Mk);
        }
    }
}
