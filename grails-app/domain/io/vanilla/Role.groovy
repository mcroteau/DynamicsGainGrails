package io.vanilla

class Role {
	
	Role(){
		this.uuid = UUID.randomUUID().toString()
	}
	
	String uuid
	String authority

	Role(String authority) {
		this()
		this.authority = authority
	}

	static constraints = {
		uuid(nullable:true)
		authority blank: false, unique: true
	}

}
