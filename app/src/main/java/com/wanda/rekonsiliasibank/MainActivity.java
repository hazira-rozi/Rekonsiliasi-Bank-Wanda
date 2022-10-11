package com.wanda.rekonsiliasibank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity {

    WebView playBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playBrowser = (WebView)findViewById(R.id.playBrowser);
        WebSettings webSettings = playBrowser.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setPluginState(WebSettings.PluginState.ON);
        webSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        playBrowser.setWebViewClient(new CallBack());
        playBrowser.loadUrl("file:///android_asset/index.html");
    }

    private class CallBack extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            return false;
        }
    }
    @Override
    public void onBackPressed(){
        if(playBrowser !=null && playBrowser.canGoBack()){
            playBrowser.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}