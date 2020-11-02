package vanilla

import grails.plugin.springsecurity.annotation.Secured
import io.vanilla.common.ApplicationConstants

import io.vanilla.DailyCount
import io.vanilla.Shelter

class DailyCountController {

    @Secured([ApplicationConstants.ROLE_ADMIN, ApplicationConstants.ROLE_USER])
    def entry(long id) {
        def shelter = Shelter.get(id)
        [ shelter: shelter ]
    }

    @Secured([ApplicationConstants.ROLE_ADMIN, ApplicationConstants.ROLE_USER])
    def save(){
        def today = new Date().clearTime()
        def shelter = Shelter.get(params.id)

        def dailyCount = new DailyCount()
        dailyCount.count = params.count as Integer
        dailyCount.notes = params.notes
        dailyCount.dateEntered = today
        dailyCount.shelter = shelter

        if(dailyCount.save(flush:true)){
            println("saved")
        }

        dailyCount.errors.allErrors.each{
            print it
        }

        def saved = DailyCount.findByShelterAndDateEntered(shelter, today)
        println("did it save ? " + saved)

        redirect(controller:"shelter", action:"list")
    }

    @Secured([ApplicationConstants.ROLE_ADMIN, ApplicationConstants.ROLE_USER])
    def edit(long id){
        def dailyCount = DailyCount.get(id)
        println(dailyCount)
        [ dailyCount: dailyCount ]
    }

    @Secured([ApplicationConstants.ROLE_ADMIN, ApplicationConstants.ROLE_USER])
    def update(){
        def dailyCount = DailyCount.get(params.id)
        dailyCount.count = params.count as Integer
        dailyCount.notes = params.notes
        dailyCount.save(flush:true)
        redirect(controller: "shelter", action: "list")
    }

}
