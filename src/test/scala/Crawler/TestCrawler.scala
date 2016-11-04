package Crawler

import org.jsoup.Jsoup
import org.jsoup.select.Elements

import scala.util.matching.Regex

/**
  * Created by jiangzl on 2016/10/21.
  */

object TestCrawler {
  def main(args: Array[String]) {

    val HTMLSTring = "<!DOCTYPE html>" +
      "<html>" +
      "<head>" +
        "<title>JSoup Example</title>" +
      "</head>" +
      "<body>" +
        "<img class=\"height_min\" title=\"新买的床单好看吗\" alt=\"新买的床单好看吗\" onerror=\"img_error(this);\" src=\"http://ww3.sinaimg.cn/bmiddle/0060lm7Tgw1f8xja877f1j30dw0iiq4i.jpg\">" +
        "<img class=\"height_min\" title=\"94 妹子征靠谱大叔\" alt=\"94 妹子征靠谱大叔\" onerror=\"img_error(this);\" src=\"http://ww1.sinaimg.cn/bmiddle/0060lm7Tgw1f8xiy20mkzj30dw0dv402.png\" />" +
        "<img class=\"height_min\" title=\"94 妹子征靠谱大叔\" alt=\"94 妹子征靠谱大叔\" onerror=\"img_error(this);\" src=\"http://ww1.sinaimg.cn/bmiddle/0060lm7Tgw1f8xiy20mkzj30dw0dv402.jpg\" />" +
        "<h1>HelloWorld</h1>" +
        "<h1>HelloWorld2</h1>" +
      "</body>" +
      "</html>"

    val html = Jsoup.parse(HTMLSTring)
    val title = html.title()
    val h1 = html.body().getElementsByTag("h1").text()


//    val imgs = html.select("img").toString()
    val imgs = html.select("img[src$=.jpg]").toString().split("\n")
    val regex = new Regex("""(.+)(http://.+)\">""")

    imgs.foreach(img => {
      var regex(begin, url) = img
      url = url.replaceAll("bmiddle", "large")
      val name = url.split("/").last
      println(s"url=$url, name=$name")
    })
    println(s"title=$title, h1=$h1, img=$imgs")

//    var urls: List[String] = List()
//    var url = ""
//    for (index <- 1 to 10 ) {
//      url = "http://www.kanmeizi.cn/index_"+ index+"_16.html"
//      urls = urls.:+(url)
//    }
//    println(urls)
//    urls.foreach(println)

//      http://www.kanmeizi.cn/index_3_16.html


  }
}
