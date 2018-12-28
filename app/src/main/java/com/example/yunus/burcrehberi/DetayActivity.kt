package com.example.yunus.burcrehberi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class DetayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        var position = intent.extras.get("position")

    }
}
