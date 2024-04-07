package exercises

object LogSystem extends App{
  class Logger(val msgNum : Integer = 0) {
    def info: Logger = {
      println("INFO New Message")
      new Logger(msgNum = msgNum + 1)
    }

    def info(n : Integer) : Logger = {
      if(n <= 0) this
      else info.info(n-1)
    }

    def print: Unit = println(msgNum)
  }

  val logger = new Logger()
  logger.info.print
  logger.info.info.info.print
  logger.info.info.info.print

}
