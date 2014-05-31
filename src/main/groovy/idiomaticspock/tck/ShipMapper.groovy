package idiomaticspock.tck

import groovy.transform.CompileStatic
import org.skife.jdbi.v2.StatementContext
import org.skife.jdbi.v2.tweak.ResultSetMapper

import java.sql.ResultSet

@CompileStatic
class ShipMapper implements ResultSetMapper<Ship> {
  @Override
  Ship map(int index, ResultSet r, StatementContext ctx) {
    new Ship(name: r.getString("name"), allegiance: r.getString("allegiance"))
  }
}
