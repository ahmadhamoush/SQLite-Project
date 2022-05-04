package com.example.sqlite_project;

import androidx.appcompat.app.AppCompatActivity;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         ArrayList data = new ArrayList<>();

        ListView listView = (ListView) findViewById(R.id.exams_list);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, data);

        listView.setAdapter(adapter);


        try{

            SQLiteDatabase sql = this.openOrCreateDatabase("examsDB", MODE_PRIVATE, null);
            sql.execSQL("CREATE Table IF NOT EXISTS  exams (name VARCHAR, date Date)");
            sql.execSQL("INSERT INTO exams(name,date) VALUES('Mobile Computing','09-05-2022')");
            sql.execSQL("INSERT INTO exams(name,date) VALUES('Natural Language Processing','12-05-2022')");
            sql.execSQL("INSERT INTO exams(name,date) VALUES('Intro to Bioinformatics','10-05-2022')");
        


            listView.setAdapter(adapter);

        }catch(
                Exception e)

        {
            e.printStackTrace();
        }
    }
}