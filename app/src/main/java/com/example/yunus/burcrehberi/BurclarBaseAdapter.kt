package com.example.yunus.burcrehberi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.tek_satir.view.*

class BurclarBaseAdapter(mContext : Context , myTumBurcBilgileri : ArrayList<Burc>) : BaseAdapter() {

    var tumBurclar:ArrayList<Burc>
    var context:Context

    init {
        tumBurclar = myTumBurcBilgileri
        context = mContext

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var tekSatirView = convertView
        var mViewHolder : ViewHolder2

        if (tekSatirView == null) {
            var inflater: LayoutInflater = LayoutInflater.from(context)
            tekSatirView = inflater.inflate(R.layout.tek_satir, parent, false)
            mViewHolder = ViewHolder2(tekSatirView)
            tekSatirView.tag = mViewHolder
        }
        else{
            mViewHolder = tekSatirView.getTag() as ViewHolder2
        }
        mViewHolder.imgBurcResim.setImageResource(tumBurclar.get(position).burcSembolu)
        mViewHolder.tvBurcAdi.setText(tumBurclar.get(position).burcAdi)
        mViewHolder.tvBurcTarih.setText(tumBurclar.get(position).burcResmi)

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