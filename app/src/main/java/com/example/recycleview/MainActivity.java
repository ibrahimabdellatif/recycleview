package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    ArrayList<ExampleItem> exampleList = new ArrayList<>();
    //adapter is the bridge between data and recycle view
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        exampleList.add(new ExampleItem(R.drawable.ic_android , "Line 1" , "Line 2"));
        exampleList.add(new ExampleItem(R.drawable.ic_watch , "Line 3" , "Line 4"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun , "Line 5" , "Line 6"));
        exampleList.add(new ExampleItem(R.drawable.ic_android , "Line 1" , "Line 2"));
        exampleList.add(new ExampleItem(R.drawable.ic_watch , "Line 3" , "Line 4"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun , "Line 5" , "Line 6"));
        exampleList.add(new ExampleItem(R.drawable.ic_android , "Line 1" , "Line 2"));
        exampleList.add(new ExampleItem(R.drawable.ic_watch , "Line 3" , "Line 4"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun , "Line 5" , "Line 6"));
        exampleList.add(new ExampleItem(R.drawable.ic_android , "Line 1" , "Line 2"));
        exampleList.add(new ExampleItem(R.drawable.ic_watch , "Line 3" , "Line 4"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun , "Line 5" , "Line 6"));

        buildRecycleView();
    }
    public void buildRecycleView(){
        mRecyclerView = findViewById(R.id.re);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}