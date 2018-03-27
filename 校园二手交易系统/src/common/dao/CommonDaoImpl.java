package common.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository //用于标注数据访问组件，即DAO组件
public class CommonDaoImpl implements CommonDao {
	@Resource SessionFactory sessionFactory;

	/**
	 * 通过存储过程查询复杂数据
	 * 
	 * @param procName
	 *            存储过程名称
	 * @param param
	 *            参数
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> queryByProcedure(String sql,Map<String, String> param) {		
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		if (param != null) {
			for (Entry<String, String> e : param.entrySet()) {
				query.setString(e.getKey(), e.getValue());
			}
		}
		return query.list();
	}

	/**
	 *  通过存储过程查询复杂数据(分页)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> queryByProcedure(String procNameSq,
			Map<String, String> param, int start, int size) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery(procNameSq);
		if (param != null) {
			for (Entry<String, String> e : param.entrySet()) {
				query.setString(e.getKey(), e.getValue());
			}			
		}
		if (start != -1 && size != -1) {
			query.setFirstResult(start);
			query.setMaxResults(size);
		}		
		return query.list();
	}



	/**
	 * 执行原生sql查询语句（不分页）
	 * 
	 * @param sql
	 *            sql语句
	 * @param param
	 *            以Map类型包装的参数列表
	 * @return 数组列表类型
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> queryBySql(String sql, Map<String, String> param) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		if (param != null) {
			for (Entry<String, String> e : param.entrySet()) {
				query.setString(e.getKey(), e.getValue());
			}
		}		
		return query.list();
	}

	/**
	 * 执行原生sql查询语句（分页）
	 * 
	 * @param sql
	 *            sql语句
	 * @param param
	 *            以Map类型包装的参数列表
	 * @param start
	 *            分页查询起始位置
	 * @param size
	 *            每页显示数据条数
	 * @return 数组列表类型
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> queryBySql(String sql, Map<String, String> param,
			int start, int size) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		if (param != null) {
			for (Entry<String, String> e : param.entrySet()) {
				query.setString(e.getKey(), e.getValue());
			}
		}
		if (start != -1 && size != -1) {
			query.setFirstResult(start);
			query.setMaxResults(size);
		}
		return query.list();
	}

	/**
	 * 执行原生sql查询记录总条数
	 * 
	 * @param sql
	 *            sql语句
	 * @param param
	 *            以Map类型包装的参数列表
	 * @return 整型记录条数
	 */
	public int queryCountsSql(String sql, Map<String, String> param) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		if (param != null) {
			for (Entry<String, String> e : param.entrySet()) {
				query.setString(e.getKey(), e.getValue());
			}
		}
		return Integer.valueOf(String.valueOf(query.uniqueResult()));
	}

	/**
	 * 执行Hql查询语句（不分页）
	 * 
	 * @param hql
	 *            Hibernate查询语句
	 * @param param
	 *            以Map类型包装的参数列表
	 * @return 对象列表类型
	 */
	public List<?> queryByHql(String hql, Map<String, String> param) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if (param != null) {
			for (Entry<String, String> e : param.entrySet()) {
				query.setString(e.getKey(), e.getValue());
			}
		}
		return query.list();
	}

	/**
	 * 执行Hql查询语句（分页）
	 * 
	 * @param hql
	 *            Hibernate查询语句
	 * @param param
	 *            以Map类型包装的参数列表
	 * @param start
	 *            分页查询起始位置
	 * @param size
	 *            每页显示数据条数
	 * @return 对象列表类型
	 */
	public List<?> queryByHql(String hql, Map<String, String> param, int start,
			int size) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if (param != null) {
			for (Entry<String, String> e : param.entrySet()) {
				query.setString(e.getKey(), e.getValue());
			}
		}

		// 取分页数据
		if (start != -1 && size != -1) {
			query.setFirstResult(start);
			query.setMaxResults(size);
		}
		return query.list();
	}

	/**
	 * 执行Hibernate查询记录总条数
	 * 
	 * @param hql
	 *            Hibernate查询语句
	 * @param param
	 *            以Map类型包装的参数列表
	 * @return 整型记录条数
	 */
	public int queryCounts(String hql, Map<String, String> param) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if (param != null) {
			for (Entry<String, String> e : param.entrySet()) {
				query.setString(e.getKey(), e.getValue());
			}
		}
		return Integer.valueOf(String.valueOf(query.uniqueResult()));
	}

	/**
	 * 查询一条返回结果 当确定返回的实例只有一个或者null时使用
	 * 
	 * @param sql
	 *            原生sql语句
	 * @param param
	 *            以Map类型包装的参数列表
	 * @return 字符串类型
	 */
	public String queryOneColBySql(String sql, Map<String, String> param) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		if (param != null) {
			for (Entry<String, String> e : param.entrySet()) {
				query.setString(e.getKey(), e.getValue());
			}
		}
		return query.uniqueResult() + "";
	}

	/**
	 * 调用Hibernate持久化方法保存对象
	 * 
	 * @param p
	 */
	public void save(Object p) {
		sessionFactory.getCurrentSession().persist(p);
	}

	/**
	 * 调用Hibernate持久化方法修改对象
	 * 
	 * @param p
	 */
	public void update(Object p) {
		sessionFactory.getCurrentSession().merge(p);
	}

	/**
	 * 调用Hibernate持久化方法删除对象
	 * 
	 * @param p
	 */
	public void delete(Object p) {
		sessionFactory.getCurrentSession().delete(p);
	}

	/**
	 * 根据给定的标识符返回给定的实体类的持久化实例，如果持久化实例不存在返回NULL
	 * 
	 * @param c
	 *            实体类的class属性
	 * @param id
	 *            实体类的标识符，一般对应数据表中的主键
	 * @return 返回一个实体类对象
	 */
	public Object getByID(Class<?> c, String id) {
		return sessionFactory.getCurrentSession().get(c, id);
	}

	/**
	 * （重载）根据给定的标识符返回给定的实体类的持久化实例，如果持久化实例不存在返回NULL
	 * 
	 * @param c
	 *            实体类的class属性
	 * @param id
	 *            实体类的标识符，一般对应数据表中的主键
	 * @return 返回一个实体类对象
	 */
	public Object getByID(Class<?> c, int id) {
		return sessionFactory.getCurrentSession().get(c, id);
	}

	/**
	 * 通过sql语句执行某个数据操作
	 * 
	 * @param strSql
	 *            原生sql语句
	 */
	public void executeViaSql(String strSql) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery(strSql);
		query.executeUpdate();
	}

	/**
	 * 获取当前数据库会话Session
	 * @return
	 */
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**************系统相关公共dao方法***************/


}
