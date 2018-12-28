package com.example.yunus.burcrehberi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var tumBurcBilgileri : ArrayList<Burc>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veriKaynagiHazirla()

        var mAdapter =  BurclarBaseAdapter(this,tumBurcBilgileri)
        list_burclar.adapter = mAdapter

        list_burclar.setOnItemClickListener { adapterView, view, position, id ->
            var intent = Intent(this@MainActivity,DetayActivity::class.java)
            intent.putExtra("position",position)
            startActivity(intent)

        }
    }

    private fun veriKaynagiHazirla() {
        tumBurcBilgileri = ArrayList(12)

        //values klasörü altında oluşturduğumuz arrayleri çekip değişkenlere atıyoruz
        var burcAdlari = resources.getStringArray(R.array.burclar)
        var burcTarihleri = resources.getStringArray(R.array.burcTarih)
        //drawable klasöründeki resimleri değişkene atıyoruz
        var burcSembolleri = arrayOf(R.drawable.koc1,R.drawable.boga2,R.drawable.ikizler3
            ,R.drawable.yengec4,R.drawable.aslan5,R.drawable.basak6
            ,R.drawable.terazi7,R.drawable.akrep8,R.drawable.yay9
            ,R.drawable.oglak10,R.drawable.kova11,R.drawable.balik12)
        var burcBuyukResimleri = arrayOf(R.drawable.b_koc1,R.drawable.b_boga2,R.drawable.b_ikizler3
            ,R.drawable.b_yengec4,R.drawable.b_aslan5,R.drawable.b_basak6
            ,R.drawable.b_terazi7,R.drawable.b_akrep8,R.drawable.b_yay9
            ,R.drawable.b_oglak10,R.drawable.b_kova11,R.drawable.b_balik12)

        var burcGenelOzellikleri = resources.getStringArray(R.array.burcGenelOzellikler)

        for (i in 0..11) {
            var arrayListEklenecekBurc = Burc(burcAdlari[i],burcTarihleri[i],burcSembolleri[i],burcBuyukResimleri[i],burcGenelOzellikleri[i])
            tumBurcBilgileri.add(arrayListEklenecekBurc)
        }
    }
}
