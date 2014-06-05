package idiomaticspock.tck

import idiomaticspock.starships.PersistentShipStore
import org.skife.jdbi.v2.DBI
import org.skife.jdbi.v2.Handle
import spock.lang.AutoCleanup

class PersistentShipStoreSpec extends ShipStoreSpec<PersistentShipStore> {

  @AutoCleanup Handle handle

  def setup() {
    handle = DBI.open("jdbc:h2:mem:test")
    ships = handle.attach(PersistentShipStore)
    ships.createTable()
  }

  def cleanup() {
    ships.dropTable()
  }
}
