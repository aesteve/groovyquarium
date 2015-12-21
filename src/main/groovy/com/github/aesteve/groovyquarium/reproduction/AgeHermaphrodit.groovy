package com.github.aesteve.groovyquarium.reproduction

import com.github.aesteve.groovyquarium.Aquarium
import com.github.aesteve.groovyquarium.Fish
import static com.github.aesteve.groovyquarium.Fish.Sex.*

trait AgeHermaphrodit extends DefaultReproductionRules {

	Fish breed(Fish fish) {
		Fish other = check fish
		if (!other) return
		this.sex = this.age <= 10 ? MALE : FEMALE
		if (this.sex == other.sex) return
		this & other
	}

}