package com.example.yunus.burcrehberi

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.tek_satir.view.*

class BurclarArrayAdapter(var myContext: Context, resource: Int, textViewResourceId: Int,var burcAdlari: Array<String>,var burcTarihleri: Array<String>,var burcSembolleri: Array<Int>) :
    ArrayAdapter<String>(myContext, resource, textViewResourceId, burcAdlari) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tekSatirView = convertView
        var viewHolder : ViewHolder
        if (tekSatirView == null) {
            //tek_satir layoutumuzu inflate ediyoruz
            var inflater = LayoutInflater.from(myContext)
            tekSatirView = inflater.inflate(R.layout.tek_satir, parent, false)

        }

        viewHolder = ViewHolder(tekSatirView!!)
        //tek_satir layout referansını alan tekSatirView değişkeninin değerlerini set ediyoruz
        viewHolder.burcResim.setImageResource(burcSembolleri[position])
        viewHolder.burcTarih.setText(burcTarihleri[position])
        viewHolder.burcAdi.setText(burcAdlari[position])
        //oluşturulan tekSatirView ımızı return ediyoruz
        return tekSatirView!!
    }
    class ViewHolder(tekSatirView : View){
        var burcResim : ImageView
        var burcAdi   : TextView
        var burcTarih : TextView

        init {
            this.burcResim  = tekSatirView.imgBurcSembol
            this.burcAdi    = tekSatirView.tvBurcAdi
            this.burcTarih  = tekSatirView.tvBurcTarih
        }
    }

}