package com.digitaltumbleweed.utils.collections.test

import spock.lang.*

import com.digitaltumbleweed.utils.collections.ListUtils

class TestListUtils extends Specification {
  def "combine list of integers"() {
    expect:
    ListUtils.combineInts(l) == s

    where:
    l | s
    [1,2,3,4] | 10
    [0, 0, 0, 0] | 0
    [] | 0
  }

  def "is list unique"() {
    expect:
    ListUtils.isUnique(l) == s

    where:
    l | s
    [1,2,3,4] | true 
    [0, 0, 0, 0] | false
    [] | true
    ["a", "b", "c"] | true
    ["a", "a", "c"] | false
    ["", "", ""] | false
  }
}
