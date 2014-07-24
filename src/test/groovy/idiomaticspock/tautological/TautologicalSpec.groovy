package idiomaticspock.tautological

import java.time.Year
import spock.lang.AutoCleanup
import spock.lang.Specification
import spock.lang.Subject
import idiomaticspock.starships.PersistentShipStore
import idiomaticspock.starships.Ship
import idiomaticspock.starships.ShipMapper
import org.skife.jdbi.v2.DBI
import org.skife.jdbi.v2.Handle

class TautologicalSpec extends Specification {

  @Subject PersistentShipStore ships
  @AutoCleanup Handle handle

  def setup() {
    handle = DBI.open("jdbc:h2:mem:test")
    ships = handle.attach(PersistentShipStore)
    ships.createTable()
  }

  def cleanup() {
    ships.dropTable()
  }

  def "can find ships by allegiance"() {
    given:
    ships.insert new Ship("Enterprise", "Federation", Year.of(2245))
    ships.insert new Ship("Adventure", "Federation", Year.of(2376))
    ships.insert new Ship("Haakona", "Romulan", Year.of(2357))

    expect:
    ships.findByAllegiance("Federation") == handle.createQuery("""\
                                                 select * from ship
                                                 where allegiance = 'Federation'\
                                                """)
                                                  .map(new ShipMapper())
                                                  .list() as Set
  }
}
