package idiomaticspock.datadriving

import java.sql.Connection
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll
import org.skife.jdbi.v2.DBI
import org.skife.jdbi.v2.Handle

class PrimaryKeySpec extends Specification {
  @Shared @AutoCleanup Handle handle
  @Shared Collection<String> tableNames = []

  def setupSpec() {
    handle = DBI.open("jdbc:h2:mem:test")
    createTables()

    handle.connection.with { connection ->
      def rs = connection.metaData.getTables(null, null, "%", ["TABLE"] as String[])
      while (rs.next()) {
        tableNames << rs.getString(3)
      }
    }
  }

  def cleanupSpec() {
    dropTables()
  }

  @Unroll
  def "the #table table has a primary key"() {
    expect:
    with(handle.connection) { Connection connection ->
      connection.metaData.getPrimaryKeys(null, null, table).next()
    }

    where:
    table << tableNames
  }

  private void createTables() {
    ["foo", "bar", "baz"].each {
      handle.createStatement("create table $it (id char(32) primary key, name varchar(255))")
        .execute()
    }
  }

  private void dropTables() {
    tableNames.each {
      handle.createStatement("drop table $it").execute()
    }
  }
}
