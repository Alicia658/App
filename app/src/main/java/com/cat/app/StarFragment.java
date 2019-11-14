package com.cat.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StarFragment extends Fragment {
    private RecyclerView breedsRv;
    private BreedAdapter adapter;
    private List<Breed> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fav_list,container,false);
        breedsRv = view.findViewById(R.id.breeds);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager ll = new LinearLayoutManager(getActivity());
        ll.setOrientation(RecyclerView.VERTICAL);
        breedsRv.setLayoutManager(ll);
        adapter = new BreedAdapter(getActivity(),list);
        breedsRv.setAdapter(adapter);

    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sp = getActivity().getSharedPreferences("Breed", Context.MODE_PRIVATE);
        String breeds = sp.getString("breed","");
        String[] arr = breeds.split("#");
        list.clear();
        for (int i = 0; i < arr.length; i++) {
            String fav = arr[i];
            if (!TextUtils.isEmpty(fav)){
                String[] favArr = fav.split("-");
                Log.e("f",fav);
                Breed breed =  new Breed();
                breed.setId(favArr[0]);
                breed.setName(favArr[1]);
                list.add(breed);
            }


        }
        adapter.notifyDataSetChanged();
    }
}
