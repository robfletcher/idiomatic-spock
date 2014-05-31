package idiomaticspock.tck

import groovy.transform.CompileStatic
import groovy.transform.Immutable

@Immutable
@CompileStatic
class Ship {
  String name
  String allegiance
}