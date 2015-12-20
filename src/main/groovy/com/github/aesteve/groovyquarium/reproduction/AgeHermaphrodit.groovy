package com.github.aesteve.groovyquarium.reproduction

import com.github.aesteve.groovyquarium.Aquarium
import com.github.aesteve.groovyquarium.Fish
import static com.github.aesteve.groovyquarium.Fish.Sex.*

trait AgeHermaphrodit {

	Fish breed(Aquarium aquarium) {
		if (this.hungry) return
		this.sex = this.age <= 10 ? MALE : FEMALE
		Fish other = aquarium.randomFish this
		if (!other) return
		if (other.class != this.class) return
		if (this.sex == other.sex) return
		this.class.newInstance()
	}

}