package common.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.dao.CommonDao;
@Service  @Transactional
public class CommonServiceImpl implements CommonService {
 
	@Resource CommonDao commonDao;

	/**
	 * 根据给定的标识符返回给定的实体类的持久化实例，如果持久化实例不存在返回NULL
	 * 
	 * @param c
	 *            实体类的class属性
	 * @param id
	 *            实体类的标识符，一般对应数据表中的主键
	 * @return 返回一个实体类对象
	 */
	@Override
	public Object getByID(Class<?> c, String id) {
		return commonDao.getByID(c, id);
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
	@Override
	public Object getByID(Class<?> c, int id) {
		return commonDao.getByID(c, id);
	}
}
