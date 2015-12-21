package com.github.aesteve.groovyquarium

class Aquarium {

	int round = 0
	List<Fish> fishes = []
	List<Plant> plants = []
	private Random rand = new Random()

	public Aquarium() {
		/* We're creating a new method called getRandomMember() on lists */
		List.metaClass.getRandomMember = {
			if (delegate.empty) return
			delegate[rand.nextInt(delegate.size())]
		}
	}

	/*
	 * Convenience methods : operator overloading : + / - to add / remove stuff
	 */
	Aquarium plus(Fish fish) {
		fish.aquarium = this
		fishes << fish
		this
	}

	Aquarium plus(Plant plant) {
		plant.aquarium = this
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

	List<Fish> getLivingFishes() {
		fishes.findAll { !it.dead } as List
	}

	List<Plant> getLivingPlants() {
		plants.findAll { !it.dead } as List
	}

	Fish getRandomFish() {
		livingFishes.randomMember
	}

	Plant getRandomPlant() {
		livingPlants.randomMember
	}

	Aquarium next() {
		round++
		(fishes + plants).each { it++ }
		// remove dead bodies from the aquarium
		fishes = livingFishes
		plants = livingPlants
		println this.toString()
		this
	}

	@Override
	public String toString() {
		String str = "===== AQUARIUM =====\n"
		str += "== round = $round \n"
		str += "== Plants = $plants \n"
		str += "== Fishes = $fishes"
		str
	}
}
