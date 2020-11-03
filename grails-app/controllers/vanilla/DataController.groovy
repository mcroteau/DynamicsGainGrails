package vanilla

import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured
import io.vanilla.DailyCount
import io.vanilla.Shelter
import io.vanilla.common.ApplicationConstants

import java.text.SimpleDateFormat

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


    @Secured([ApplicationConstants.ROLE_ADMIN, ApplicationConstants.ROLE_USER])
    def counts(long id){
        def data = [:]
        def counts = []
        def labels = []
        def shelter = Shelter.get(id)
        def dailyCounts = DailyCount.findAllByShelter(shelter, [ max: 7, sort: "dateEntered", order:"asc"])
        dailyCounts.each{ dailyCount ->
            counts.add(dailyCount.total)
            def sdf = new SimpleDateFormat("dd MMM")
            def date = sdf.format(dailyCount.dateEntered)
            labels.add(date)
        }

        data["counts"] = counts
        data["labels"] = labels

        render data as JSON
    }

    /**

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

    @Secured([ApplicationConstants.ROLE_ADMIN])
    def generateCountData(){
        def shelters = Shelter.list()

        def rand = new Random()
        shelters.each{ shelter ->
            def daysBack = rand.nextInt(17)
            0.upto(daysBack) {
                def date = new Date().clearTime() - it
                println(shelter.name + ":" + date)
                def dailyCount = new DailyCount()
                dailyCount.total = rand.nextInt(90)
                dailyCount.shelter = shelter
                dailyCount.dateEntered = date
                dailyCount.save(flush:true)
            }
        }
    }

    */
}
