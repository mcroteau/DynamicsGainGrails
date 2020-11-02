package vanilla

import grails.plugin.springsecurity.annotation.Secured
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
        shelter.save()
        redirect(action: "list")
    }

    @Secured([ApplicationConstants.ROLE_ADMIN])
    def list() {
        def shelters = Shelter.list()
        def total = Shelter.count()
        [ shelters: shelters, total: total ]
    }

}
