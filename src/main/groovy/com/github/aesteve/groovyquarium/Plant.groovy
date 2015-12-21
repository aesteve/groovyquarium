package com.github.aesteve.groovyquarium

class Plant extends Living {

	Aquarium aquarium

	Living next() {
		grow()
		def child = breed()
		if (child) aquarium + child
		this
	}

	@Override
	Living grow() {
		health++
		age++
		this
	}

	@Override
	Living breed() {
		if (this.health <= 10) return
		this.health /= 2
		new Plant(age: 0, health: this.health)
	}

	@Override
	public String toString() {
		return "\n==== Plant age=$age , health=$health"
	}

}
