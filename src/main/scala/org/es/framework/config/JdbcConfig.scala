package org.es.framework.config

import com.typesafe.config.ConfigFactory
import org.es.framework.dao.SetupJdbc

/**
 * Created by yizuotian on 16-6-16.
 * jdbc配置
 */
object JdbcConfig {
  private lazy val conf = ConfigFactory.load(CommonConfig.get("global.jdbc.conf").get)
  lazy val jdbcDriver = conf.getString("jdbc.driver")
  lazy val jdbcUrl = conf.getString("jdbc.url")
  lazy val jdbcUser = conf.getString("jdbc.user")
  lazy val jdbcPassword = conf.getString("jdbc.password")
  lazy val props={
    val prop = new java.util.Properties
    prop.setProperty("user", jdbcUser)
    prop.setProperty("password", jdbcPassword)
    prop
  }

  def initConnect()=SetupJdbc(jdbcDriver,jdbcUrl,jdbcUser,jdbcPassword)
}
