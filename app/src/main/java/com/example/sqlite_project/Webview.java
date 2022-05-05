package com.example.sqlite_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Webview extends AppCompatActivity {

    WebView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        //getting view
        view = (WebView) findViewById(R.id.webview);
        //web view options
        view.getSettings().setJavaScriptEnabled(true);
        view.setWebViewClient( new WebViewClient());
        //getting exam name from main activity
        String course_name = getIntent().getStringExtra("course_name");
        Log.d("Exam Received", course_name);
        //loading website based on exam clicked
        if(course_name.trim().equals("Mobile Computing")){
            view.loadUrl("https://developer.android.com/studio");
        }else if (course_name.trim().equals("Natural Language Processing")){
            view.loadUrl("https://www.ibm.com/cloud/learn/natural-language-processing");
        }
        else if (course_name.trim().equals("Intro to Bioinformatics")){
            view.loadUrl("https://pubmed.ncbi.nlm.nih.gov/24272431/");
        }


    }
}