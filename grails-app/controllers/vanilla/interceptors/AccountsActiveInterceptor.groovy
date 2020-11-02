package vanilla.interceptors

import io.vanilla.common.ApplicationConstants

class AccountsActiveInterceptor {

	AccountsActiveInterceptor(){
		match(controller:"account", action: ~/(account|index|create|edit|show)/)
	}

    boolean before() { 
    	request.accountsActive = ApplicationConstants.ACTIVE_CLASS_NAME
    	true 
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
