package idiomaticspock.doublepipes

import com.google.common.base.CaseFormat
import groovy.transform.CompileStatic

@CompileStatic
@Category(String)
class StringStyleCategory {
  String convert(CaseFormat style) {
    CaseFormat.UPPER_UNDERSCORE.to(style, this.toString().toUpperCase().replaceAll(/\s+/, "_"))
  }
}
