package com.digitaltumbleweed.utils.collections.test;

import spock.lang.*

import com.digitaltumbleweed.utils.collections.MultidimensionalList

class TestMultidimensionalList extends Specification {
  def "instantiation with default initialCapacity of 1"() {
    when:
    MultidimensionalList<Integer> list = new MultidimensionalList<Integer>()

    then:
    list instanceof MultidimensionalList
    list.getRowCount() == 1
    list.getColCount() == 1
  }

  def "instantiation with initialCapacity of 10"() {
    when:
    MultidimensionalList<Integer> list = new MultidimensionalList<Integer>(10, 10)

    then:
    list instanceof MultidimensionalList
    list.getRowCount() == 10
    list.getColCount() == 10
  }

  def "set and get"() {
    setup:
    MultidimensionalList<Integer> list = new MultidimensionalList<Integer>()
    
    when:
    list.set(0, 0, 10)

    then:
    list.getRowCount() == 1
    list.getColCount() == 1
    list.get(0, 0) == 10
    list.get(0, 0) != 1
  }

  def "many sets (handle it), and get"() {
    setup:
    MultidimensionalList<Integer> list = new MultidimensionalList<Integer>()
    
    when:
    list.set(0, 0, 10)

    then:
    list.getRowCount() == 1
    list.getColCount() == 1
    list.get(0, 0) == 10
    list.get(0, 0) != 1

    when:
    list.set(0, 0, 1)

    then:
    list.getRowCount() == 1
    list.getColCount() == 1
    list.get(0, 0) == 1
    list.get(0, 0) != 10
  }

  def "set and get 1x5"() {
    setup:
    MultidimensionalList<Integer> list = new MultidimensionalList<Integer>(1, 5)
    
    when:
    list.set(0, 0, 10)
    list.set(0, 1, 0)
    list.set(0, 2, 1)
    list.set(0, 3, 5)
    list.set(0, 4, 8)

    then:
    list.getRowCount() == 1
    list.getColCount() == 5
    list.get(0, 0) == 10
    list.get(0, 1) == 0
    list.get(0, 2) == 1
    list.get(0, 3) == 5
    list.get(0, 4) == 8
    list.toString() == "10 0 1 5 8"
  }

  def "set and get 2x5"() {
    setup:
    MultidimensionalList<Integer> list = new MultidimensionalList<Integer>(2, 5)
    
    when:
    list.set(0, 0, 10)
    list.set(0, 1, 0)
    list.set(0, 2, 1)
    list.set(0, 3, 5)
    list.set(0, 4, 8)
    list.set(1, 0, 2)
    list.set(1, 1, 3)
    list.set(1, 2, 4)
    list.set(1, 3, 5)
    list.set(1, 4, 6)

    then:
    list.getRowCount() == 2
    list.getColCount() == 5
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

  def "set and get 5x5"() {
    setup:
    MultidimensionalList<Integer> list = new MultidimensionalList<Integer>(5, 5)
    
    when:
    list.set(0, 0, 10)
    list.set(0, 1, 0)
    list.set(0, 2, 1)
    list.set(0, 3, 5)
    list.set(0, 4, 8)
    list.set(1, 0, 6)
    list.set(1, 1, 2)
    list.set(1, 2, 4)
    list.set(1, 3, 9)
    list.set(1, 4, 11)
    list.set(2, 0, 0)
    list.set(2, 1, 15)
    list.set(2, 2, 6)
    list.set(2, 3, 8)
    list.set(2, 4, 9)
    list.set(3, 0, 1)
    list.set(3, 1, 0)
    list.set(3, 2, 3)
    list.set(3, 3, 4)
    list.set(3, 4, 2)
    list.set(4, 0, 2)
    list.set(4, 1, 19)
    list.set(4, 2, 4)
    list.set(4, 3, 5)
    list.set(4, 4, 9)

    then:
    list.getRowCount() == 5
    list.getColCount() == 5
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
