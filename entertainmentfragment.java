package com.examplenishad.NewsApp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class entertainmentfragment extends Fragment {

    String api="3522919be8394f4cb34d7da5418952cb";
    ArrayList<modelclass> modelclassArrayList;
    Adapter adapter;
    String country="in";
    private RecyclerView recyclerViewentertainment;
    private String category="entertainment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.entertainmentfragment,null);

        recyclerViewentertainment=v.findViewById(R.id.recyclerviewentertainment);
        modelclassArrayList=new ArrayList<>();
        recyclerViewentertainment.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Adapter(getContext(),modelclassArrayList);
        recyclerViewentertainment.setAdapter(adapter);

        findNews();

        return v;
    }

    private void findNews() {

        apiutilities.getapiInterface().getCategoryNews(country,category,100,api).enqueue(new Callback<news>() {
            @Override
            public void onResponse(Call<news> call, Response<news> response) {
                if(response.isSuccessful())
                {
                    modelclassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<news> call, Throwable t) {

            }
        });
    }
}
