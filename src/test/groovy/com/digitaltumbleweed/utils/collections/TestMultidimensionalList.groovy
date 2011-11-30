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

  def "toString 1x5"() {
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
    list.toString() == "10 0 1 5 8"
  }

  def "toString 2x5"() {
    setup:
    MultidimensionalList<Integer> list = new MultidimensionalList<Integer>(2)
    
    when:
    list.add(0, 10)
    list.add(0, 0)
    list.add(0, 1)
    list.add(0, 5)
    list.add(0, 8)
    list.add(1, 2)
    list.add(1, 3)
    list.add(1, 4)
    list.add(1, 5)
    list.add(1, 6)

    then:
    list.xSize() == 2
    list.ySize(0) == 5
    list.get(0, 0) == 10
    list.get(0, 1) == 0
    list.get(0, 2) == 1
    list.get(0, 3) == 5
    list.get(0, 4) == 8
    list.get(1, 0) == 2
    list.get(1, 1) == 3
    list.get(1, 2) == 4
    list.get(1, 3) == 5
    list.get(1, 4) == 6
    list.toString() == "10 0 1 5 8\n2 3 4 5 6"
  }

  def "toString 5x5"() {
    setup:
    MultidimensionalList<Integer> list = new MultidimensionalList<Integer>(5)
    
    when:
    list.add(0, 10)
    list.add(0, 0)
    list.add(0, 1)
    list.add(0, 5)
    list.add(0, 8)
    list.add(1, 6)
    list.add(1, 2)
    list.add(1, 4)
    list.add(1, 9)
    list.add(1, 11)
    list.add(2, 0)
    list.add(2, 15)
    list.add(2, 6)
    list.add(2, 8)
    list.add(2, 9)
    list.add(3, 1)
    list.add(3, 0)
    list.add(3, 3)
    list.add(3, 4)
    list.add(3, 2)
    list.add(4, 2)
    list.add(4, 19)
    list.add(4, 4)
    list.add(4, 5)
    list.add(4, 9)

    then:
    list.xSize() == 5
    list.ySize(0) == 5
    list.get(0, 0) == 10
    list.get(0, 1) == 0
    list.get(0, 2) == 1
    list.get(0, 3) == 5
    list.get(0, 4) == 8
    list.get(1, 0) == 6
    list.get(1, 1) == 2
    list.get(1, 2) == 4
    list.get(1, 3) == 9
    list.get(1, 4) == 11
    list.get(2, 0) == 0
    list.get(2, 1) == 15
    list.get(2, 2) == 6
    list.get(2, 3) == 8
    list.get(2, 4) == 9
    list.get(3, 0) == 1
    list.get(3, 1) == 0
    list.get(3, 2) == 3
    list.get(3, 3) == 4
    list.get(3, 4) == 2
    list.get(4, 0) == 2
    list.get(4, 1) == 19
    list.get(4, 2) == 4
    list.get(4, 3) == 5
    list.get(4, 4) == 9
    list.toString() == "10 0 1 5 8\n6 2 4 9 11\n0 15 6 8 9\n1 0 3 4 2\n2 19 4 5 9"
  }
}
