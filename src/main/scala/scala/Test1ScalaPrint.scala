package scala

/**
  * Created by jiangzl on 2016/10/30.
  */

case class BookPrint(name: String, author: String)

object Test1ScalaPrint extends App{

  val name = "ApacheCN"
  val age  = 1
  val url  = "www.apache.wiki"
  val book = new BookPrint("ApacheCN", "片刻")

  println("name=" + name, "age=" + age, "url=" + url, "author=" + book.author)
  printf("name=%s, age=%d, url=%s, author=%s\n", name, age, url, book.author)
  println(s"name=$name, age=$age, url=$url, author=${book.author}")
}
