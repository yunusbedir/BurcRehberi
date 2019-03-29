package com.example.yunus.burcrehberi

import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.graphics.Palette
import kotlinx.android.synthetic.main.activity_detay.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import java.io.IOException

class DetayActivity : AppCompatActivity() {

    var burcAdi : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        var tumBurcBilgileri = intent.extras.get("tumBurcBilgileri") as ArrayList<Burc>
        var position = intent.extras.get("position") as Int
        burcAdi = tumBurcBilgileri[position].burcAdi


        VerileriCek(burcAdi!!).execute()

        header.setImageResource(tumBurcBilgileri.get(position).burcResmi)

        setSupportActionBar(anim_toolbar)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)

        collapsing_toolbar.title = tumBurcBilgileri.get(position).burcAdi

        //bitmap'ımıza burcun Buyuk Resim ini decode ediliyor ardından bitmapa ataması yapılıyor
        var bitmap = BitmapFactory.decodeResource(resources,tumBurcBilgileri.get(position).burcResmi)

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



    private inner class VerileriCek(var burcAdi:String) : AsyncTask<Void, Void, Void>() {
        var URL = "https://www.elle.com.tr/astroloji/" + burcAdi + "/ozellik"
        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg params: Void?): Void? {
            var doc: Document? = null
            try {
                doc = Jsoup.connect(URL).get()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            //"div[class = body-el-text standard-body-el-text]" bu div classındaki ilk elemti al
            var divClass: Element = doc?.select("div[class = body-el-text standard-body-el-text]")!!.first()
            //div classının içindeki "p" tagındaki verileri al
            var element: Elements = divClass.getElementsByTag("p")
            //her bir tag için işlem yap
            for (elemen in element) {
                //tagın içerisinde veriler "key: value" şeklinde bulunuyordu o yüzden split ile parçaladık
                var keyValue: List<String> = elemen.text().split(": ")
                System.out.println("\nkey : " + keyValue[0])
                System.out.println("value: " + keyValue[1])
            }
            return null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
        }

    }
}
