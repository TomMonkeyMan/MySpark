package scala

/**
  * Created by jiangzl on 2016/10/21.
  */

object Test22ScalaMapOption {

  def main(args: Array[String]) {

    val tmp = "a" -> "b"
    println(tmp)

    // Map函数使用
    val m = Map("a" -> "1", "b" -> "2", "c" -> "3")
    val r1 = m.get("a")
    // Option的操作 （处理为空的数据）
    val r2 = m.get("b").getOrElse("None")
    val r3 = m.get("f").getOrElse("None")

    println(s"m=$m, r1=$r1, r2=$r2, r3=$r3")

  }
}
