package idiomaticspock.tcktrait

import spock.lang.Specification

trait SizeTck {

	abstract data(int length)

	def "can compute size"() {
		expect:
		data(3).length() == 3
	}

}

class StringSizeSpec extends Specification implements SizeTck {

	def data(int length) {
		"x" * length
	}

}

class ListSizeSpec extends Specification implements SizeTck {

	def data(int length) {
		["x"] * length
	}

}
