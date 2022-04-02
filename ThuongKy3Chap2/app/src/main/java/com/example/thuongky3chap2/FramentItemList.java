package com.example.thuongky3chap2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;

public class FramentItemList extends Fragment {
    ArrayList<Product> arrayProduct;
    ItemAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        arrayProduct = new ArrayList<>();
        AddArraySV();
        adapter = new ItemAdapter(getActivity(),R.layout.row_item,arrayProduct);

        return inflater.inflate(R.layout.fragment_item_list,container,false);
    }
    
}
