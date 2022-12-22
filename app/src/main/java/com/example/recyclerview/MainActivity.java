package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerview.recycler.RecyclerAdapter;
import com.example.recyclerview.recycler.RecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private List<String> RollReycList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rl_newscontent_content_view);
        this.bindRecycleView();
    }


    public void bindRecycleView() {
        RollReycList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            RollReycList.add("" + i);
        }

        //1. 线性布局
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //2. 网格布局
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        //3. 瀑布流
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        this.recyclerAdapter = new RecyclerAdapter<String>(this, RollReycList,
                R.layout.item_address) {
            @Override
            public void convert(RecyclerViewHolder helper, String item, int position) {
            }
        };
        recyclerView.setAdapter(recyclerAdapter);
//        recyclerView.addItemDecoration(new RecyclerItemDecoration(this));

    }

}