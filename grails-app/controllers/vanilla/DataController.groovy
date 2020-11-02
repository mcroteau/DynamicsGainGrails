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

}
