package com.example.mywebbrowser;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.net.URL;
import java.util.ArrayList;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    WebView web;
    EditText urlItem;
    ArrayList<URL> history;
    ListIterator<URL> historyIter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = (WebView) findViewById(R.id.webView);
        urlItem = (EditText) findViewById(R.id.editUrl);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
        history = new ArrayList<URL>();
        historyIter = history.listIterator();


    }

    public void go(View v) {
        URLBuilder url = new URLBuilder(urlItem.getText().toString());
        if (historyIter != null){
            historyIter.add(url.getUrl());
        } else {
            history.add(url.getUrl());
        }
        while (historyIter.hasNext()){
            historyIter.next();
            historyIter.remove();
        }
        web.loadUrl(url.getUrl().toString());
    }

    public void next(View v) {
        if (historyIter.hasNext()) {
            web.loadUrl(historyIter.next().toString());
        }

    }

    public void prev(View v) {
        if (historyIter.hasPrevious()) {
            web.loadUrl(historyIter.previous().toString());
        }
    }

    public void runJavaScript(View v){
        web.evaluateJavascript("javascript:shoutOut()", null);
    }
}