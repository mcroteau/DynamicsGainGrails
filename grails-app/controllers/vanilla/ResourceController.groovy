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
                total = count.count + total
            }
        }

        [shelters: shelters, total: total]
    }

}
