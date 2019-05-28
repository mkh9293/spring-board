package example

import spock.lang.Specification

/**
 * mock 객체 생성 + 호출 횟수 검증
 */
class OrderedInteractionSpec extends Specification {
    def "collaborators must be invoked in order"() {
        def col1 = Mock(Collaborator)
        def col2 = Mock(Collaborator)

        when:
        col1.collaborate()
        col2.collaborate()

        then:
        1 * col1.collaborate()

        then:
        1 * col2.collaborate()
    }
}

interface Collaborator {
    def collaborate()
}
