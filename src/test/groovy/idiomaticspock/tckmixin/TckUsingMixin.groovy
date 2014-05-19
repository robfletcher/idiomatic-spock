package idiomaticspock.tckmixin

import spock.lang.Specification

@Category(Specification)
class SizeTck {
	def "can compute size"() {
		expect:
		data(3).size() == 3
	}
}

@Mixin(SizeTck)
class StringSizeSpec extends Specification {
	def data(int size) {
		"x" * size
	}
}

@Mixin(SizeTck)
class ListSizeSpec extends Specification {
	def data(int size) {
		[null] * size
	}
}
