package com.example.yunus.burcrehberi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detay.*

class DetayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        var tumBurcBilgileri = intent.extras.get("tumBurcBilgileri") as ArrayList<Burc>
        var position = intent.extras.get("position") as Int

        tvBurcOzellikleri.text = tumBurcBilgileri.get(position).burcGenelOzellikleri
    }
}
