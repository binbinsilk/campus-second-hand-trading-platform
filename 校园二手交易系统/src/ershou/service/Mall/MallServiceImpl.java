package ershou.service.Mall;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.dao.CommonDao;
import common.object.Result;
import ershou.pojo.Cart;
import ershou.pojo.Goods;
@Service @Transactional
public class MallServiceImpl implements MallService {

	@Resource CommonDao commonDao;
	
	/**
	 * 查询商品
	 */
	public Result query(String type, String title, int start, int size) {
		Map<String,String> param = new Hashtable<String,String>();
		StringBuffer buffer = new StringBuffer();
		buffer.append("from Goods where 1=1");
		if(type!=null&&!"".equals(type)){
			buffer.append(" and type =:type");
			param.put("type", type);
		}
		if(title!=null&&!"".equals(title)){
			buffer.append(" and title like :title");
			param.put("title", "%"+title+"%");
		}
		buffer.append(" order by id desc");
		int totalCount = commonDao.queryCounts(
				"select count(*) " + buffer.toString(), param);
		List<?> list = commonDao.queryByHql(buffer.toString(), param,start,size);
		return new Result(totalCount,list);
	}

	/**
	 * 添加购物车
	 */
	public void save(Cart cart) {
		if(cart!=null){
			commonDao.save(cart);
		}
	}


	/**
	 * 查询购物车
	 */
	public Result queryCart(Integer userId, int start, int size) {
		Map<String,String> param = new Hashtable<String,String>();
		StringBuffer buffer = new StringBuffer();
		buffer.append("select b.id,a.pic_path,a.title,a.price,a.publish_name " +
				" from goods a right join cart b on a.id=b.goods_id where b.user_id" +
				" =:userId");
		param.put("userId", userId.toString());
		int totalCount = commonDao.queryCountsSql("select count(*) from ( "+buffer.toString()+") tmp", param);
		List<Object[]> list = commonDao.queryBySql(buffer.toString(), param,start, size);
		return new Result(totalCount,list);
	}

	/**
	 * 删除购物车内商品
	 */
	public void delete(Cart cart) {
		if(cart!=null)
			commonDao.delete(cart);
	}

	/**
	 * 结算（清空购物车）
	 */
	public void jiesuan(Integer userId) {
		Map<String,String> param = new Hashtable<String,String>();
		StringBuffer buffer = new StringBuffer();
		buffer.append("delete from cart where user_id =:userId");
		param.put("userId", userId.toString());
		commonDao.executeViaSql(buffer.toString());
	}

	/**
	 * 保存发布信息
	 */
	public void save(Goods good) {
		if(good!=null)
			commonDao.save(good);
	}

}
