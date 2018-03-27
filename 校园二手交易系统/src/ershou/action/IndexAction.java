package ershou.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import common.action.CommonAction;
import common.service.CommonService;
import ershou.pojo.Goods;
import ershou.pojo.User;
import ershou.service.Index.IndexService;

@Controller("IndexAction") @Scope("prototype")
public class IndexAction extends CommonAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource CommonService commonService;
	@Resource IndexService service;
	
	/**
	 * 首页展示信息
	 */
	public String toIndex(){
		List<Goods> list = service.showIndex();
		ActionContext.getContext().put("list", list);
		return "main";
	}
	
	/**
	 * 登录
	 */
	public String login(){
		String account = ServletActionContext.getRequest().getParameter("account");
		String password = ServletActionContext.getRequest().getParameter("password");
		if(account==null||"".equals(account)){
			ActionContext.getContext().put("errorMsg", "请输入账号");
			return INPUT;
		}
		if(password==null||"".equals(password)){
			ActionContext.getContext().put("errorMsg", "请输入密码");
			return INPUT;
		}
		User user = service.login(account);
		if(user==null){
			ActionContext.getContext().put("errorMsg", "账号不存在");
			return INPUT;
		}
		if(!password.equals(user.getPassword())){
			ActionContext.getContext().put("errorMsg", "密码错误");
			return INPUT;
		}
		ActionContext.getContext().getSession().put("userId", user.getId());
		ActionContext.getContext().getSession().put("userName", user.getUserName());
		
		return "main";
	}
	
	/**
	 * 到注册页面
	 */
	public String toReg(){
		return "reg";
	}
	
	/**
	 * 注册
	 */
	public String reg(){
		String account = ServletActionContext.getRequest().getParameter("account");
		String password = ServletActionContext.getRequest().getParameter("password");
		String userName = ServletActionContext.getRequest().getParameter("userName");
		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		user.setUserName(userName);
		service.save(user);
		return "input";
	}
	
	/**
	 * 关于我们
	 */
	public String toUs(){
		return "toUs";
	}
}
