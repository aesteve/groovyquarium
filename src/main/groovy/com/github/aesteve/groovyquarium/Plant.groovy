package com.github.aesteve.groovyquarium

class Plant extends Living {

	Living next() {
		health++
		age++
		this
	}

	@Override
	Living breed(Aquarium aquarium) {
		if (this.health <= 10) return
		this.health /= 2
		new Plant(age: 0, health: this.health)
	}

	@Override
	public String toString() {
		return "\n==== Plant age=$age , health=$health"
	}

}
