package vanilla

import grails.plugin.springsecurity.annotation.Secured
import io.vanilla.DailyCount
import io.vanilla.Shelter
import io.vanilla.common.ApplicationConstants

class ResourceController {

    @Secured([ApplicationConstants.PERMIT_ALL])
    def home() {
        def total = 0
        def date = new Date().clearTime()
        def shelters = Shelter.list()
        shelters.each{ shelter ->
            def counts = DailyCount.findAllByShelterAndDateEntered(shelter, date)
            counts.each{ count ->
                total = count.total + total
            }
        }

        [shelters: shelters, total: total]
    }


    @Secured([ApplicationConstants.PERMIT_ALL])
    def select() {
        def locations = []
        def shelters = Shelter.list()
        shelters.each{ shelter ->
            if(!locations.contains(shelter.location)){
                locations.add(shelter.location)
            }
        }
        ["locations" : locations]
    }

    @Secured([ApplicationConstants.PERMIT_ALL])
    def make() {
        def total = 0
        def date = new Date().clearTime()
        def shelters = Shelter.findAllByLocation(params.location)
        shelters.each{ shelter ->
            def counts = DailyCount.findAllByShelterAndDateEntered(shelter, date)
            counts.each{ count ->
                total = count.total + total
            }
        }

        [location: params.location, total: total]
    }

    @Secured([ApplicationConstants.PERMIT_ALL])
    def on(){
        def shelters = Shelter.list()
        [shelters: shelters]
    }

    @Secured([ApplicationConstants.PERMIT_ALL])
    def onn(){}
}
