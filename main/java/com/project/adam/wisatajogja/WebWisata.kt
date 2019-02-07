package com.project.lauwba.wisatajogja

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.ProgressBar
//START KODING AND IMPORT FRAGMENT
class WebWisata: Fragment() {

    lateinit var webView:WebView
    lateinit var pb:ProgressBar

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_web_wisata,null);
    }

//    LANJUT KODING INISIALISASI OBJEK, BUAT FUNGSI, SETTING OBJEK
@SuppressLint("NewApi")
override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
//WEBVIEW DIGANTI JADI WEB GA MERAH?
    webView=view.findViewById(R.id.webview)
    pb=view.findViewById(R.id.pb)

    webView.settings.javaScriptEnabled=true
    webView.settings.javaScriptCanOpenWindowsAutomatically=true;
    webView.webChromeClient=object:WebChromeClient() {
        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            super.onProgressChanged(view, newProgress)
            if(newProgress==100) {
                pb.visibility=View.GONE
            }
        }
    }
    webView.loadUrl("http://id.wikipedia.org/wiki/Yogyakarta")
}
}

//END KODING FRAGMENT

//KOMEN CLASS DEFAULT
//class WebWisata : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_web_wisata)
//    }
//}
