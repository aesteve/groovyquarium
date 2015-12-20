package com.github.aesteve.groovyquarium

abstract class Living {

	int health = 10
	int age = 0

	abstract Living next()
	abstract Living breed(Aquarium aquarium)

	boolean isDead() {
		health <= 0 || age >= 20
	}

}
