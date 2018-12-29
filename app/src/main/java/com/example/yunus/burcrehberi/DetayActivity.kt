package com.example.yunus.burcrehberi

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.graphics.Palette
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detay.*

class DetayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        var tumBurcBilgileri = intent.extras.get("tumBurcBilgileri") as ArrayList<Burc>
        var position = intent.extras.get("position") as Int

        tvBurcOzellikleri.text = tumBurcBilgileri.get(position).burcGenelOzellikleri
        header.setImageResource(tumBurcBilgileri.get(position).burcBuyukResim)

        setSupportActionBar(anim_toolbar)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)

        collapsing_toolbar.title = tumBurcBilgileri.get(position).burcAdi

        //bitmap'ımıza burcun Buyuk Resim ini decode ediliyor ardından bitmapa ataması yapılıyor
        var bitmap = BitmapFactory.decodeResource(resources,tumBurcBilgileri.get(position).burcBuyukResim)

        Palette.from(bitmap).generate { palette ->
                var color = palette!!.getMutedColor(R.attr.colorPrimary)
                collapsing_toolbar.setContentScrimColor(color)
                window.setStatusBarColor(color)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()

        return super.onSupportNavigateUp()
    }
}
