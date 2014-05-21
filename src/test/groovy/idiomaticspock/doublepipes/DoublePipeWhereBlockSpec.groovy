package idiomaticspock.doublepipes

import com.google.common.base.CaseFormat
import groovy.transform.CompileStatic
import spock.lang.Specification
import spock.lang.Unroll
import spock.util.mop.Use

import static com.google.common.base.CaseFormat.LOWER_HYPHEN as KEBAB
import static com.google.common.base.CaseFormat.LOWER_UNDERSCORE as SNAKE
import static com.google.common.base.CaseFormat.UPPER_CAMEL as CAMEL
import static com.google.common.base.CaseFormat.UPPER_UNDERSCORE

@Use(StringStyleCategory)
class DoublePipeWhereBlockSpec extends Specification {

  @Unroll("converts '#string' to '#expected' using #style")
  def "can convert case"() {
    expect:
    string.convert(style) == expected

    where:
    string        | style || expected
    "foo bar baz" | CAMEL || "FooBarBaz"
    "foo bar baz" | KEBAB || "foo-bar-baz"
    "foo bar baz" | SNAKE || "foo_bar_baz"
  }

}

@CompileStatic
@Category(String)
class StringStyleCategory {
  String convert(CaseFormat style) {
    UPPER_UNDERSCORE.to(style, this.toString().toUpperCase().replaceAll(/\s+/, "_"))
  }
}
