package com.digitaltumbleweed.utils.collections.test;

import spock.lang.*

import com.digitaltumbleweed.utils.collections.MultidimensionalList

class TestMultidimensionalList extends Specification {
  def "instantiation with default initialCapacity of 1"() {
    when:
    MultidimensionalList<Integer> list = new MultidimensionalList<Integer>()

    then:
    list instanceof MultidimensionalList
    list.xSize() == 1
  }

  def "instantiation with initialCapacity of 10"() {
    when:
    MultidimensionalList<Integer> list = new MultidimensionalList<Integer>(10)

    then:
    list instanceof MultidimensionalList
    list.xSize() == 10
  }

  def "add and get"() {
    setup:
    MultidimensionalList<Integer> list = new MultidimensionalList<Integer>()
    
    when:
    list.add(0, 10)

    then:
    list.ySize(0) == 1
    list.get(0, 0) == 10
    list.get(0, 0) != 1
  }

  def "add, set, and get"() {
    setup:
    MultidimensionalList<Integer> list = new MultidimensionalList<Integer>()
    
    when:
    list.add(0, 10)

    then:
    list.ySize(0) == 1
    list.get(0, 0) == 10
    list.get(0, 0) != 1

    when:
    list.set(0, 0, 1)

    then:
    list.ySize(0) == 1
    list.get(0, 0) == 1
    list.get(0, 0) != 10
  }

  def "add and get with 5 elements"() {
    setup:
    MultidimensionalList<Integer> list = new MultidimensionalList<Integer>()
    
    when:
    list.add(0, 10)
    list.add(0, 0)
    list.add(0, 1)
    list.add(0, 5)
    list.add(0, 8)

    then:
    list.xSize() == 1
    list.ySize(0) == 5
    list.get(0, 0) == 10
    list.get(0, 1) == 0
    list.get(0, 2) == 1
    list.get(0, 3) == 5
    list.get(0, 4) == 8
  }

  def "add, set, and get with 5 elements"() {
    setup:
    MultidimensionalList<Integer> list = new MultidimensionalList<Integer>()
    
    when:
    list.add(0, 10)
    list.add(0, 0)
    list.add(0, 1)
    list.add(0, 5)
    list.add(0, 8)

    then:
    list.xSize() == 1
    list.ySize(0) == 5
    list.get(0, 0) == 10
    list.get(0, 1) == 0
    list.get(0, 2) == 1
    list.get(0, 3) == 5
    list.get(0, 4) == 8

    when:
    list.set(0, 0, 1)

    then:
    list.ySize(0) == 5
    list.get(0, 0) == 1
    list.get(0, 0) != 10
    list.get(0, 1) == 0
    list.get(0, 2) == 1
    list.get(0, 3) == 5
    list.get(0, 4) == 8

    when:
    list.set(0, 3, 7)

    then:
    list.ySize(0) == 5
    list.get(0, 0) == 1
    list.get(0, 0) != 10
    list.get(0, 1) == 0
    list.get(0, 2) == 1
    list.get(0, 3) == 7
    list.get(0, 3) != 5
    list.get(0, 4) == 8
  }
}
