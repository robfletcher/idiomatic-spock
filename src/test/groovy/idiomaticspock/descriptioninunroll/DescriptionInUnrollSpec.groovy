package idiomaticspock.descriptioninunroll

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class DescriptionInUnrollSpec extends Specification {
	def "can tell if the string '#string' is an integer or not"() {
		expect:
		string.isInteger() == shouldBeInteger

		where:
		string | shouldBeInteger
		"ABC"  | false
		"123"  | true
		"1.2"  | false
		"1 2"  | false
		"1a2"  | false
	}

	def "the string '#string' is #description"() {
		expect:
		string.isInteger() == shouldBeInteger

		where:
		string | shouldBeInteger
		"ABC"  | false
		"123"  | true
		"1.2"  | false
		"1 2"  | false
		"12a"  | false

		description = shouldBeInteger ? "an integer" : "not an integer"
	}
}
