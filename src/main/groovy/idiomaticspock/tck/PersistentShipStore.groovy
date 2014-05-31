package idiomaticspock.tck

import com.google.common.collect.ImmutableCollection
import org.skife.jdbi.v2.sqlobject.Bind
import org.skife.jdbi.v2.sqlobject.BindBean
import org.skife.jdbi.v2.sqlobject.SqlQuery
import org.skife.jdbi.v2.sqlobject.SqlUpdate
import org.skife.jdbi.v2.sqlobject.customizers.Mapper
import org.skife.jdbi.v2.sqlobject.customizers.RegisterContainerMapper

interface PersistentShipStore extends ShipStore {
  @SqlUpdate("""create table ship (
                       id int primary key auto_increment,
		                   name varchar(32),
		                   allegiance varchar(32))""")
  void createTable()

  @SqlUpdate("drop table ship")
  void dropTable()

  @SqlUpdate("insert into ship (name, allegiance) values (:name, :allegiance)")
  @Override
  void insert(@BindBean Ship ship)

  @SqlQuery("select name, allegiance from ship")
  @Mapper(ShipMapper)
  @RegisterContainerMapper(ImmutableCollectionContainerBuilderFactory)
  @Override
  ImmutableCollection<Ship> list()

  @SqlQuery("select name, allegiance from ship where allegiance = :allegiance")
  @Mapper(ShipMapper)
  @RegisterContainerMapper(ImmutableCollectionContainerBuilderFactory)
  @Override
  ImmutableCollection<Ship> findByAllegiance(@Bind("allegiance") String allegiance)
}
