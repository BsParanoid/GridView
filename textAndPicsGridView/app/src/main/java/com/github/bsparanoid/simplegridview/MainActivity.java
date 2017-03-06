package com.github.bsparanoid.simplegridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    GridView _grid;
    String[] _descriptionText = {
            "logo_1", "logo_2", "logo_3", "logo_4",
            "logo_5", "logo_6", "logo_7", "logo_8",
            "logo_9", "logo_10", "logo_11", "logo_1",
            "logo_2", "logo_3", "logo_4", "logo_5",
            "logo_6", "logo_7", "logo_8", "logo_9",
            "logo_10", "logo_11", "logo_1", "logo_2",
            "logo_3", "logo_4", "logo_5", "logo_6",
            "logo_7", "logo_8", "logo_9", "logo_10",
            "logo_11", "logo_1", "logo_2", "logo_3",
            "logo_4", "logo_5", "logo_6", "logo_7",
            "logo_8", "logo_9", "logo_10", "logo_11",
            "logo_1", "logo_2", "logo_3", "logo_4",
            "logo_5", "logo_6", "logo_7", "logo_8",
            "logo_9", "logo_10", "logo_11", "logo_1",
            "logo_2", "logo_3", "logo_4", "logo_5",
            "logo_6", "logo_7", "logo_8", "logo_9",
            "logo_10", "logo_11", "logo_1", "logo_2"
    } ;

    public Integer[] _ThumbIds = {
            R.drawable.logo_1, R.drawable.logo_2, R.drawable.logo_3, R.drawable.logo_4,
            R.drawable.logo_5, R.drawable.logo_6, R.drawable.logo_7, R.drawable.logo_8,
            R.drawable.logo_9, R.drawable.logo_10, R.drawable.logo_11, R.drawable.logo_1,
            R.drawable.logo_2, R.drawable.logo_3, R.drawable.logo_4, R.drawable.logo_5,
            R.drawable.logo_6, R.drawable.logo_7, R.drawable.logo_8, R.drawable.logo_9,
            R.drawable.logo_10, R.drawable.logo_11, R.drawable.logo_1, R.drawable.logo_2,
            R.drawable.logo_3, R.drawable.logo_4, R.drawable.logo_5, R.drawable.logo_6,
            R.drawable.logo_7, R.drawable.logo_8, R.drawable.logo_9, R.drawable.logo_10,
            R.drawable.logo_11, R.drawable.logo_1, R.drawable.logo_2, R.drawable.logo_3,
            R.drawable.logo_4, R.drawable.logo_5, R.drawable.logo_6, R.drawable.logo_7,
            R.drawable.logo_8, R.drawable.logo_9, R.drawable.logo_10, R.drawable.logo_11,
            R.drawable.logo_1, R.drawable.logo_2, R.drawable.logo_3, R.drawable.logo_4,
            R.drawable.logo_5, R.drawable.logo_6, R.drawable.logo_7, R.drawable.logo_8,
            R.drawable.logo_9, R.drawable.logo_10, R.drawable.logo_11, R.drawable.logo_1,
            R.drawable.logo_2, R.drawable.logo_3, R.drawable.logo_4, R.drawable.logo_5,
            R.drawable.logo_6, R.drawable.logo_7, R.drawable.logo_8, R.drawable.logo_9,
            R.drawable.logo_10, R.drawable.logo_11, R.drawable.logo_1, R.drawable.logo_2
    };
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageAdapter adapter = new ImageAdapter(MainActivity.this, _descriptionText, _ThumbIds);
        _grid=(GridView)findViewById(R.id.simpleGrid);
        _grid.setAdapter(adapter);
        _grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "You Clicked at " +_descriptionText[+ position], Toast.LENGTH_SHORT).show();

            }
        });
    }
}
