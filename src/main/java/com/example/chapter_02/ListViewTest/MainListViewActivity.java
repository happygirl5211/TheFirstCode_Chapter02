package com.example.chapter_02.ListViewTest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.chapter_02.R;

import java.util.ArrayList;
import java.util.List;

public class MainListViewActivity extends AppCompatActivity {

    private String[] data = {"Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple",
                               "Strawberry", "Cherry", "Mango", "Apple", "Banana", "Orange", "Watermelon",
                               "Pear", "Grape", "Pineapple","Strawberry", "Cherry", "Mango"};

    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_view);

        //数组中的数据无法直接传递给ListView,需要借助适配器来完成
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
////                MainListViewActivity.this, android.R.layout.simple_list_item_1, data);//使用了simple_list_item_1作为ListView子项布局的id
////        ListView listView = (ListView) findViewById(R.id.list_view);
////        listView.setAdapter(adapter);

        initFruits();//初始化水果数据
        FruitAdatpter adatpter = new FruitAdatpter(MainListViewActivity.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adatpter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainListViewActivity.this, fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
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
