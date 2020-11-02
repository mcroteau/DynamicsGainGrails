package io.vanilla

class State {
	
	State(){
		this.uuid = UUID.randomUUID().toString()
	}
	
	String uuid
	
	String name
	
	Country country
	static belongsTo = [ Country ]
	
	static mapping = {
	    sort "name"
	}
		
    static constraints = {
		uuid(nullable:true)
		name(unique:true)
    }
}
