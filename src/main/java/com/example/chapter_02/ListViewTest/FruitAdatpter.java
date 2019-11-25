package com.example.chapter_02.ListViewTest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chapter_02.R;

import java.util.List;

public class FruitAdatpter extends ArrayAdapter<Fruit> {

    private int resourceId;

    public FruitAdatpter(@NonNull Context context, int textResourceId, @NonNull List<Fruit> objects) {
        super(context, textResourceId, objects);

        resourceId = textResourceId;
    }

    /**
     * getView()方法在每个子项被滚动到屏幕内的时候会被调用
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);//获取当前项的Fruit实例
        //使用LauyouInflater来为这个子项加载传入的布局,convertView用于将之间加载好的布局进行缓存，以便之后可以进行重用
        View view;
        ViewHolder viewHolder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView)view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = (TextView)view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);//将ViewHolder存储在View中
        }else {
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();//重新获取ViewHolder
        }

        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }

    /**
     * 内部类ViewHolder将用于对控件的实例缓存，
     */
    class ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
    }
}
