package io.vanilla

class DailyCount {

    int total
    String notes

    Date dateEntered

    Shelter shelter

    static constraints = {
        total(nullable:false)
        notes(nullable:true)
        dateEntered(nullable:false)
    }

}