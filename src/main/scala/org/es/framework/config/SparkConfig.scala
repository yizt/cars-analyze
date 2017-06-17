package org.es.framework.config

import org.apache.spark.{SparkConf, SparkContext}

/**
 * 该结构是加载Spark的相关配置信息
 */
object SparkConfig {
  private val sparkConf: SparkConf = new SparkConf()
  private var sparkContext: SparkContext = null

  /**
   * 初始化Spark的上下文
   */
  def init(master: String) = {
    sparkConf.setMaster(master)
    sparkContext = new SparkContext(sparkConf)
    sparkContext
  }
  /**
   * 获取Spark的配置
   */
  def getSparkConf() = {
    sparkConf
  }

  /**
   * 获取Spark的上下文
   */
  def getSparkContext() = {
    sparkContext
  }

  /**
   * 关闭SparkContext的上下文
   */
  def closeSparkContext() = {
    if (sparkContext != null) {
      sparkContext.stop()
    }
  }

  /**
   * 初始化Spark的上下文
   */
  def init(master: String, appName: String) = {
    sparkConf.setMaster(master)
    sparkConf.setAppName(appName)
    sparkContext = new SparkContext(sparkConf)
    sparkContext
  }
}