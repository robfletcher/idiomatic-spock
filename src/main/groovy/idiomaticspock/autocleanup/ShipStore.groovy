package idiomaticspock.autocleanup

import org.skife.jdbi.v2.sqlobject.Bind
import org.skife.jdbi.v2.sqlobject.SqlQuery
import org.skife.jdbi.v2.sqlobject.SqlUpdate
import org.skife.jdbi.v2.sqlobject.customizers.Mapper

interface ShipStore {
  @SqlUpdate("""create table ship (
                       id int primary key auto_increment,
		                   name varchar(32),
		                   allegiance varchar(32))""")
  void createTable()

  @SqlUpdate("drop table ship")
  void dropTable()

  @SqlQuery("select name, allegiance from ship where allegiance = :allegiance")
  @Mapper(ShipMapper)
  Iterator<Ship> findByAllegiance(@Bind("allegiance") String allegiance)
}
