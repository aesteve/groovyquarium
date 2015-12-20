package com.github.aesteve.groovyquarium.diet

import com.github.aesteve.groovyquarium.Aquarium
import com.github.aesteve.groovyquarium.Fish

trait Carnivorous {

	void eat(Fish other) {
		other.health -= 4
		this.health += 5
	}

	void eat(Aquarium aquarium) {
		Fish other = aquarium.randomFish this
		if (!other) return
		eat other
		if (other.dead) aquarium -= fish
	}

}
