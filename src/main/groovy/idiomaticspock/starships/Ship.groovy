package idiomaticspock.starships

import java.time.Year
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode

@CompileStatic
@EqualsAndHashCode
class Ship {
  final String name
  final String allegiance
  final Year enteredService

  Ship(String name, String allegiance) {
    this(name, allegiance, Year.now())
  }

  Ship(String name, String allegiance, Year enteredService) {
    this.name = name
    this.allegiance = allegiance
    this.enteredService = enteredService
  }

  @Override
  String toString() {
    name
  }
}
