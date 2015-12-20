package com.github.aesteve.groovyquarium.diet

import com.github.aesteve.groovyquarium.Aquarium
import com.github.aesteve.groovyquarium.Plant

trait Herbivorous {

	void eat(Plant plant) {
		this.health += 3
		plant.health -= 2
	}

	void eat(Aquarium aquarium) {
		Plant plant = aquarium.randomPlant
		if (!plant) return
		eat plant
		if (plant.dead) aquarium -= plant
	}

}
