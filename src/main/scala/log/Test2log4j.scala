package log

import org.apache.log4j.Logger

/**
  * Created by jiangzl on 16/10/2.
  */
class Test2log4j {

}

object Test2log4j {

  val logger = Logger.getLogger(Test2log4j.getClass.getName)

  def main(args: Array[String]) = {
    logger.debug("Hello, this is an debug message")
    logger.info("Hello, this is an info message")
  }

}
