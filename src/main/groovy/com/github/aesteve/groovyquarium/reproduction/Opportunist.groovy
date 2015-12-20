package com.github.aesteve.groovyquarium.reproduction

import com.github.aesteve.groovyquarium.Aquarium
import com.github.aesteve.groovyquarium.Fish

trait Opportunist {

	Fish breed(Aquarium aquarium) {
		if (this.hungry) return
		Fish other = aquarium.randomFish this
		if (!other) return
		if (this.class != other.class) return
		if (this.sex == other.sex) this.sex.opposite
		this.class.newInstance()
	}

}