package com.hy.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.hy.myapplication.R


class SplashActivity: AppCompatActivity() {
    private var isSync = false
    private var intent : Intent?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_splash)

        var h = Handler(Looper.myLooper()!!)
        h.postDelayed(
            {
                if (isSync){
                     intent = Intent(this,WebviewActivity::class.java)
                    startActivity(intent)
                } else{
                     intent = Intent(this,LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
        },1500)
    }



}