package org.es.test.examples

import org.apache.spark.{SparkConf, SparkContext}
import org.es.cars.business.Accident
import org.es.cars.config.Parameter

/**
  * Created by mick.yi on 2017/6/17.
  * spark写入es样例
  */
object SparkToEsExample {
  def main(args: Array[String]) {
    //获取参数
    val master=args(0)
    val appName=args(1)
    val esNodes=Parameter.getOrConfigValue[String]("es.nodes")
    val esPort=Parameter.getOrConfigValue[String]("es.port")
    //初始化sparkContext
    val sparkConf=new SparkConf
    sparkConf.
      set("es.nodes",esNodes).
      set("es.port",esPort)
    sparkConf.setMaster(master)
    sparkConf.setAppName(appName)
    val sc=new SparkContext(sparkConf)

    //调用业务类
    Accident.writeToEs(sc)
  }

}
