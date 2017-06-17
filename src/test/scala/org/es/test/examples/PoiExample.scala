package org.es.test.examples

import org.es.framework.util.POIUtil

/**
  * Created by mick.yi on 2017/6/17.
  * POI抽取Word文本
  */
object PoiExample {
  def main(args: Array[String]) {
    val word2003 ="D:\\esspace\\cars-analyze\\src\\main\\resources\\files\\0供电处关于7月24日大西高铁介休东变电所跳闸情况分析.doc"
    println(POIUtil.readFromWord(word2003))

    val word2007 ="D:\\esspace\\cars-analyze\\src\\main\\resources\\files\\2007.docx"
    println(POIUtil.readFromWord(word2007))
  }

}
