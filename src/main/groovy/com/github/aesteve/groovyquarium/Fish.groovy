package com.github.aesteve.groovyquarium

import groovy.transform.CompileStatic
import groovy.transform.TypeChecked

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

	String name
	Sex sex = Sex.random

	abstract void eat(Aquarium aquarium)

	boolean isHungry() {
		health <= 5
	}

	Living next() {
		health--
		age++
		this
	}

	@Override
	public String toString() {
		return "\n==== Fish [age=$age , health=$health (race=${this.class.canonicalName})]"
	}

}
