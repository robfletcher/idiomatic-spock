package idiomaticspock.autocleanup

import idiomaticspock.starships.PersistentShipStore
import org.skife.jdbi.v2.DBI
import spock.lang.Specification
import spock.lang.Subject

class AutoCleanup1Spec extends Specification {

  def handle = DBI.open("jdbc:h2:mem:test")
  @Subject ships = handle.attach(PersistentShipStore)

  def setup() {
    ships.createTable()
  }

  def cleanup() {
    ships.dropTable()
    handle.close()
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
