package com.example.webview;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private String url = "https://github.com/Jason-Vic";
    private WebView webView;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Uri uri = Uri.parse(url);
        //Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        //startActivity(intent);
        init();
    }


    public void init() {
        webView = (WebView) findViewById(R.id.webView);
        //加载本地网页
        //webView.loadUrl("file:///android_asset/index.html");
        //加载在线网页
        webView.loadUrl(url);
        //在view中加载网页不弹出三方浏览器
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(url);
                return true;
            }
        });
        //启用JS
        WebSettings webViewSettings = webView.getSettings();
        webViewSettings.setJavaScriptEnabled(true);

        //启用缓存
        webViewSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        //网页进度
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    //OK
                    closedialog();
                } else {
                    //Loading
                    opendialog(newProgress);
                }
            }

            private void opendialog(int newProgress) {
                if (progressDialog == null) {
                    progressDialog = new ProgressDialog(MainActivity.this);
                    progressDialog.setTitle("Loading");
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    progressDialog.setProgress(newProgress);
                    progressDialog.show();
                } else {
                    progressDialog.setProgress(newProgress);
                }
            }

            private void closedialog() {
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                    progressDialog = null;
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webView.canGoBack()) {
                webView.goBack();
                return true;
            } else {
                System.exit(0);
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
