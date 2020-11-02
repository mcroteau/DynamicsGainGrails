package io.vanilla

class Country {
	
	Country(){
		this.uuid = UUID.randomUUID().toString()
	}
	
	String uuid
	
	String name
	
	Date dateCreated
	Date lastUpdated
	
	static hasMany = [states : State]
	
    static constraints = {
		uuid(nullable:true)
		name(unique:true)
    }
}
