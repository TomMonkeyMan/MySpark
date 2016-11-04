package scala

/**
  * Created by jiangzl on 2016/10/11.
  */
object Test4ScalaLoop {
  def main(args: Array[String]) {

    val chars = "asdfghjkl"

    // 考虑下面这个改自于while循环例子，它使用了var并因此属于 指令式风格：
    println("循环1：")
    // var (i, j) = (0, 10)  多变量赋值
    var i = 0
    while (i < chars.length){
      println(chars(i))
      i += 1
    }


    // 你可以通过去掉var的办法把这个代码变得更 函数式风格，例如，像这样
    println("循环2：")
    for (char <- chars){
      println(char)
    }


    println("循环3：")
    // 1 to 10   表示  1.to(10)
    for (num <- 1 to 10 if num % 2 == 0){
      println(num)
    }


    println("循环4：")
    chars.foreach(println)
  }
}
