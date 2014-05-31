package idiomaticspock.falsemonicker

import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

import java.time.Year

@CompileStatic
@TupleConstructor
class Ship {
  final String name
  final String allegiance
  final Year enteredService
}
