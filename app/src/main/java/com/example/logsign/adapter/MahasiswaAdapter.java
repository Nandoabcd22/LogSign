package com.example.logsign.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logsign.R;
import com.example.logsign.models.Mahasiswa;
import com.example.logsign.models.Mahasiswa;

import java.util.ArrayList;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder> {
    private ArrayList<Mahasiswa> datalist;

    public MahasiswaAdapter(ArrayList<Mahasiswa> datalist){
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_item, parent, false);
        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position) {
        holder.txtNama.setText(datalist.get(position).getNama());
        holder.txtNpm.setText(datalist.get(position).getNpm());
        holder.txtNohp.setText(datalist.get(position).getNohp());
    }

    @Override
    public int getItemCount() {
        return (datalist != null) ? datalist.size() : 0;
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNama, txtNpm, txtNohp;

        public MahasiswaViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama_mahasiswa);
            txtNpm = (TextView) itemView.findViewById(R.id.txt_npm_mahasiswa);
            txtNohp = (TextView) itemView.findViewById(R.id.txt_noHp_mahasiswa);
        }
    }
}
