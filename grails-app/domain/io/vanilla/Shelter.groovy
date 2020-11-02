package io.vanilla

class Shelter {

    String name
    String location

    static constraints = {
        name(nullable:false)
        location(nullable:false)
    }

}