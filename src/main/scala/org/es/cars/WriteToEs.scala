package org.es.cars

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by mick.yi on 2017/6/16.
  * spark写入es
  */
object WriteToEs {
  def main(args: Array[String]) {
    import org.elasticsearch.spark._
    val conf = new SparkConf()
    conf.set("es.nodes", "172.17.109.201").
      set("es.port", "9200").setMaster("local").setAppName("SparkToEs")
    val sc = new SparkContext(conf)

    val elem1 = Map("title" -> "sparktitle1", "content" -> "接触网跳闸")
    val elem2 = Map("title" -> "sparktitle1", "content" -> "接触网跳闸")

    sc.makeRDD(Seq(elem1, elem2)).saveToEs("cars_index/accident")
  }
}
