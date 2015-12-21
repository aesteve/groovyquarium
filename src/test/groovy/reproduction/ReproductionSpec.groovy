package reproduction

import com.github.aesteve.groovyquarium.Aquarium
import com.github.aesteve.groovyquarium.impl.Bass
import com.github.aesteve.groovyquarium.impl.Carp
import com.github.aesteve.groovyquarium.impl.ClownFish
import com.github.aesteve.groovyquarium.impl.Grouper
import com.github.aesteve.groovyquarium.impl.Sole
import com.github.aesteve.groovyquarium.impl.Tuna
import spock.lang.Specification

class ReproductionSpec extends Specification {

	def "an hungry fish cannot breed"() {
		given:
		fish.health = 4

		expect:
		!fish.breed(other)

		where:
		fish << [new Bass(), new Carp(), new ClownFish(), new Grouper(), new Sole(), new Tuna() ]
		other << [new Bass(), new Carp(), new ClownFish(), new Grouper(), new Sole(), new Tuna() ]
	}

	def "two fishes of different species cannot breed"() {
		setup:
		Aquarium aquarium = new Aquarium()
		def carp = new Carp()
		def sole = new Sole()
		aquarium + carp
		aquarium + sole

		expect:
		!carp.breed() && !sole.breed()
	}

}
