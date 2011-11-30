package com.digitaltumbleweed.utils.collections.test;

import spock.lang.*

import com.digitaltumbleweed.utils.collections.MultidimensionalList

class TestMultidimensionalList extends Specification {
  def "instantiation"() {
    when:
    MultidimensionalList<Integer> list = new MultidimensionalList<Integer>()

    then:
    list instanceof MultidimensionalList
    list.xSize() == 0
  }
}
