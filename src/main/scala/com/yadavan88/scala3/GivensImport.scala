package com.yadavan88.scala3

import scala.concurrent.Future
import scala.concurrent.ExecutionContext

object Scope:
  given ctx: ExecutionContext = ExecutionContext.Implicits.global
  given flag: Boolean = true
  def foo(using flag: Boolean) = println("foo with flag")
  def printer(msg: String) = println("Hello, " + msg)

@main def givenImport: Unit =
  import Scope._
  //val future = Future(100) // cant find ExecutionContext, even with Scope._ import
  printer("World") //printer method is accessible using import
  import Scope.ctx
  val future = Future(100) // Now accessible due to Scope.ctx import
  //foo // will not compile
  import Scope.given
  foo // print "foo with flag" since all givens are imported using import Scope.given
