package idiomaticspock.conditional

import spock.lang.IgnoreIf
import spock.lang.Specification

import static java.net.HttpURLConnection.HTTP_OK

class RequiresNetworkSpec extends Specification {

  @IgnoreIf({ !Network.isReachable("http://httpbin.org/") })
  def "requires network 1"() {
    given:
    HttpURLConnection connection = "http://httpbin.org/".toURL().openConnection()

    when:
    connection.connect()

    then:
    connection.responseCode == HTTP_OK
  }
}
