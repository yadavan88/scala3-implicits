package com.yadavan88.scala2

class Request

def doThis(implicit req:Request): String = {
  "this"
}

def doThat(implicit req:Request): String = {
  "that"
}

def action(fn: Request => String) = {
  val req = new Request
  fn(req)
}

@main def context: Unit = {
  val result = action { implicit req:Request =>
    s"$doThis and $doThat"
  }
  println(result)
}