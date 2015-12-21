import com.github.aesteve.groovyquarium.Aquarium
import com.github.aesteve.groovyquarium.Fish
import com.github.aesteve.groovyquarium.Plant
import com.github.aesteve.groovyquarium.impl.Carp
import com.github.aesteve.groovyquarium.impl.Sole
import com.github.aesteve.groovyquarium.impl.Tuna
import spock.lang.Specification
import static com.github.aesteve.groovyquarium.utils.DoWhile.*
class AquariumSpec extends Specification {

	def "fake test"() {
		setup:
		Aquarium aquarium = new Aquarium()
		5.times {
			aquarium + new Plant()
		}
		aquarium + new Carp(name:'Magicarp', sex: Fish.Sex.MALE)
		aquarium + new Carp(name:'Leviator', sex: Fish.Sex.FEMALE)
		aquarium + new Sole(name:'Ground')
		aquarium + new Tuna(name:'MrTuna', sex: Fish.Sex.MALE)
		aquarium + new Tuna(name:'MrsTuna', sex: Fish.Sex.FEMALE)

		when:
		loop {
			aquarium++
		} until {aquarium.empty }

		then:
		println "Empty after ${aquarium.round} turns"
		true
	}

}
