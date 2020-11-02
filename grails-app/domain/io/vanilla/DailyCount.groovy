package io.vanilla

class DailyCount {

    int count
    String notes

    Date dateEntered

    Shelter shelter

    static constraints = {
        count(nullable:false)
        notes(nullable:true)
        dateEntered(nullable:false)
    }

}