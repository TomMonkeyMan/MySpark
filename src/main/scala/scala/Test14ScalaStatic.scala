package scala

/**
  * Created by jiangzl on 2016/10/20.
  */

object ApplyTest{
  /*
   * spark 没有静态方法，不过通过object可以实现
   * 1.spark 没有 static的静态方法，所以声明static 不会报错，因为不是关键字
  */
  def static1: Unit = {
    println("I‘m a static1 mothod")
  }

  def static2: Unit = {
    println("I‘m a static2 mothod")
  }

  // 声明静态变量 count=0
  var count: Int = 0
  def incr = {
    count = count + 1
  }
}


// 特质App
//object Test14ScalaStatic extends App{
//  ApplyTest.static1
//}

object Test14ScalaStatic {
  def main(args: Array[String]) {
    ApplyTest.static1
    ApplyTest.static2

    //静态变量
    println("-------------")
    for(i <- 1 to 10){
      ApplyTest.incr
    }
    println(ApplyTest.count)
  }
}
