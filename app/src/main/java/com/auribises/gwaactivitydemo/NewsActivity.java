package com.auribises.gwaactivitydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NewsActivity extends AppCompatActivity {

    WebView webView;
    String url = "http://aajtak.intoday.in/";

    void initWebView(){
        webView = (WebView)findViewById(R.id.webView);

        // Code to show WebPage in WebView
        WebViewClient client = new WebViewClient();
        webView.setWebViewClient(client);
        webView.getSettings().setJavaScriptEnabled(true); // webview supports javascript
        webView.loadUrl(url); // Their must be Internet Connection. You must give a permission in the Manifest File for Internet

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        initWebView();
    }
}
