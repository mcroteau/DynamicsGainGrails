package vanilla

import groovy.time.TimeCategory
import grails.util.Environment

import io.vanilla.common.ApplicationConstants			
			
import io.vanilla.CountryStateHelper
import io.vanilla.Role
import io.vanilla.Account
import io.vanilla.Country		
import io.vanilla.State	


class BootStrap {

	def customerRole
	def administratorRole
	
	def springSecurityService
	def commonUtilities

    
	def init = { servletContext ->

		println "***********************************************"
		println "*******          Dynamics +Gain         *******"
		println "***********************************************"
		createRoles()
		createAdministrator()

		if(Environment.current == Environment.DEVELOPMENT) {
			//createMockAccounts()
		}

    }
	
	

	def createRoles(){
		if(Role.count() == 0){
			administratorRole = new Role(authority : ApplicationConstants.ROLE_ADMIN).save(flush:true)
			customerRole = new Role(authority : ApplicationConstants.ROLE_CUSTOMER).save(flush:true)
		}else{
			administratorRole = Role.findByAuthority(ApplicationConstants.ROLE_ADMIN)
			customerRole = Role.findByAuthority(ApplicationConstants.ROLE_CUSTOMER)
		}
		
		println 'Roles : ' + Role.count()
	
	}
	
	
	def createAdministrator(){
		if(Account.count() == 0){
			def password = springSecurityService.encodePassword("admin")
			def adminAccount = new Account(username : "croteau.mike+admin@gmail.com", password : password, name : 'Administrator')
			adminAccount.hasAdminRole = true
			adminAccount.save(flush:true)

			adminAccount.createAccountRoles(true)
			adminAccount.createAccountPermission()
		}		

		println "Accounts : " + Account.count()
	}

	
	def createCountries(){
		if(Country.count() == 0){
			CountryStateHelper countryStateHelper = new CountryStateHelper()
			countryStateHelper.countryStates.each(){ countryData ->
				createCountryAndStates(countryData)
			}
		}
		println "Countries : ${Country.count()}"
		println "States : ${State.count()}"
	}
	
	
	def createCountryAndStates(countryData){
		def country = new Country()
		country.name = countryData.name
		country.save(flush:true)
		
		countryData.states.each(){ stateData ->
			def state = new State()
			state.country = country
			state.name = stateData
			state.save(flush:true)
		}
	}

	
    def destroy = {
    }
}
