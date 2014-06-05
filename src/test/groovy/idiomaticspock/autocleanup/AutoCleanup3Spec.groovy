package idiomaticspock.autocleanup

import idiomaticspock.starships.PersistentShipStore
import org.skife.jdbi.v2.DBI
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Subject

class AutoCleanup3Spec extends Specification {

  @Shared @AutoCleanup handle = DBI.open("jdbc:h2:mem:test")

  @Shared
  @AutoCleanup("dropTable")
  @Subject ships = handle.attach(PersistentShipStore)

  def setupSpec() {
    ships.createTable()
  }

  def "can retrieve a list of ships"() {
    given:
    def statement = handle.createStatement("insert into ship (name, allegiance) values (?, ?)")
    [Federation: ["Enterprise", "Constellation"], Klingon: ["M'Char"]].each { allegiance, names ->
      names.each { name ->
        statement.bind(0, name).bind(1, allegiance).execute()
      }
    }

    when:
    def ships = ships.findByAllegiance("Federation")

    then:
    with(ships.toList()) {
      size() == 2
      allegiance.every { it == "Federation" }
      name == ["Enterprise", "Constellation"]
    }
  }
}



