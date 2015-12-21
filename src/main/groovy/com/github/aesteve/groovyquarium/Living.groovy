package com.github.aesteve.groovyquarium

abstract class Living {

	int health = 10
	int age = 0

	abstract Living grow()
	abstract Living breed()
	abstract Living next()

	boolean isDead() {
		health <= 0 || age >= 20
	}

}
