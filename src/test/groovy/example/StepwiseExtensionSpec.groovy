package example

import spock.lang.Specification
import spock.lang.Stepwise

/**
 * step 순서대로 테스트케이스 실행
 */
@Stepwise
class StepwiseExtensionSpec extends Specification {
    def "step 1"() {
        expect: true
    }

    def "step 2"() {
        expect: true
    }

    def "step 3"() {
        expect: true
    }
}
