package com.example.lol_lain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.example.lol_lain.databinding.ActivityLoginBinding
import com.example.lol_lain.databinding.ActivityLolActivityBinding

class LoLActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityLolActivityBinding.inflate(layoutInflater)
    }
    var web: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        // 자바 스크립트 허용
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.settings.loadWithOverviewMode = true
        binding.webView.settings.useWideViewPort = true
        binding.webView.settings.allowUniversalAccessFromFileURLs = true
        binding.webView.settings.javaScriptCanOpenWindowsAutomatically = true
        binding.webView.settings.domStorageEnabled = true
//        binding.webView.settings.setSupportMultipleWindows = true
        binding.webView.settings.saveFormData = true
        WebView.setWebContentsDebuggingEnabled(true)


        binding.webView.setWebChromeClient(object : WebChromeClient() {
            override fun onConsoleMessage(consoleMessage: ConsoleMessage): Boolean {
                Log.e(
                    "Console.log",
                    consoleMessage.message() + " from line " + consoleMessage.lineNumber()
                            + " of " + consoleMessage.sourceId() + ""
                )
                return super.onConsoleMessage(consoleMessage)
            }
        })


        /* 웹뷰에서 새 창이 뜨지 않도록 방지하는 구문 */
        binding.webView.webViewClient = WebViewClient()
        binding.webView.webChromeClient = WebChromeClient()
        /* 링크 주소를 로드 */
        binding.webView.loadUrl("file:///android_asset/index.html")


    }





}