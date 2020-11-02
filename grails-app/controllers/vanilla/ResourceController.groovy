package vanilla

import grails.plugin.springsecurity.annotation.Secured
import io.vanilla.DailyCount
import io.vanilla.Shelter
import io.vanilla.common.ApplicationConstants

class ResourceController {

    @Secured([ApplicationConstants.PERMIT_ALL])
    def home() {
        def total = 0
        def shelters = Shelter.list()
        shelters.each{ shelter ->
            def counts = DailyCount.findAllByShelter(shelter)
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
        def shelters = Shelter.findAllByLocation(params.location)
        shelters.each{ shelter ->
            def counts = DailyCount.findAllByShelter(shelter)
            counts.each{ count ->
                total = count.total + total
            }
        }

        [location: params.location, total: total]
    }

}
