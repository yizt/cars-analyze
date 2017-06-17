package org.es.cars.business

import org.apache.spark.SparkContext
import org.es.cars.config.Parameter

/**
  * Created by mick.yi on 2017/6/17.
  */
object Accident {
  def writeToEs(sc:SparkContext): Unit ={
    import org.elasticsearch.spark._
    //获取参数

    val index:String=Parameter.getOrConfigValue("es.index")
    val accidentType:String=Parameter.getOrConfigValue("es.type.accident")



    //初始化两个元素
    val elem1 = Map("title" -> "sparktitle1", "content" -> "接触网跳闸")
    val elem2 = Map("title" -> "sparktitle1", "content" -> "接触网跳闸")
    //写入es
    sc.makeRDD(Seq(elem1, elem2)).
      saveToEs(s"${index}/${accidentType}")
  }

}
