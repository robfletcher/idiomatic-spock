package idiomaticspock.nashorn

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

import javax.script.ScriptEngineManager

import static java.time.LocalDateTime.now

class FriendlyDateSpec extends Specification {
  @Shared engine = new ScriptEngineManager().getEngineByName("nashorn")
  @Shared @Subject moment

  def setupSpec() {
    getClass().getResourceAsStream("/moment-with-langs.js").withReader { reader ->
      engine.eval reader
    }

    moment = engine.invokeFunction("moment")
  }

  @Unroll
  def "The date #date in friendly format is #expectedResult"() {
    expect:
    engine.invokeMethod(moment, "from", date.toString()) == expectedResult

    where:
    date                 | expectedResult
    now().plusDays(2)    | "2 days ago"
    now().plusMinutes(2) | "2 minutes ago"
    now()                | "a few seconds ago"
    now().minusDays(1)   | "in a day"
  }
}
