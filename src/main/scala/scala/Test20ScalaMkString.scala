package scala

/**
  * Created by jiangzl on 2016/10/21.
  */

object Test20ScalaMkString {

  // mkString的使用
  // 格式化输出
  def formatArgs(args: Array[String]) = args.mkString("\n")
  def main(args: Array[String]) {
    // 函数调用,打印输出
    println(formatArgs(args))
    val res = formatArgs(Array("zero", "one", "two"))
    println(s"res=$res")
    // Scala的assert方法检查传入的Boolean并且如果是假，抛出AssertionError。
    // 如果传入的Boolean是真，assert只是静静地返回
    assert(res == "zero\none\ntwo" )
  }
}
