package scala

/**
  * Created by jiangzl on 2016/10/11.
  */

object Test2ScalaAssignment {
  def main(args: Array[String]) {
//    // 使用情况，例如婚庆网站： 男／女 性别这些信息赋值后，就不应该修改。
//    val gender="男"
//    println("性别:" , gender)
//    println("性别:" + gender)
//    println(s"性别:$gender")
//    // gender = "女"

    // 使用情况，例如QQ，很多人用来交易买卖： 男／女 性别这些信息是支持修改的。
    var gender="男"
    println("性别:" , gender)
//    println("性别:" + gender)
    println(s"性别:$gender")
    gender = "女"
    println(s"---性别:$gender")
  }
}
