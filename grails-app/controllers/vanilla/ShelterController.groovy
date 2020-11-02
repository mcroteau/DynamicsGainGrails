package vanilla

import grails.plugin.springsecurity.annotation.Secured
import io.vanilla.DailyCount
import io.vanilla.Shelter
import io.vanilla.common.ApplicationConstants

class ShelterController {

    @Secured([ApplicationConstants.ROLE_ADMIN])
    def add(){}

    @Secured([ApplicationConstants.ROLE_ADMIN])
    def save(){
        def shelter = new Shelter()
        shelter.name = params.name
        shelter.location = params.location
        shelter.save(flush:true)
        redirect(action: "list")
    }

    @Secured([ApplicationConstants.ROLE_ADMIN])
    def list() {
        def date = new Date().clearTime()
        def shelters = Shelter.list()
        def total = Shelter.count()

        println(date)

        shelters.each{shelter ->
            def dailyCount = DailyCount.findByShelterAndDateEntered(shelter, date)
            println(dailyCount)
            if(dailyCount){
                shelter.dailyCount = dailyCount
            }else{
                shelter.dailyCount = new DailyCount()
                shelter.dailyCount.count = 0
            }
        }

        [ shelters: shelters, total: total ]
    }

}
