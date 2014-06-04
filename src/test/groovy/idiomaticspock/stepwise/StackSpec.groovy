package idiomaticspock.stepwise

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise
import spock.lang.Subject

@Stepwise
class StackSpec extends Specification {

  @Shared @Subject stack = new Stack()
  @Shared value = "foo"

  def "can push to the stack"() {
    expect:
    stack.push(value) == value
  }

  def "stack should have content"() {
    expect:
    stack.peek() == value
  }

  def "can pop from the stack"() {
    expect:
    stack.pop() == value
  }

  def "the stack should be empty"() {
    expect:
    stack.empty()
  }
}
