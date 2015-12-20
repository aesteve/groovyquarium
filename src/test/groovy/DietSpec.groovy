import com.github.aesteve.groovyquarium.Plant
import com.github.aesteve.groovyquarium.impl.Bass
import com.github.aesteve.groovyquarium.impl.Carp
import com.github.aesteve.groovyquarium.impl.ClownFish
import com.github.aesteve.groovyquarium.impl.Grouper
import com.github.aesteve.groovyquarium.impl.Sole
import com.github.aesteve.groovyquarium.impl.Tuna
import spock.lang.Specification

class DietSpec extends Specification {

	def "herbivorous eat plants"() {
		given:
		fish.eat plant

		expect:
		plant.health == 8
		fish.health == 13

		where:
		plant 		| fish
		new Plant() | new Carp()
		new Plant() | new Sole()
		new Plant() | new Bass()
	}

	def "carnivorous eat fishes"() {
		given:
		eater.eat eaten

		expect:
		eater.health == 15
		eaten.health == 6

		where:
		eaten << [new Bass(), new Sole(), new Carp()]
		eater << [new Tuna(), new ClownFish(), new Grouper()]
	}

}
