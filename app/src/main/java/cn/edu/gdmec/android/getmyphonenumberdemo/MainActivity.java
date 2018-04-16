package cn.edu.gdmec.android.getmyphonenumberdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //声明一个ListView
    private ListView lv;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetNumber.getNumber(this);
        lv = findViewById(R.id.lv);
        adapter = new MyAdapter(GetNumber.lists,this);
        lv.setAdapter(adapter);
    }
}
