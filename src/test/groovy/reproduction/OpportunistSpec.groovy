package reproduction

import com.github.aesteve.groovyquarium.impl.Sole
import spock.lang.Specification

import static com.github.aesteve.groovyquarium.Fish.Sex.FEMALE
import static com.github.aesteve.groovyquarium.Fish.Sex.MALE

class OpportunistSpec extends Specification {

	def "two opportunist fishes can breed when they're the same sex"() {
		given:
		def sole = new Sole(sex: MALE, name:'sole')
		def other = new Sole(sex: MALE, name: 'other')

		expect:
		def child = sole.breed other
		child && child.name == 'Child of sole,other'
	}

	def "two opportunist fishes can breed when they're not the same sex"() {
		given:
		def sole = new Sole(sex: FEMALE, name:'sole')
		def other = new Sole(sex: MALE, name: 'other')

		expect:
		def child = sole.breed other
		child && child.name == 'Child of sole,other'
	}

}
