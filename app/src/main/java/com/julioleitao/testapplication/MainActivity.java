package com.julioleitao.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> values;
    ListView listView;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        values = new ArrayList<String>();

        values.add("Julio");
        values.add("João");
        values.add("Pedro");
        values.add("Maria");
        values.add("Sara");

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,values);

        listView = (ListView) findViewById(R.id.listView);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        listView.setAdapter(adapter);
    }
    public void showSelected(View view)
    {
        String selected = "";
        int len = listView.getCount();
        SparseBooleanArray checked = listView.getCheckedItemPositions();
        for (int i = 0; i < len; i++)
        {
            if (checked.get(i)) {
                String item = values.get(i);
                selected = selected+" "+item;
            }
        }

        Toast.makeText(getApplicationContext(),"Selected:"+selected,Toast.LENGTH_LONG).show();
  /* do whatever you want with the checked item */


    }
}
