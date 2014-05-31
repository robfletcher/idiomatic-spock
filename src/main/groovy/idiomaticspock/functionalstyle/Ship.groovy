package idiomaticspock.functionalstyle

import groovy.transform.CompileStatic
import groovy.transform.Immutable

@Immutable
@CompileStatic
class Ship {
  String name
  String allegiance

  @Override
  String toString() {
    name
  }
}
