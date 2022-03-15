package com.example.namanamapahlawan;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DaftarPahlawanAdapter extends RecyclerView.Adapter<DaftarPahlawanAdapter.DaftarPahlawanHolder>{

    Activity activity;
    List<biodatapahlawan> pahlawannya;

    public DaftarPahlawanAdapter(Activity activity, List<biodatapahlawan> pahlawannya) {
        this.activity = activity;
        this.pahlawannya = pahlawannya;
    }

    @NonNull
    @Override
    public DaftarPahlawanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.rv_item,parent,false);
        return new DaftarPahlawanHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DaftarPahlawanHolder holder, int position) {
        holder.txtNama.setText(pahlawannya.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent paket=new Intent(activity,DetailActivity.class);
                paket.putExtra("orang",pahlawannya.get(position));
                view.getContext().startActivity(paket);
            }
        });


}

    @Override
    public int getItemCount() {
        return pahlawannya.size();
    }

    static class DaftarPahlawanHolder extends RecyclerView.ViewHolder{
        TextView txtNama;
        public DaftarPahlawanHolder(@NonNull View itemView) {
            super(itemView);
            txtNama=(TextView) itemView.findViewById(R.id.txt_name_rv);
        }
    }
}
