package com.github.aesteve.groovyquarium

abstract class Fish extends Living {

	enum Sex {
		MALE, FEMALE
		Sex getOpposite() {
			MALE ? FEMALE : MALE
		}
		static private Random rand = new Random()
		static Sex getRandom() {
			values()[rand.nextInt(1)]
		}
	}

	Aquarium aquarium
	String name
	Sex sex = Sex.random

	abstract void eat() // implemented by traits [Carnivorous, Herbivorous]

	boolean isHungry() {
		health <= 5
	}

	@Override
	Living grow() {
		health--
		age++
		this
	}

	@Override
	// delegates to trait.breed().
	// the random part is put here so that the breed(other) can be unit tested in a determinist manner
	Living breed() {
		breed aquarium.randomFish
	}

	@Override
	Living next() {
		grow()
		eat()
		def child = breed()
		if (child) aquarium + child
		this
	}

	boolean isPartner(Fish other) {
		this.class == other.class
	}

	Fish and(Fish other) {
		this.class.newInstance([aquarium: aquarium, name: "Child of ${this.name},${other.name}"])
	}

	@Override
	public String toString() {
		return "\n==== Fish [age=$age , health=$health , name=${name} (race=${this.class.name})]"
	}

}
