package idiomaticspock.functionalstyle

import spock.lang.Specification

class EverySpec extends Specification {
	def "all strings are at least 3 characters long (bad)"() {
		given:
		def list = ["", "x", "xxx", "xxxxx"]*.padRight(3, "z")

		expect:
		list[0].length() >= 3
		list[1].length() >= 3
		list[2].length() >= 3
		list[3].length() >= 3
	}
	def "all strings are at least 3 characters long (good)"() {
		given:
		def list = ["", "x", "xxx", "xxxxx"]*.padRight(3, "z")

		expect:
		list.every { it.length() >= 3 }
	}
}
