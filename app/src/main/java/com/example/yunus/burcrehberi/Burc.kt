package com.example.yunus.burcrehberi

import java.io.Serializable

data class Burc(
    var burcAdi: String,
    var burcTarihi: String,
    var burcSembolu: Int,
    var burcResmi: Int
) :Serializable

