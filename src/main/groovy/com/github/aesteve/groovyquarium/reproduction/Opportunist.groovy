package com.github.aesteve.groovyquarium.reproduction

import com.github.aesteve.groovyquarium.Aquarium
import com.github.aesteve.groovyquarium.Fish

trait Opportunist extends DefaultReproductionRules {

	Fish breed(Fish fish) {
		Fish other = check fish
		if (!other) return
		if (this.sex == other.sex) this.sex.opposite
		this & other
	}

}