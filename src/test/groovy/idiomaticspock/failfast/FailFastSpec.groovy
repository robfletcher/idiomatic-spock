package idiomaticspock.failfast

import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

@Ignore("this test shows the difference in diagnostics quality between using a loop and a where block")
class FailFastSpec extends Specification {

  def "can identify numeric strings"() {
    expect:
    ["1", "-1", "1.1", "0xf", "0E+7"].every {
      it.isNumber()
    }
  }

  @Unroll
  def "'#n' is numeric"() {
    expect:
    n.isNumber()

    where:
    n << ["1", "-1", "1.1", "0xf", "0E+7"]
  }
}
