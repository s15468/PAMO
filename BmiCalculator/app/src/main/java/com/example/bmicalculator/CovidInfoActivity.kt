package com.example.bmicalculator

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class CovidInfoActivity : AppCompatActivity() {
    private var webView: WebView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covidinfo)
        webView = findViewById<View>(R.id.webView) as WebView
        webView!!.webViewClient = WebViewClient()
        webView!!.loadUrl("https://www.worldometers.info/coronavirus/")
    }
}