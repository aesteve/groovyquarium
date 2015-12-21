package com.github.aesteve.groovyquarium.utils

class DoWhile {
	private Closure code

	static DoWhile loop( Closure code ) {
		new DoWhile(code:code)
	}

	void until( Closure test ) {
		code()
		while (!test()) {
			code()
		}
	}
}
