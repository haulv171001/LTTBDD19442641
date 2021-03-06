package com.example.fragmenttestdemo;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class Fragment1 extends Fragment {
    ArrayList<Product> productArrayList;
    Frament1Adapter frament1Adapter;
    TruyenProduct truyenProduct;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        truyenProduct = (TruyenProduct) getActivity();
        productArrayList = new ArrayList<>();
        AddArrayProduct();
        frament1Adapter = new Frament1Adapter(getActivity(),R.layout.row_product,productArrayList);
        GridView gridView = view.findViewById(R.id.gridviewlist);
        gridView.setAdapter(frament1Adapter);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                truyenProduct.DataProduct(productArrayList.get(position));
            }
        });
        return view;
    }

    private void AddArrayProduct(){
        productArrayList.add(new Product("TH true milk",24000,R.drawable.milk));
        productArrayList.add(new Product("Sting",10000,R.drawable.sting));
        productArrayList.add(new Product("Pepsi",10000,R.drawable.pepsi));
        productArrayList.add(new Product("Coca",10000,R.drawable.coca));
        productArrayList.add(new Product("Nước suối",5000,R.drawable.aqua));
        productArrayList.add(new Product("Bia tiger lon",23000,R.drawable.biatiger));
        productArrayList.add(new Product("Cafe lon",17000,R.drawable.cafe));
    }
}
