package idiomaticspock.separatedatafromlogic

import com.google.common.base.Function
import rx.Observable
import spock.lang.Specification
import spock.lang.Subject

class SeparateDataFromLogicSpec extends Specification {

  @Subject
  def service = new StreamService()

  def "passes data from stream to callback 1"() {
    given:
    def callback = Mock(Function)

    and:
    service.source = Stub(StreamSource) {
      connect() >> Observable.from("foo", "bar", "baz")
    }

    when:
    service.readStream(callback)

    then:
    1 * callback.apply("foo")
    1 * callback.apply("bar")
    1 * callback.apply("baz")
  }

  def "passes data from stream to callback 2"() {
    given:
    def callback = Mock(Function)

    and:
    service.source = Stub(StreamSource) {
      connect() >> Observable.from(*data)
    }

    when:
    service.readStream(callback)

    then:
    data.each {
      1 * callback.apply(it)
    }

    where:
    data = ["foo", "bar", "baz"]
  }

}

class StreamService {
  StreamSource source

  void readStream(Function callback) {
    source.connect().subscribe {
      callback.apply(it)
    }
  }
}

interface StreamSource {
  def <T> Observable<T> connect()
}