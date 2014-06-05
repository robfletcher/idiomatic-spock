package idiomaticspock.starships

import groovy.transform.CompileStatic
import org.skife.jdbi.v2.StatementContext
import org.skife.jdbi.v2.tweak.ResultSetMapper

import java.sql.ResultSet
import java.time.Year

@CompileStatic
class ShipMapper implements ResultSetMapper<Ship> {
  @Override
  Ship map(int index, ResultSet r, StatementContext ctx) {
    new Ship(r.getString("name"), r.getString("allegiance"), Year.of(r.getInt("entered_service")))
  }
}
