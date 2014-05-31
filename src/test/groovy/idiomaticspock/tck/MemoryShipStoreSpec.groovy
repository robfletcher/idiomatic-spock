package idiomaticspock.tck

class MemoryShipStoreSpec extends ShipStoreSpec<MemoryShipStore> {
  def setup() {
    ships = new MemoryShipStore()
  }
}
