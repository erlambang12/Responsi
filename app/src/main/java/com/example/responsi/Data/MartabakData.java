package com.example.responsi.Data;

import com.example.responsi.Model.Martabak;
import com.example.responsi.R;

import java.util.ArrayList;

public class MartabakData {
    private  static String [] name = {
            "Martabak Manis",
            "Martabak Asin"
    };
    private static  String [] rating = {
            "7.3",
            "7.5",
    };
    private static String [] price = {
            "Rp. 20.000",
            "Rp. 20.000"
    };
    private  static  int [] image = {
            R.drawable.asin,
            R.drawable.manis,
    };
    public static ArrayList<Martabak> getListData(){
        ArrayList<Martabak> list = new ArrayList<>();
        for (int position = 0 ; position < name.length; position++){
            Martabak martabak = new Martabak();
            martabak.setRating(rating[position]);
            martabak.setMartabak_name(name[position]);
            martabak.setPrice(price[position]);
            martabak.setImage(image[position]);
            list.add(martabak);
        }
        return list;
    }
}
