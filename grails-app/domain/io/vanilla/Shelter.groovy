package io.vanilla

class Shelter {

    static transients = [ "count" , "counts", "dailyCount", "entered" ]

    String name
    String location

    boolean entered
    int count
    DailyCount dailyCount
    List<DailyCount> counts

    static hasMany = [ accounts: Account ]

    static constraints = {
        name(nullable:false)
        location(nullable:false)
    }

}