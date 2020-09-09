package com.mqr.mycatsubmission1.model

import java.io.Serializable

data class Cat(
    var id: String = "",
    var catName: String = "",
    var description: String = "",
    var karakter: String = "",
    var createdAt: String = "",
    var image: Int = 0
):Serializable