package com.example.responsi.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.responsi.Model.Martabak;
import com.example.responsi.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MartabakAdapter extends RecyclerView.Adapter<MartabakAdapter.ListViewHolder> {
    private final ArrayList<Martabak> listMartabak;
    private OnItemClickCallback onItemClickCallback;


    public MartabakAdapter(ArrayList<Martabak> listMartabak) {
        this.listMartabak = listMartabak;
        this.onItemClickCallback = onItemClickCallback;

    }

    @NonNull
    @NotNull
    @Override
    public MartabakAdapter.ListViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.martabak_item, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MartabakAdapter.ListViewHolder holder, int position) {
        Martabak martabak = listMartabak.get(position);
        Glide.with(holder.itemView.getContext())
                .load(martabak.getImage())
                .apply(new RequestOptions())
                .into(holder.img_martabak);
        holder.name.setText(martabak.getMartabak_name());
        holder.price.setText(martabak.getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listMartabak.get(holder.getAdapterPosition()));

            }
        });
    }

    @Override
    public int getItemCount() { return listMartabak.size();}

        public class ListViewHolder extends RecyclerView.ViewHolder {
            ImageView img_martabak;
            TextView name, price;

            public ListViewHolder(@NonNull @NotNull View itemView) {
                super(itemView);

                img_martabak = itemView.findViewById(R.id.img_martabak);
                name = itemView.findViewById(R.id.martabak_name);
                price = itemView.findViewById(R.id.price);
            }
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Martabak data);
    }
}
