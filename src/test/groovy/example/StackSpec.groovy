package example

import spock.lang.Specification

/**
 * stack 테스트 (element 0)
 */
class EmptyStackSpec extends Specification {
    def stack = new Stack()

    def "size"() {
        expect:
        stack.size() == 0
    }

    def "pop"() {
        when:
        stack.pop()
        then:
        thrown(EmptyStackException)
    }

    def "peek"() {
        when:
        stack.peek()
        then:
        thrown(EmptyStackException)
    }

    def "push"() {
        when:
        stack.push("elem")

        then:
        stack.size() == old(stack.size()) + 1
        stack.peek() == "elem"
    }
}

/**
 * stack 테스트 (element 1)
 */
class StackWithOneElementSpec extends Specification {
    def stack = new Stack()

    def setup() {
        stack.push("elem")
    }

    def "size"() {
        expect:
        stack.size() == 1
    }

    def "pop"() {
        when:
        def x = stack.pop()

        then:
        x == "elem"
        stack.size() == 0
    }

    def "peek"() {
        when:
        def x = stack.peek()

        then:
        x == "elem"
        stack.size() == 1
    }

    def "push"() {
        when:
        stack.push("elem2")

        then:
        stack.size() == 2
        stack.peek() == "elem2"
    }
}

/**
 * stack 테스트 (element 3)
 */
class StackWithThreeElementStack extends Specification {
    def stack = new Stack()

    def setup() {
        ["elem1", "elem2", "elem3"].each { stack.push(it) }
    }

    def "size"() {
        expect:
        stack.size() == 3
    }

    def "pop"() {
        expect:
        stack.pop() == "elem3"
        stack.pop() == "elem2"
        stack.pop() == "elem1"
        stack.size() == 0
    }

    def "peek"() {
        expect:
        stack.peek() == "elem3"
        stack.peek() == "elem3"
        stack.peek() == "elem3"
        stack.size() == 3
    }

    def "push"() {
        when:
        stack.push("elem4")

        then:
        stack.size() == 4
        stack.peek() == "elem4"
    }
}
