package ershou.service.Index;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.dao.CommonDao;

import ershou.pojo.Goods;
import ershou.pojo.User;
@Service @Transactional
public class IndexServiceImpl implements IndexService {

	@Resource CommonDao commonDao;
	
	/**
	 * 展示首页信息
	 */
	@SuppressWarnings("unchecked")
	public List<Goods> showIndex() {
		Map<String,String> param = new Hashtable<String,String>();
		StringBuffer buffer = new StringBuffer();
		buffer.append("from Goods where 1=1");
		buffer.append(" order by id desc");
		List<Goods> list = (List<Goods>) commonDao.queryByHql(buffer.toString(), param,0,7);
		return list;
	}

	/**
	 * 登录
	 */
	@SuppressWarnings("unchecked")
	public User login(String account) {
		Map<String,String> param = new Hashtable<String,String>();
		StringBuffer buffer = new StringBuffer();
		buffer.append("from User where account=:account");
		param.put("account", account);
		List<User> list = (List<User>) commonDao.queryByHql(buffer.toString(), param);
		if(list.size()>0)
			return list.get(0);
		return null;
	}

	/**
	 * 注册
	 */
	public void save(User user) {
		if(user!=null)
			commonDao.save(user);
	}

}
