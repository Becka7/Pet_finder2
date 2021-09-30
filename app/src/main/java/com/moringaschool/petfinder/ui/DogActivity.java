package com.moringaschool.petfinder.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.petfinder.network.Api;
import com.moringaschool.petfinder.modules.PetSearchResponse;
import com.moringaschool.petfinder.R;
import com.moringaschool.petfinder.adapters.Adapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DogActivity extends AppCompatActivity  {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;


    private Adapter adapter;
    private List<PetSearchResponse> images;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog);
        ButterKnife.bind(this);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<PetSearchResponse>> call = api.getPets();

        call.enqueue(new Callback<List<PetSearchResponse>>() {
            @Override
            public void onResponse(Call<List<PetSearchResponse>> call, Response<List<PetSearchResponse>> response) {
                List<PetSearchResponse> petSearchResponses = response.body();
                images = response.body();
                RecyclerView recyclerView = findViewById(R.id.recyclerView);
                Adapter adapter = new Adapter(DogActivity.this, images);
                StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
                mRecyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<PetSearchResponse>> call, Throwable t) {
                Toast.makeText(DogActivity.this, "Error Occurred", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        ButterKnife.bind(this);


        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                adapter.getFilter().filter(s);
                return false;
            }
        });


        return true;
    }

}