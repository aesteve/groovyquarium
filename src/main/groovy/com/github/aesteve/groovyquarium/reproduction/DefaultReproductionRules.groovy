package com.github.aesteve.groovyquarium.reproduction

import com.github.aesteve.groovyquarium.Fish

trait DefaultReproductionRules {

	Fish check(Fish other) {
		if (this.hungry) return
		if (!other) return
		if (this.is(other)) return
		if (!other.isPartner(this)) return // no mutts
		other
	}

}