package idiomaticspock.old

import spock.lang.Specification
import spock.lang.Subject

class OldSpec extends Specification {

  @Subject stack = new Stack()

  def "size increases when we add items to a stack v1"() {
    when:
    stack.push "foo"

    then:
    stack.size() == 1
  }

  def "size increases when we add items to a stack v2"() {
    given:
    def oldSize = stack.size()

    when:
    stack.push "foo"

    then:
    stack.size() == oldSize + 1
  }

  def "size increases when we add items to a stack v3"() {
    when:
    stack.push "foo"

    then:
    stack.size() == old(stack.size()) + 1
  }

}
