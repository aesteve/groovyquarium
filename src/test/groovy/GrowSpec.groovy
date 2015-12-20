import com.github.aesteve.groovyquarium.Plant
import com.github.aesteve.groovyquarium.impl.Bass
import com.github.aesteve.groovyquarium.impl.Carp
import com.github.aesteve.groovyquarium.impl.ClownFish
import com.github.aesteve.groovyquarium.impl.Grouper
import com.github.aesteve.groovyquarium.impl.Sole
import com.github.aesteve.groovyquarium.impl.Tuna
import spock.lang.Specification

class GrowSpec extends Specification {

	def "plants earn 1HP per turn"(){
		given:
		plant++

		expect:
		plant.age == 1
		plant.health == 11

		where:
		plant = new Plant()
	}

	def "fishes lose 1HP per turn"(){
		given:
		fish++

		expect:
		fish.age == 1
		fish.health == 9

		where: fish << [new Bass(), new Carp(), new ClownFish(), new Grouper(), new Sole(), new Tuna()]
	}

	def "fishes are not hungry before 5 turns"() {
		given:
		4.times { fish++ }

		expect:
		!fish.hungry

		where: fish << [new Bass(), new Carp(), new ClownFish(), new Grouper(), new Sole(), new Tuna()]
	}

	def "fishes are hungry after 5 turns"() {
		given:
		5.times { fish++ }

		expect:
		fish.hungry

		where: fish << [new Bass(), new Carp(), new ClownFish(), new Grouper(), new Sole(), new Tuna()]
	}

	def "plants are alive before 20 turns"() {
		given:
		19.times { living++ }

		expect:
		!living.dead

		where: living << [new Plant()]

	}

	def "fishes are alive before 10 turns"() {
		given:
		9.times { living++ }

		expect:
		!living.dead

		where: living << [new Bass(), new Carp(), new ClownFish(), new Grouper(), new Sole(), new Tuna()]
	}

	def "a living is dead after 20 turns"() {
		given:
		20.times { living++ }

		expect:
		living.dead

		where: living << [new Plant(), new Bass(), new Carp(), new ClownFish(), new Grouper(), new Sole(), new Tuna()]

	}

}
