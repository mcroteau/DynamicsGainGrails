package vanilla

class HealthCheck {
	
	def notificationService

    static triggers = {
      	simple startDelay: 4000, repeatInterval: 10000
    }

    void execute() {
    	println "********** Vanilla ***********"
    }
	
}
