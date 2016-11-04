package scala

/**
  * Created by jiangzl on 2016/10/12.
  */

abstract class Person3{
  def spark
  val name: String
  var age: Int
}

class Student3 extends Person3{
  def spark: Unit = {
    println("Spark !!!")
  }

  val name = "AAA"
  var age = 100
}

object Test12ScalaAbstractClass extends App{
  val s3 = new Student3
  s3.spark

  println(s3.name + ":" + s3.age)

}
