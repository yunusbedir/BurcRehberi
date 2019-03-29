package com.example.yunus.burcrehberi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var animLogoDondur = AnimationUtils.loadAnimation(this,R.anim.logo_dondur)
        imgLogo.animation = animLogoDondur



    }

    override fun onResume() {
        object : CountDownTimer(5000,1000) {
            override fun onFinish() {
                var intent = Intent(this@SplashActivity , MainActivity::class.java)
                startActivity(intent)
                this@SplashActivity.finish()
            }

            override fun onTick(p0: Long) {
            }

        }.start()
        super.onResume()
    }
}
