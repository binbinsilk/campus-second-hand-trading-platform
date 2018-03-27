package ershou.service.Index;

import java.util.List;

import ershou.pojo.Goods;
import ershou.pojo.User;

public interface IndexService {

	List<Goods> showIndex();
	
	User login(String account);
	
	void save(User user);
}
