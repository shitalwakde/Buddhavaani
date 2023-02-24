package com.lastmile.buddhavaani.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.lastmile.buddhavaani.R
import com.lastmile.buddhavaani.ui.main.MainActivity

class SplashScreenActivity : AppCompatActivity() {

    companion object{
        const val TAG = "SplashActivity"
    }

    private var shouldFinish = false

    override fun onStop() {
        super.onStop()
        if(shouldFinish){
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        Handler().postDelayed({
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finishAffinity()
        }, 2000)
    }



}