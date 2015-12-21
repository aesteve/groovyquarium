package reproduction

import com.github.aesteve.groovyquarium.impl.Carp
import spock.lang.Specification

import static com.github.aesteve.groovyquarium.Fish.Sex.*

class MonoSexualSpec extends Specification {

	def "Two monosexual fishes from the same sex can't breed"() {
		given:
		def magicarp = new Carp(name: 'magicarp', sex: MALE)
		def leviator = new Carp(name: 'leviator', sex: MALE)

		expect:
		!magicarp.breed(leviator)
	}


	def "Two monosexual fishes from different sex can breed"() {
		given:
		def magicarp = new Carp(name: 'magicarp', sex: MALE)
		def leviator = new Carp(name: 'leviator', sex: FEMALE)

		expect:
		def child = magicarp.breed leviator
		child && child.name == 'Child of magicarp,leviator'
	}
}
