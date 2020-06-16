package com.example.roversguide2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toolbar;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.MapStyleOptions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    RecyclerView recyclerView;
    List<Model> main_list;
    CustomAdapter adapter;
    MapView mapView;


    //Toolbar toolbar;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        //MapView
        //mapView.getMapAsync(this);
        //mapView=findViewById(R.id.map);
        //mapView.getMapAsync(this);






        //toolbar=findViewById(R.id.menu_item);
        main_list= new ArrayList<>();
        recyclerView=findViewById(R.id.stateList);
        String[] names= getResources().getStringArray(R.array.state_titles);
        String[] content=getResources().getStringArray(R.array.state_contents);
        String[] sHead=getResources().getStringArray(R.array.state_part1);
        String[] cContent=getResources().getStringArray(R.array.city_content);
        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        main_list.add(new Model(R.drawable.pb,"Andra Pradesh"));
        main_list.add(new Model(R.drawable.pb,"Arunachal Pradesh"));
        main_list.add(new Model(R.drawable.pb,"Assam"));
        main_list.add(new Model(R.drawable.pb,"Bihar"));
        main_list.add(new Model(R.drawable.pb,"Chandigarh"));
        main_list.add(new Model(R.drawable.pb,"Chattishgarh"));
        main_list.add(new Model(R.drawable.pb,"Delhi"));
        main_list.add(new Model(R.drawable.pb,"Goa"));
        main_list.add(new Model(R.drawable.pb,"Gujarat"));
        main_list.add(new Model(R.drawable.pb,"Haryana"));
        main_list.add(new Model(R.drawable.pb,"Himachal Pradesh"));
        main_list.add(new Model(R.drawable.pb,"Jammu & Kashmir"));
        main_list.add(new Model(R.drawable.pb,"Kerala"));
        main_list.add(new Model(R.drawable.pb,"Madhya Pradesh"));
        main_list.add(new Model(R.drawable.pb,"Maharashtra"));
        main_list.add(new Model(R.drawable.pb,"Manipur"));
        main_list.add(new Model(R.drawable.pb,"Nagaland"));
        main_list.add(new Model(R.drawable.pb,"Odisha"));
        main_list.add(new Model(R.drawable.pb,"Punjab"));
        adapter=new CustomAdapter(main_list,getApplicationContext(),names,content,sHead,cContent);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_item,menu);


        //getMenuInflater().inflate(R.menu.menu_item,menu);
        //MenuItem item=menu.findItem(R.id.action_search);
       // SearchManager searchManager=(SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView=(SearchView)menu.findItem(R.id.action_search).getActionView();
        //searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        //searchView.setMaxWidth(Integer.MAX_VALUE);
        //searchView.setQueryHint(getString(R.string.search));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText=newText.toLowerCase();
                List<Model> myList=new ArrayList<>();
                for (Model model:main_list){
                    String name=model.getState_name().toLowerCase();
                    if(name.contains(newText))
                        myList.add(model);
                }
                adapter.setSearchOperation(myList);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
/*
    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d("MapDebug","map is showing");
        MapStyleOptions mapStyleOptions=MapStyleOptions.loadRawResourceStyle(this,R.raw.designmap);
        googleMap.setMapStyle(mapStyleOptions);
        //mapView.getMapAsync(this);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        mapView.onCreate(savedInstanceState);


    }

    @Override
    protected void onStart() {

        super.onStart();
        mapView.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }*/
}
