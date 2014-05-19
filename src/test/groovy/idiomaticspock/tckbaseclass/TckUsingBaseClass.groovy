package idiomaticspock.tckbaseclass

import spock.lang.Specification

abstract class SizeTckSpec extends Specification {

	abstract data(int length)

	def "can compute size"() {
		expect:
		data(3).size() == 3
	}
}

class StringSizeSpec extends SizeTckSpec {
	def data(int size) {
		"x" * size
	}
}

class ListSizeSpec extends SizeTckSpec {
	def data(int size) {
		[null] * size
	}
}
