package ershou.service.Mall;

import common.object.Result;
import ershou.pojo.Cart;
import ershou.pojo.Goods;

public interface MallService {

	Result query(String type,String title,int start,int size);
	
	void save(Cart cart);
	
	Result queryCart(Integer userId,int start,int size);
	
	void delete(Cart cart);
	
	void jiesuan(Integer userId);
	
	void save(Goods good);
}
