import com.github.aesteve.groovyquarium.Aquarium
import com.github.aesteve.groovyquarium.Fish
import com.github.aesteve.groovyquarium.Plant
import com.github.aesteve.groovyquarium.impl.Carp
import com.github.aesteve.groovyquarium.impl.Sole
import spock.lang.Specification

class AquariumSpec extends Specification {

	def "fake test"() {
		setup:
		Aquarium aquarium = new Aquarium()
		5.times {
			aquarium + new Plant()
		}
		aquarium + new Carp(name:'Magicarp', aquarium:aquarium, sex: Fish.Sex.MALE)
		aquarium + new Carp(name:'Leviator', aquarium:aquarium, sex: Fish.Sex.FEMALE)
		aquarium + new Sole(name:'Ground', aquarium:aquarium)

		when:
		20.times { aquarium++ }

		then: true
	}

}
