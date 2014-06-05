package idiomaticspock.tck

import idiomaticspock.starships.MemoryShipStore

class MemoryShipStoreSpec extends ShipStoreSpec<MemoryShipStore> {
  def setup() {
    ships = new MemoryShipStore()
  }
}
