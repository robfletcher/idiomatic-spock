package idiomaticspock

import spock.lang.*

trait LengthSpec {

    abstract data(int length)

    def "can compute the length"() {
        expect:
        data(3).length() == 3
    }

}

class StringLengthSpec extends Specification implements LengthSpec {

    def data(int length) {
        "x" * length
    }

}

class ListLengthSpec extends Specification implements LengthSpec {

    def data(int length) {
        [] * length
    }

}
