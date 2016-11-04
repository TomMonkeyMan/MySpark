package scala

/**
  * Created by jiangzl on 2016/10/20.
  */

// class对象设置为private，那就就外部就无法 new ApplyTest15
class ApplyTest15 private{
  def apply() = "Class _"

  var count : Int = 0
  def incr = {
    count = count + 1
  }
}

object ApplyTest15{
  var applyTest15: ApplyTest15 = _
  //默认调用 apply方法 进行初始化对象
  def apply() = if (applyTest15 == null) {applyTest15 = new ApplyTest15; applyTest15} else applyTest15
}

object Test15ScalaSingleton extends App{

  // 类名 new的对象 ＋ 括号, 都会调用apply方法
  // 类名加括号, 表示 调用  ApplyTest_Object的 apply方法
  val a1 = ApplyTest15()  // 调用Object中apply方法，初始化对象
  println(a1)    //表示调用
  println(a1.count)
  a1.incr
  println(a1.count)
  println("-------------")

  val a2 = ApplyTest15()  // 调用Object中apply方法，初始化对象
  println(a2)    //表示调用
  println(a2.count)
  a2.incr
  println(a2.count)
  println("-------------")


//  // 这个是真的在new 对象  // 去掉class对象的private，就可以new对象了
//  val b = new ApplyTest15()  // ()可以省略
//  println(b)    //表示调用
//  println(b())  // 对象b加括号, 表示调用 ApplyTest_Class的 apply方法
//  println(b.count)
//  b.incr
//  println(b.count)

}
