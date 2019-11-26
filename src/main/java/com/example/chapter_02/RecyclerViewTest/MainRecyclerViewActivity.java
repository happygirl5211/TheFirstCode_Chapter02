package com.example.chapter_02.RecyclerViewTest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.chapter_02.ListViewTest.Fruit;
import com.example.chapter_02.R;

import java.util.ArrayList;
import java.util.List;

public class MainRecyclerViewActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recycler_view);

        //初始化水果数据
        initFruits();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //LayoutManager用于指定RecyclerView的布局方式，这里使用LineatLayoutManager线性布局
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adatpter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adatpter);
    }

    private void initFruits(){
        for(int i = 0; i < 2; i++){
            Fruit apple = new Fruit("Apple", R.drawable.apple);
            fruitList.add(apple);

            Fruit banana = new Fruit("Banana", R.drawable.banana);
            fruitList.add(banana);

            Fruit orange = new Fruit("Orange", R.drawable.orange);
            fruitList.add(orange);

            Fruit watarmelon = new Fruit("Watermelon", R.drawable.watermelon);
            fruitList.add(watarmelon);

            Fruit cherry = new Fruit("Cherry", R.drawable.cherry);
            fruitList.add(cherry);

            Fruit grape = new Fruit("Grape", R.drawable.grape);
            fruitList.add(grape);

            Fruit mango = new Fruit("Mango", R.drawable.mango);
            fruitList.add(mango);

            Fruit pear = new Fruit("Pear", R.drawable.pear);
            fruitList.add(pear);

            Fruit pineapplle = new Fruit("Pineapple", R.drawable.pineapple);
            fruitList.add(pineapplle);

            Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry);
            fruitList.add(strawberry);
        }
    }
}
