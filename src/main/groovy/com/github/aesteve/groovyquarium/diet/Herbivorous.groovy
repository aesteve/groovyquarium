package com.github.aesteve.groovyquarium.diet

import com.github.aesteve.groovyquarium.Plant

trait Herbivorous {

	/**
	 * For unit-testing purpose
	 * @param plant
	 */
	void eat(Plant plant) {
		this.health += 3
		plant.health -= 2
	}

	void eat() {
		Plant plant = this.aquarium.randomPlant
		if (!plant) return // no more living plant
		eat plant
	}

}
