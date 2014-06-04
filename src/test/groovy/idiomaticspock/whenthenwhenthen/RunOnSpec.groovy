package idiomaticspock.whenthenwhenthen

import spock.lang.Specification

class RunOnSpec extends Specification {

  def "can use multiple when and then blocks"() {
    given:
    def stack = new Stack()

    when:
    stack.push "foo"

    then:
    stack.pop() == "foo"

    when:
    stack.pop()

    then:
    thrown EmptyStackException
  }

}
