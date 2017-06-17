package org.es.cars.config

import org.es.framework.config.{Parameter => CP, BusinessConfig}
/**
 * Created by yizuotian on 16-4-13.
 * 参数配置对象
 */
object Parameter extends CP{
  /**
   * 获取hdfs跟路径
   * @return
   */
  def getHdfsRootUri=BusinessConfig.get("hdfs.uri").get
}
