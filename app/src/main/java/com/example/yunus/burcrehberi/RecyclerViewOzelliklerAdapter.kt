package com.example.yunus.burcrehberi

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.ozellik_satir.view.*
import java.lang.Exception

class RecyclerViewOzelliklerAdapter(val items : ArrayList<List<String>>, val context: Context) : RecyclerView.Adapter<RecyclerViewOzelliklerAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        var inflater = LayoutInflater.from(p0.context)
        var tek_uye= inflater.inflate(R.layout.ozellik_satir,p0,false)
        return MyViewHolder(tek_uye)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        var veri =items.get(p1)
        p0.setData(veri)
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var detay = itemView as CardView
        var detayKey = detay.tvOzellikKey
        var detayValue = detay.tvOzellikValue

        fun setData(veri: List<String>) {
            try {
                if (veri[0].isNotEmpty()) {
                    detayKey.text = veri[0]
                    detayValue.text = veri[1]
                }
            }
            catch (e : Exception){
                e.printStackTrace()
            }
        }
    }
}