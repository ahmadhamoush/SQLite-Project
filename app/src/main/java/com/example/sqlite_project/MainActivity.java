package com.example.sqlite_project;

import androidx.appcompat.app.AppCompatActivity;


import android.database.Cursor;
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
        //where the exams will be stored
         ArrayList exams = new ArrayList<>();
         //getting list view
        ListView listView = (ListView) findViewById(R.id.exams_list);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, exams);
        listView.setAdapter(adapter);

        try{
            //creating local db
            SQLiteDatabase sql = this.openOrCreateDatabase("examsDB", MODE_PRIVATE, null);
            //inserting exams into db
            sql.execSQL("CREATE Table IF NOT EXISTS  exams (name VARCHAR, date Date)");
            sql.execSQL("INSERT INTO exams(name,date) VALUES('Mobile Computing','09-05-2022')");
            sql.execSQL("INSERT INTO exams(name,date) VALUES('Natural Language Processing','12-05-2022')");
            sql.execSQL("INSERT INTO exams(name,date) VALUES('Intro to Bioinformatics','10-05-2022')");
            //getting exam details
            Cursor cursor = sql.rawQuery("SELECT * FROM exams", null);
            int exam_name = cursor.getColumnIndex("name");
            int exam_date = cursor.getColumnIndex("date");
            cursor.moveToFirst();
            //displaying exams list
            while (cursor != null) {
                String exam = "Exam: " +  cursor.getString(exam_name) + "\nDate:  " + cursor.getString(exam_date);
                exams.add(exam);
                cursor.moveToNext();
            }

            listView.setAdapter(adapter);

        }catch(
                Exception e)

        {
            e.printStackTrace();
        }
    }
}