package vanilla

import grails.plugin.springsecurity.annotation.Secured
import io.vanilla.DailyCount
import io.vanilla.Shelter
import io.vanilla.common.ApplicationConstants

import java.text.SimpleDateFormat

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
    def edit(long id){
        def shelter = Shelter.get(id)
        [shelter: shelter]
    }

    @Secured([ApplicationConstants.ROLE_ADMIN])
    def update(long id){
        def shelter = Shelter.get(id)
        shelter.name = params.name
        shelter.location = params.location
        shelter.save(flush:true)
        redirect(action: "list")
    }

    @Secured([ApplicationConstants.ROLE_ADMIN, ApplicationConstants.ROLE_USER])
    def list() {
        def date = new Date().clearTime()
        def frm = new SimpleDateFormat("dd MMM yyyy")
        def formattedDate = frm.format(date)

        def shelters = Shelter.list()

        println(date)

        shelters.each{shelter ->
            def dailyCount = DailyCount.findByShelterAndDateEntered(shelter, date)
            println(dailyCount)
            if(dailyCount){
                shelter.dailyCount = dailyCount
                shelter.entered = true
            }else{
                shelter.dailyCount = new DailyCount()
                shelter.entered = false
            }
        }

        [ shelters: shelters, date: formattedDate ]
    }

    @Secured([ApplicationConstants.ROLE_ADMIN, ApplicationConstants.ROLE_USER])
    def counts(long id){
        def shelter = Shelter.get(id)
        def dailyCounts = DailyCount.findAllByShelter(shelter)
        def total = DailyCount.countByShelter(shelter)
        [ dailyCounts: dailyCounts, total: total, shelter: shelter ]
    }

    def account(){
        def shelter = Shelter.get(params.id)

    }

}
