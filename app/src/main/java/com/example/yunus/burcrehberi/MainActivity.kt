package com.example.yunus.burcrehberi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //burçlar dizimiz bunu list_burclara aktaracağız bunun için ArrayAdapter kullanacağız
    var burclar = arrayOf("Koç","Boğa","İkizler","Yengeç","Aslan","Başak","Terazi","Akrep","Yay","Oğlak","Kova","Balık","asdfd","asd")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //ArrayAdapter oluşturuyoruz.Bu sınıfın 'contexti' içerisinde 'simple_list_item_1' türünde 'burclar' dizisini ArrayAdaptere dönüştürüyoruz
        var burclarAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,burclar)
        //burclarAdapter ımızı list_burclar listView ımıza set ediyoruz
        list_burclar.adapter = burclarAdapter
        /*
        //itemlara tıklanma durumunu dinliyoruz OnItemClickListener interfacesi ni isimsiz sınıfa implement ettik ve OnItemClickListener ın abstract metodunu override ettik
        list_burclar.setOnItemClickListener(object : AdapterView.OnItemClickListener {
            override fun onItemClick(adapter: AdapterView<*>?, view : View?, position: Int, id: Long) {
                //view nesnemizi TextView olarak cast ettik ve gecici değişkenine atadık bu sayede view deki text i okuyabileceğiz
                var gecici = view as TextView

                //her hangi bir item a tıklandğın da ekrana toast mesajı yazıyor
                Toast.makeText(this@MainActivity,"Tıklanıldı : " + gecici.text.toString() + " Pos : ${position}",Toast.LENGTH_LONG).show()
            }

        })
        */
        //lambda kullanarak dinleme yapıyoruz
        list_burclar.setOnItemClickListener { adapterView, view, position, id ->
            //view nesnemizi TextView olarak cast ettik ve gecici değişkenine atadık bu sayede view deki text i okuyabileceğiz
            var gecici = view as TextView
            //her hangi bir item a tıklandğın da ekrana toast mesajı yazıyor
            Toast.makeText(this@MainActivity,"Tıklanıldı : " + gecici.text.toString() + " Pos : ${position}",Toast.LENGTH_LONG).show()}
    }
}
