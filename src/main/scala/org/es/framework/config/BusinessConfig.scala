package org.es.framework.config

/**
 * Created by yizuotian on 16-5-23.
 * 业务参数配置获取
 */
object BusinessConfig {
  private lazy val confStream = getClass.getClassLoader.getResourceAsStream(CommonConfig.get("global.busi.conf").get)

  private lazy val props = {
    val prop = new java.util.Properties()
    prop.load(confStream)
    prop
  }

  def get(key:String)=Option(props.getProperty(key)).map(x=>new String( x.getBytes("ISO-8859-1"),"utf8" ))

  def getJarPath=get("jar.path").get

}
