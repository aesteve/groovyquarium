package com.github.aesteve.groovyquarium.reproduction

import com.github.aesteve.groovyquarium.Fish

trait MonoSexual extends DefaultReproductionRules {

	Fish breed(Fish fish) {
		Fish other = check fish
		if (!other) return
		if (this.sex == other.sex) return
		this & other
	}

}