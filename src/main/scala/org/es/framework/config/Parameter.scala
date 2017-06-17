package org.es.framework.config

import scala.collection.mutable.HashMap
import scala.reflect.runtime.universe.TypeTag

/**
 * Created by yizuotian on 16-4-13.
 * 通用参数类
 */
class Parameter extends Serializable {
    //保存参数键值对
    private lazy val map=new HashMap[String,ValClass[_]]

    /**
     * 参数值类型类
     * @param value_ 值
     * @tparam T
     */
    case class ValClass[T:TypeTag](val value_ : T){
        def getValue():T=value_
    }

    /**
     * 通用设置参数值
     * @param name　参数名
     * @param value　参数值
     * @tparam T 之类型
     */
    def put[T:TypeTag](name:String,value:T):Unit={
        map.put(name,ValClass(value))
    }

    /**
     * 通用获取参数值
     * @param name 参数名
     * @tparam T　值类型
     * @return　
     */
    def get[T](name:String):T={
        map.get(name) match {
            case Some(x:ValClass[T]) => x.getValue()
            case _ => throw new NoSuchElementException("None.get:"+name)
        }
    }
    def getOrConfigValue[T](name:String):T={
        map.get(name) match {
            case Some(x: ValClass[T]) => x.getValue()
            case _ => BusinessConfig.get(name) match {
                case Some(v:String) => v.asInstanceOf[T]
                case _ => throw new NoSuchElementException("None.get:"+name)
            }
        }
    }

    /**
     * 通用获取参数值,带默认值
     * @param name 参数名
     * @param defaultVal　默认值
     * @tparam T　值类型
     * @return
     */
    def getOrElse[T](name:String,defaultVal: =>T):T={
        map.get(name) match {
            case Some(x:ValClass[T]) => x.getValue()
            case None => defaultVal
        }
    }

    def getOrConfigValueOrElse[T](name:String,defaultVal: =>T):T={
        map.get(name) match {
            case Some(x: ValClass[T]) => x.getValue()
            case _ => BusinessConfig.get(name) match {
                case Some(v:String) => v.asInstanceOf[T]
                case _ => defaultVal
            }
        }
    }
}