package com.github.aesteve.groovyquarium.reproduction

import com.github.aesteve.groovyquarium.Aquarium
import com.github.aesteve.groovyquarium.Fish

trait MonoSexual {

	Fish breed(Aquarium aquarium) {
		if (this.hungry) return
		Fish other = aquarium.randomFish this
		if (!other) return
		if (other.class != this.class) return
		if (this.sex == other.sex) return
		this.class.newInstance()
	}

}