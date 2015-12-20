import com.github.aesteve.groovyquarium.Aquarium
import com.github.aesteve.groovyquarium.Plant
import com.github.aesteve.groovyquarium.impl.Carp
import com.github.aesteve.groovyquarium.impl.Sole
import spock.lang.Specification

class AquariumSpec extends Specification {
	def "mock"() {
		setup:
		Aquarium aquarium = new Aquarium()
		5.times {
			aquarium + new Plant()
		}
		aquarium + new Carp(name:'Magicarp')
		aquarium + new Sole(name:'Ground')

		when:
		10.times { aquarium++ }

		then: true
	}
}
