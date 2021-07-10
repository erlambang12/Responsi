package com.example.responsi.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsi.Adapter.MartabakAdapter;
import com.example.responsi.Data.MartabakData;
import com.example.responsi.R;
import com.example.responsi.Model.Martabak;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView rv;
    private ArrayList<Martabak> list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rv = view.findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        list.addAll(MartabakData.getListData());
        showRecyclerList();
        return view;
    }
    private void showRecyclerList() {
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        rv.setLayoutManager(mLayoutManager);
        MartabakAdapter shoesAdapter = new MartabakAdapter(list);
        rv.setAdapter(shoesAdapter);

    }
}