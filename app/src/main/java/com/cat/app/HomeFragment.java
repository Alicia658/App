package com.cat.app;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {
    private EditText etBreed;
    private RecyclerView breedsRv;
    private ArrayList<Breed> list = new ArrayList<>();
    private BreedAdapter adapter;
    private View ivBreed;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.search,container,false);
        etBreed = view.findViewById(R.id.et_breed);
        breedsRv = view.findViewById(R.id.breeds);
        ivBreed = view.findViewById(R.id.iv_breed);
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
        ivBreed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String breed = etBreed.getText().toString();
                if (!TextUtils.isEmpty(breed)) {
                    loadBreed(breed);
                }
            }
        });
    }

    private void loadBreed(String breed){
        Response.Listener<String> response = new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                Breed[] breeds = new Gson().fromJson(response, Breed[].class);
                List<Breed> breedList = Arrays.asList(breeds);
                list.clear();
                for (Breed bree : breedList) {
                    list.add(bree);
                }
                adapter.notifyDataSetChanged();
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://api.thecatapi.com/v1/breeds/search"+"?q="+breed,
                response, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(),"Error",Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(stringRequest);
    }
}
