package example

import spock.lang.Specification

import java.math.RoundingMode

class FisrtSpockTest extends Specification {
    def "495를 원단위로 반올림하면 500이 된다"() {
        given:
        BigDecimal 금액 = BigDecimal.valueOf(495)

        when:
        BigDecimal 원단위_반올림 = 금액.setScale(-1, RoundingMode.HALF_UP)

        then:
        원단위_반올림 == 500
    }

    def "computing the maximum of two numbers"() {
        expect:
        Math.max(a, b) == c

        where:
        a | b | c
        5 | 1 | 5
        3 | 9 | 9
    }
}