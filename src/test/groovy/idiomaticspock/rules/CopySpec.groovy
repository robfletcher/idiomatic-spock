package idiomaticspock.rules

import org.junit.Rule
import org.junit.rules.TemporaryFolder
import spock.lang.Specification

class CopySpec extends Specification {

  @Rule TemporaryFolder temporaryFolder = new TemporaryFolder()

  def "can copy a resource from classpath to a file"() {
    given:
    def resource = getClass().getResource("/test.txt")
    def file = temporaryFolder.newFile()

    when:
    resource.withReader { file << it }

    then:
    file.text == resource.text
  }
}
