package idiomaticspock.starships

import org.skife.jdbi.v2.SQLStatement
import org.skife.jdbi.v2.sqlobject.Binder
import org.skife.jdbi.v2.sqlobject.BinderFactory
import org.skife.jdbi.v2.sqlobject.BindingAnnotation

import java.lang.annotation.*

@BindingAnnotation(BindShip.ShipBinderFactory)
@Retention(RetentionPolicy.RUNTIME)
@Target([ElementType.PARAMETER])
public @interface BindShip {

  static class ShipBinderFactory implements BinderFactory {
    @Override
    Binder build(Annotation annotation) {
      { SQLStatement<?> q, BindShip bind, Ship arg ->
        q.bind "name", arg.name
        q.bind "allegiance", arg.allegiance
        q.bind "enteredService", arg.enteredService.value
      }
    }
  }

}