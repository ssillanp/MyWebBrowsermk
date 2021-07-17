package com.example.mywebbrowser;
/*
 * @author Sami Sillanpää
 * LUT Olio ohjelmointi Vko 10
 *
 */


import java.net.MalformedURLException;
import java.net.URL;

public class URLBuilder {
        ;
    URL url;

    URLBuilder(String urlItem) {
        try {
            url = new URL(urlItem);
        } catch (MalformedURLException e) {
            try {
                url = new URL("http", urlItem, "");
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public URL getUrl(){
        if (url.getHost().equals("index.html")) {
            try {
                url = new URL("file", "/android_asset", "/index.html");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            System.out.println(url.toString());
        }
        return url;
    }

    }


