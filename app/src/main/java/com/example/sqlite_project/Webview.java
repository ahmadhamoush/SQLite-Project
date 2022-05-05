package com.example.sqlite_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Webview extends AppCompatActivity {

    WebView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        view = (WebView) findViewById(R.id.webview);
        view.getSettings().setJavaScriptEnabled(true);
        view.setWebViewClient( new WebViewClient());
        view.loadUrl("https://www.lau.edu.lb");

    }
}