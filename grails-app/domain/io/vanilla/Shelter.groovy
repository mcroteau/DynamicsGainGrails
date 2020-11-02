package io.vanilla

class Shelter {

    static transients = [ "count" , "counts", "dailyCount" ]

    String name
    String location

    int count
    DailyCount dailyCount
    List<DailyCount> counts

    static constraints = {
        name(nullable:false)
        location(nullable:false)
    }

}