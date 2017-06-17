package org.es.framework.config

import java.io.InputStream

/**
 * Created by yizuotian on 16-4-13.
 */
object CommonConfig {
  private val confStream:InputStream =getClass.getClassLoader.getResourceAsStream("common.conf")

  //private lazy val kvMap:Map[String,String]=FileOperator.readFileToStrKeyValue(confStream,"=")


  private lazy val props = {
    val prop = new java.util.Properties()
    prop.load(confStream)
    prop
  }
  //部署模式，开发|测试|生产
  private lazy val deployMode=props.getProperty("deployMode")

  /**
   * 不区分部署模式的属性
   * @param key
   * @return
   */
  def getNoModel(key:String):Option[String]=Option(props.getProperty(key))

  /**
   * 区分部署模式的属性
   * @param key
   * @return
   */
  def get(key:String):Option[String]=getNoModel(key).map(x=>{
    val index=x.lastIndexOf("/")
    if(index>=0) {
      val prefix = x.substring(0, index + 1)
      val suffix = x.substring(index + 1)
      prefix + deployMode + "." + suffix
    }else deployMode + "." + x
  })


}
