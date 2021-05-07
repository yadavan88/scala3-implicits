package com.yadavan88.scala3

class DBContext

def insertUser(name: String): WithDBContext = {
  //use ctx here for db operations
  println(s"User '$name' inserted")
  true
}

def validateUser(name: String): WithDBContext = {
  //use ctx here for db operations
  println(s"User '$name' validated")
  true
}
type WithDBContext = DBContext ?=> Boolean

def addUser(name: String): WithDBContext = {
  if (validateUser(name)) insertUser(name) else false
}

@main
def usage = {
  given ctx: DBContext = new DBContext
  val res: Boolean = addUser("Yadu") //Uses the given context
  println("status = " + res)

  val ctxFn: WithDBContext = addUser("Yadu") //still compiles, compiler doesnt inject the given ctx
}
