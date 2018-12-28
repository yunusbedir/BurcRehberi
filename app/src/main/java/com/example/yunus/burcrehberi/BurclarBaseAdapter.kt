package com.example.yunus.burcrehberi

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.tek_satir.view.*

class BurclarBaseAdapter(mContext : Context) : BaseAdapter() {

    var tumBurclar:ArrayList<Burc>
    var context:Context

    init {
        tumBurclar = ArrayList<Burc>(12)
        context = mContext
        //values klasörü altında oluşturduğumuz arrayleri çekip değişkenlere atıyoruz
        var burcAdlari = context.resources.getStringArray(R.array.burclar)
        var burcTarihleri = context.resources.getStringArray(R.array.burcTarih)
        //drawable klasöründeki resimleri değişkene atıyoruz
        var burcSembolleri = arrayOf(R.drawable.koc1,R.drawable.boga2,R.drawable.ikizler3,R.drawable.yengec4,R.drawable.aslan5,R.drawable.basak6
            ,R.drawable.terazi7,R.drawable.akrep8,R.drawable.yay9,R.drawable.oglak10,R.drawable.kova11,R.drawable.balik12)

        for (i in 0..11) {
            var gecici= Burc(burcAdlari[i],burcTarihleri[i],burcSembolleri[i])
            tumBurclar.add(gecici)
        }

    }
    override fun getView(position: Int, convertView: View, parent: ViewGroup?): View {
        var tekSatirView = convertView
        var mViewHolder : ViewHolder2

        if (tekSatirView == null) {
            var inflater: LayoutInflater = LayoutInflater.from(context)
            var tekSatirView = inflater.inflate(R.layout.tek_satir, parent, false)
            mViewHolder = ViewHolder2(tekSatirView)
            tekSatirView.tag = mViewHolder
        }
        else{
            mViewHolder = tekSatirView.getTag() as ViewHolder2
        }
        mViewHolder.imgBurcResim.setImageResource(tumBurclar.get(position).burcSembol)
        mViewHolder.tvBurcAdi.setText(tumBurclar.get(position).burcAdi)
        mViewHolder.tvBurcTarih.setText(tumBurclar.get(position).burcTarih)

        return tekSatirView
    }

    override fun getItem(p0: Int): Any {
        return tumBurclar.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return tumBurclar.size
    }
}

data class Burc(var burcAdi: String ,var burcTarih: String , var burcSembol: Int  )

class ViewHolder2(tekSatirView : View){
    var imgBurcResim:ImageView
    var tvBurcAdi : TextView
    var tvBurcTarih : TextView
    init {
        tvBurcAdi = tekSatirView.tvBurcAdi
        tvBurcTarih = tekSatirView.tvBurcTarih
        imgBurcResim = tekSatirView.imgBurcSembol
    }
}