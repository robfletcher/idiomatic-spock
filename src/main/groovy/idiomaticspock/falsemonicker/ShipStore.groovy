package idiomaticspock.falsemonicker

class ShipStore {
  @Delegate private final List<Ship> ships = []

  List<Ship> findByAllegianceNewestFirst(String allegiance) {
    ships.sort { it.enteredService }
  }
}
