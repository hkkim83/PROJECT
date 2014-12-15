package kr.co.aegis.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;


abstract public class BaseDAO extends SqlSessionDaoSupport {
	protected final Log logger = LogFactory.getLog(this.getClass());
}
