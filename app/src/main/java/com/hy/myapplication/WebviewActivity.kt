package com.hy.myapplication

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.tencent.smtt.sdk.WebView
import com.tencent.smtt.sdk.WebViewClient


class WebviewActivity: AppCompatActivity() {

    private var root :LinearLayout?=null
    private var webView :WebView?= null

    private var client = object : WebViewClient() {
        /**
         * 防止加载网页时调起系统浏览器
         */
        override fun shouldOverrideUrlLoading(p0: WebView?, p1: String?): Boolean {
            p0?.loadUrl(p1)
            return true

        }

          }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_web)


        var url = intent.getStringExtra("url")
        root = findViewById(R.id.web_layout)
        webView =  findViewById(R.id.web)
        webView!!.webViewClient = client
        // 对于刘海屏机器如果webview被遮挡会自动padding

        webView!!.loadUrl("www.baidu.com")
//        agentWeb = AgentWeb.with(this).setAgentWebParent(root!!,LinearLayout.LayoutParams(-1,-1))
//            .useDefaultIndicator().createAgentWeb().ready().go("www.baidu.com")
    }
}