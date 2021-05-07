package com.yadavan88.scala3

extension (
    str: String
) def abbreviate = str.split("\\s").map(_.head.toUpper).mkString //doesnt care about exceptions for now

extension [A](list: List[A]) def second: Option[A] = list.tail.headOption

extension [A, B](tuple: Tuple2[A, B])(using a: Numeric[A], b: Numeric[B])
  def +(that: Tuple2[A, B]) = {
    (a.plus(tuple._1, that._1), b.plus(tuple._2, that._2))
  }

extension [A: Numeric, B: Numeric](tuple: Tuple2[A, B])
  def -(that: Tuple2[A, B]) = {
    val a = summon[Numeric[A]]
    val b = summon[Numeric[B]]
    (a.minus(tuple._1, that._1), b.minus(tuple._2, that._2))
  }

@main def extensionMethod: Unit =
  println("Jean Luc Picard".abbreviate) // JLP
  println(List("Seven of Nine", "James T Kirk", "Q").second) // Option(James T Kirk)
  println((1, 2.5) + (2, 4)) // (3,6.5)
  println((5, 2) - (2, 1)) // (3,1)
