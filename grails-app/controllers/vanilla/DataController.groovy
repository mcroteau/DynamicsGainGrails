package vanilla

import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured
import io.vanilla.DailyCount
import io.vanilla.Shelter
import io.vanilla.common.ApplicationConstants

class DataController {

    @Secured([ApplicationConstants.PERMIT_ALL])
    def shelters() {
        def data = [:]
        def shelters = Shelter.list()
        shelters.each{shelter ->
            data[shelter.name] = [:]
            def dailyCounts = DailyCount.findAllByShelter(shelter)
            data[shelter.name]["data"] = shelter
            data[shelter.name]["counts"] = dailyCounts
        }
        render data as JSON
    }


    @Secured([ApplicationConstants.ROLE_ADMIN])
    def createMocks(){
        def names = ["Boston Dynamics", "Lockheed Martin", "Boeing"]
        names.each{
            def shelter = new Shelter()
            shelter.name = it
            shelter.location = "Jessup, MD"
            shelter.save(flush:true)
        }

        def shelters = Shelter.list()
        Random rnd = new Random()

        shelters.each{shelter ->
            def dailyCount = new DailyCount()
            dailyCount.shelter = shelter
            dailyCount.total = rnd.nextInt(102)
            dailyCount.dateEntered = new Date().clearTime()
            dailyCount.save(flush:true)
        }

        render "success"
    }

}
