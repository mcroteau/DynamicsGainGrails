package vanilla

import grails.plugin.springsecurity.annotation.Secured

import io.vanilla.common.ApplicationConstants



class DashboardController {
	
	def commonUtilities

	@Secured([ApplicationConstants.PERMIT_ALL])
	def data(){
		def accountInstance = commonUtilities.getAuthenticatedAccount()
		[accountInstance : accountInstance]
	}

	@Secured([ApplicationConstants.ROLE_ADMIN, ApplicationConstants.ROLE_USER])
	def index(){
	}


}