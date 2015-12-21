package com.github.aesteve.groovyquarium.diet

import com.github.aesteve.groovyquarium.Fish

trait Carnivorous {

	/**
	 * For unit-testing purposes
	 * @param other
	 */
	void eat(Fish other) {
		other.health -= 4
		this.health += 5
	}

	void eat() {
		Fish other = this.aquarium.randomFish
		if (!other) return // no-one to eat
		if (other.is(this)) return // cannot eat himself
		if (other.isPartner(this)) return // cannot eat the same species
		eat other
	}

}
