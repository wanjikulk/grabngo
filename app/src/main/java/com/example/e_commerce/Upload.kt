package com.example.e_commerce

class Upload {
     var name: String = ""
     var description: String = ""
     var size: String = ""
     var price: String = ""
     var image: String = ""
     var id: String = ""

    constructor(
        model: String,
        color: String,
        regNo: String,
        price: String,
        image: String,
        id: String
    ) {
        this.name = model
        this.description = color
        this.size = regNo
        this.price = price
        this.image = image
        this.id = id
    }
    constructor()
}