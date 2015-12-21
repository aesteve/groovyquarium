package reproduction

import com.github.aesteve.groovyquarium.impl.Bass
import spock.lang.Specification
import static com.github.aesteve.groovyquarium.Fish.Sex.*

class AgeHermaphroditSpec extends Specification {

	def "Hermaphrodit will change sex if it's old enough"() {
		given:
		Bass bass = new Bass(age:11, sex: MALE, name:'bass')
		Bass bass2 = new Bass(age:5, sex: MALE, name:'bass2')

		expect:
		def child = bass.breed bass2
		bass.sex == FEMALE && child && child.name == 'Child of bass,bass2'
	}

	def "Young hermaphrodits won't change sex and thus won't breed"() {
		given:
		Bass bass = new Bass(age:4, sex: MALE, name:'bass')
		Bass bass2 = new Bass(age:5, sex: MALE, name:'bass2')

		expect:
		def child = bass.breed bass2
		bass.sex == MALE && !child
	}
}
