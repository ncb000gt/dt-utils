package com.digitaltumbleweed.utils.test

import spock.lang.*

import com.digitaltumbleweed.utils.Range

class TestRange extends Specification {
  def "range from 0 to 5"() {
    when:
    def r = Range.range(5)

    then:
    r.length == 5
    r[0] == 0
    r[1] == 1
    r[2] == 2
    r[3] == 3
    r[4] == 4
  }

  def "range from 2 to 5"() {
    when:
    def r = Range.range(2, 5)

    then:
    r.length == 3
    r[0] == 2
    r[1] == 3
    r[2] == 4
  }

  def "range from 0 to 6 with a step of 2"() {
    when:
    def r = Range.range(0, 6, 2)

    then:
    r.length == 3
    r[0] == 0
    r[1] == 2
    r[2] == 4
  }

  def "range from 2 to 6 with step of 2"() {
    when:
    def r = Range.range(2, 6, 2)

    then:
    r.length == 2
    r[0] == 2
    r[1] == 4
  }

  def "range from 2 to 7 with step of 2"() {
    when:
    def r = Range.range(2, 7, 2)

    then:
    r.length == 3
    r[0] == 2
    r[1] == 4
    r[2] == 6
  }

  def "range from 0 to 9 with step of 3"() {
    when:
    def r = Range.range(0, 9, 3)

    then:
    r.length == 3
    r[0] == 0
    r[1] == 3
    r[2] == 6
  }

  def "range from 3 to 10 with step of 3"() {
    when:
    def r = Range.range(3, 10, 3)

    then:
    r.length == 3
    r[0] == 3
    r[1] == 6
    r[2] == 9
  }
}
