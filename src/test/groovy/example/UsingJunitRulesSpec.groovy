package example

import org.junit.Rule
import org.junit.rules.TestName
import spock.lang.Specification

/**
 * 테스트 정의 명 호출
 */
class UsingJunitRulesSpec extends Specification {
    @Rule
    TestName name

    def "retrieve test name at runtime"() {
        println "entering '$name.methodName'"
        expect:
        1 + 1 == 2
        println "leaving '$name.methodName'"
    }
}
