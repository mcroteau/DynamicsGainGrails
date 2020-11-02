package io.vanilla

class Permission {
	
	Permission(){
		this.uuid = UUID.randomUUID().toString()
	}
	
	String uuid

   	Account account
   	String permission

	static constraints = {
		uuid(nullable:true)
	}
}

