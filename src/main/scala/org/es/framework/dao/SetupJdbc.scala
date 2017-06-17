package org.es.framework.dao

import scalikejdbc.ConnectionPool

/**
 * Created by yizuotian on 16-6-16.
 * 设置jdbc连接
 */

object SetupJdbc {
  def apply(driver: String, jdbcUrl: String, user: String, password: String): Unit = {
    Class.forName(driver)
    ConnectionPool.singleton(jdbcUrl, user, password)
  }
}
