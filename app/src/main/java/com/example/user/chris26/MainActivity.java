package com.example.user.chris26;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    private MyAdapter myAdapter;
    private MyAdapter2 myAdapter2;
    private int[] xmass = {R.drawable.xmas1,R.drawable.xmas2,
            R.drawable.xmas3,R.drawable.xmas4,R.drawable.xmas5,
            R.drawable.xmas6,R.drawable.xmas7,R.drawable.xmas8,
            R.drawable.xmas9,R.drawable.xmas10};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView)findViewById(R.id.gridView);
        initGridView();
    }
    private void initGridView(){
        myAdapter = new MyAdapter(this);
        myAdapter2 = new MyAdapter2(this);

        gridView.setAdapter(myAdapter2);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.v("brad", "i = " +i);
            }
        });
    }
//    public void change(View v){
//        if()
//    }
    private class MyAdapter extends BaseAdapter {
        private Context context;
        MyAdapter(Context context){this.context = context;}
        @Override
        public int getCount() {
            return xmass.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView img;
            if(view == null){
                img = new ImageView(context);
                img.setLayoutParams(new GridView.LayoutParams(185, 185));
                img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }else {
                img = (ImageView)view;
            }
            img.setImageResource(xmass[i]);
            return img;
        }

    }
    private class MyAdapter2 extends BaseAdapter {
        private Context context;

        MyAdapter2(Context context) {this.context = context;}

        @Override
        public int getCount() {return xmass.length;}

        @Override
        public Object getItem(int i) {return null;}

        @Override
        public long getItemId(int i) {return 0;}

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null){
                view = LayoutInflater.from(context).inflate(R.layout.layout_item,null);
            }
            ImageView img = (ImageView)view.findViewById(R.id.item_img);
            TextView title = (TextView)view.findViewById(R.id.item_title);

            img.setImageResource(xmass[i]);
            title.setText("X'mas " +i);
            if (i%4==0 || i%4==3){
                view.setBackgroundColor(Color.BLACK);
            }
            return view;
        }
    }
}
