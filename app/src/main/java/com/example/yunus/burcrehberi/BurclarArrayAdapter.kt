package com.example.yunus.burcrehberi

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.tek_satir.view.*

class BurclarArrayAdapter(var myContext: Context, resource: Int, textViewResourceId: Int,var burcAdlari: Array<String>,var burcTarihleri: Array<String>,var burcSembolleri: Array<Int>) :
    ArrayAdapter<String>(myContext, resource, textViewResourceId, burcAdlari) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //tek_satir layoutumuzu inflate ediyoruz
        var inflater = LayoutInflater.from(myContext)
        var tekSatirView = inflater.inflate(R.layout.tek_satir,parent,false)

        var burcImageView= tekSatirView.imgBurcSembol
        var burcAdi      = tekSatirView.tvBurcAdi
        var burcTarihi   = tekSatirView.tvBurcTarih
        //tek_satir layout referansını alan tekSatirView değişkeninin değerlerini set ediyoruz
        burcImageView.setImageResource(burcSembolleri[position])
        burcTarihi.setText(burcTarihleri[position])
        burcAdi.setText(burcAdlari[position])
        //oluşturulan tekSatirView ımızı return ediyoruz
        return tekSatirView
    }

}