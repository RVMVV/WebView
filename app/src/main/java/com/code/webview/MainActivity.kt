package com.code.webview

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView: WebView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = object: WebViewClient(){
            override fun onPageFinished(view: WebView, url: String) {
                Toast.makeText(this@MainActivity, "Web dicoding berhasil dimuat", Toast.LENGTH_SHORT).show()
                view.loadUrl("javascript:alert('Web Dicoding berhasil dimuat')")
            }
        }
        webView.webChromeClient = object: WebChromeClient(){
            override fun onJsAlert(
                view: WebView?,
                url: String?,
                message: String?,
                result: JsResult?
            ): Boolean {
                Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
                result?.confirm()
                return true
            }
        }
        webView.loadUrl("https://www.dicoding.com")

    }
}