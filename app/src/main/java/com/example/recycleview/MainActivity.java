package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ExampleItem> mExampleList;

    //adapter is the bridge between data and recycle view
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button buttonInsert;
    private Button buttonRemove;
    private EditText editTextInsert;
    private EditText editTextRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setButtons();
        createExampleList();
        buildRecycleView();
    }

    public void insertItem(int position) {
        // position before new keyword it give you to insert item to specific position
        mExampleList.add(position, new ExampleItem(R.drawable.ic_android, "insert at position" + position, "this is line 2"));
        // mAdapter.notifyDataSetChanged(); >> this line make a notify for adapter without animations
        mAdapter.notifyItemInserted(position);
    }

    public void removeItem(int position) {
        mExampleList.remove(position);
        // mAdapter.notifyDataSetChanged(); >> notify without animations
        mAdapter.notifyItemRemoved(position);
    }

    public void changeItem(int position, String text) {
        mExampleList.get(position).changeText1(text);
        mAdapter.notifyItemChanged(position);
    }

    public void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem(R.drawable.ic_android, "Line 1", "Line 2"));
        mExampleList.add(new ExampleItem(R.drawable.ic_watch, "Line 3", "Line 4"));
        mExampleList.add(new ExampleItem(R.drawable.ic_sun, "Line 5", "Line 6"));
    }

    public void buildRecycleView() {
        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                changeItem(position, "Clicked");
            }

            @Override
            public void OnDeleteClick(int position) {
                removeItem(position);
            }
        });
    }
    public void setButtons(){
        buttonInsert = findViewById(R.id.button_insert);
        buttonRemove = findViewById(R.id.button_remove);
        editTextInsert = findViewById(R.id.edittext_insert);
        editTextRemove = findViewById(R.id.edittext_remove);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextInsert.getText().toString());
                insertItem(position);
            }
        });

        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextRemove.getText().toString());
                removeItem(position);
            }
        });
    }
}