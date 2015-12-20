package com.github.aesteve.groovyquarium

class Aquarium {

	int round = 0
	List<Fish> fishes = []
	List<Plant> plants = []
	private Random rand = new Random()

	Aquarium plus(Fish fish) {
		fishes << fish
		this
	}

	Aquarium plus(Plant plant) {
		plants << plant
		this
	}

	Aquarium minus(Fish fish) {
		fishes.remove fish
		this
	}

	Aquarium minus(Plant plant) {
		plants.remove plant
		this
	}

	Fish randomFish(Fish self) {
		Collection<Fish> eligible = fishes.findAll { it != self }
		if (eligible.empty) return
		eligible[rand.nextInt(eligible.size())]
	}

	Plant getRandomPlant() {
		if (plants.empty) return
		plants[rand.nextInt(plants.size())]
	}

	Aquarium next() {
		round++
		// everyone grows
		fishes = fishes.findAll { fish ->
			fish++
			!fish.dead
		}
		plants = plants.findAll { plant ->
			plant++
			!plant.dead
		}
		// fishes eat
		(0..fishes.size()-1).each { // avoid concurrent modification exception
			fishes[it].eat this
		}
		// reproduction
		if (!fishes.empty) {
			(0..fishes.size()-1).each { // avoid concurrent modification exception
				Fish child = fishes[it].breed this
				if (child) this + child
			}
		}
		if (!plants.empty) {
			(0..plants.size()-1).each { // avoid concurrent modification exception
				Plant child = plants[it].breed this
				if (child) this + child
			}
		}
		println this.toString()
		this
	}

	@Override
	public String toString() {
		String str = "===== AQUARIUM =====\n"
		str += "== round = $round \n"
		str += "== Plants = $plants \n"
		str += "== Fishes = $fishes"
	}
}
