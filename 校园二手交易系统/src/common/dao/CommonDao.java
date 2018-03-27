package common.dao;

import java.util.List;
import java.util.Map;

public interface CommonDao {
	
	/**
	 * 通过存储过程查询复杂数据
	 * 
	 * @param procNameSql
	 *            sql语句调用存储过程
	 * @param param
	 *            参数
	 * @return
	 */
	List<Object[]> queryByProcedure(String procNameSq,Map<String,String> param);
	/**
	 * 通过存储过程查询复杂数据 (分页)
	 * @param procNameSql
	 *  			sql语句调用存储过程
	 * @param param
	 * 				参数
	 * @param start
	 * 			
	 * @param size
	 * @return
	 */
	List<Object[]> queryByProcedure(String procNameSq,Map<String,String> param,int start,int size);

	/**
	 * 执行原生sql查询语句（不分页）
	 * 
	 * @param sql
	 *            sql语句
	 * @param param
	 *            以Map类型包装的参数列表
	 * @return 数组列表类型
	 */
	List<Object[]> queryBySql(String sql, Map<String, String> param);

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
	List<Object[]> queryBySql(String sql, Map<String, String> param, int start,
			int size);

	/**
	 * 执行原生sql查询记录总条数
	 * 
	 * @param sql
	 *            sql语句
	 * @param param
	 *            以Map类型包装的参数列表
	 * @return 整型记录条数
	 */
	int queryCountsSql(String sql, Map<String, String> param);

	/**
	 * 执行Hql查询语句（不分页）
	 * 
	 * @param hql
	 *            Hibernate查询语句
	 * @param param
	 *            以Map类型包装的参数列表
	 * @return 对象列表类型
	 */
	List<?> queryByHql(String hql, Map<String, String> param);

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
	List<?> queryByHql(String hql, Map<String, String> param, int start,
			int size);

	/**
	 * 执行Hibernate查询记录总条数
	 * 
	 * @param hql
	 *            Hibernate查询语句
	 * @param param
	 *            以Map类型包装的参数列表
	 * @return 整型记录条数
	 */
	int queryCounts(String hql, Map<String, String> param);

	/**
	 * 查询一条返回结果 当确定返回的实例只有一个或者null时使用
	 * 
	 * @param sql
	 *            原生sql语句
	 * @param param
	 *            以Map类型包装的参数列表
	 * @return 字符串类型
	 */
	String queryOneColBySql(String sql, Map<String, String> param);

	/**
	 * 调用Hibernate持久化方法保存对象
	 * 
	 * @param p
	 */
	void save(Object p);

	/**
	 * 调用Hibernate持久化方法修改对象
	 * 
	 * @param p
	 */
	void update(Object p);

	/**
	 * 调用Hibernate持久化方法删除对象
	 * 
	 * @param p
	 */
	void delete(Object p);

	/**
	 * 根据给定的标识符返回给定的实体类的持久化实例，如果持久化实例不存在返回NULL
	 * 
	 * @param c
	 *            实体类的class属性
	 * @param id
	 *            实体类的标识符，一般对应数据表中的主键
	 * @return 返回一个实体类对象
	 */
	Object getByID(Class<?> c, String id);

	/**
	 * （重载）根据给定的标识符返回给定的实体类的持久化实例，如果持久化实例不存在返回NULL
	 * 
	 * @param c
	 *            实体类的class属性
	 * @param id
	 *            实体类的标识符，一般对应数据表中的主键
	 * @return 返回一个实体类对象
	 */
	Object getByID(Class<?> c, int id);

	/**
	 * 通过sql语句执行某个数据操作
	 * 
	 * @param strSql
	 *            原生sql语句
	 */
	void executeViaSql(String strSql);
	
	
	/**************系统相关公共dao方法***************/
	
}
