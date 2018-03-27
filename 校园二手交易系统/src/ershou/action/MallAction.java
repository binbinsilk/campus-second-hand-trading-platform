package ershou.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import common.Util.ImageUtil;
import common.action.CommonAction;
import common.object.Result;
import common.service.CommonService;
import ershou.pojo.Cart;
import ershou.pojo.Goods;
import ershou.service.Mall.MallService;

@Controller("MallAction") @Scope("prototype")
public class MallAction extends CommonAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource CommonService commonService;
	@Resource MallService service;
	
	// 上传的文件
	private File filedata;
	// 文件名称
	private String filedataFileName;	
	/**
	 * 查看商城
	 * @return
	 */
	public String toMall(){
		String title = ServletActionContext.getRequest().getParameter("title");
		String type = ServletActionContext.getRequest().getParameter("type");
		doPaginationStart();
		
		Result rs = service.query(type, title, start, Integer.parseInt(numPerPage));
		
		doPaginationEnd(rs.getTotalCount());
		
		ActionContext.getContext().put("list", rs.getDataList());
		ActionContext.getContext().put("title",title);
		ActionContext.getContext().put("type", type);
		return "toMall";
	}
	
	/**
	 * 添加商品到购物车
	 * @return
	 * @throws IOException
	 */
	public void addToCart() throws IOException{
		String goodsId = ServletActionContext.getRequest().getParameter("goodsId");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		try{
			Cart cart = new Cart();
			cart.setGoodsId(Integer.parseInt(goodsId));
			Integer userId = (Integer) ServletActionContext.getRequest().getSession().getAttribute("userId");
			if(userId==null||"".equals(userId)){
				out.println("请先登录");
				out.flush();
				out.close();
			}else{
				cart.setUserId(userId);
				service.save(cart);
				out.println("添加成功");
				out.flush();
				out.close();
			}
		}catch(Exception e){
			e.printStackTrace();
			out.println("添加失败，错误信息："+e.getMessage());
			out.flush();
			out.close();
		}
	}
	
	/**
	 * 查看购物车
	 * @return
	 */
	public String toCart(){
		Integer userId = (Integer) ServletActionContext.getRequest().getSession().getAttribute("userId");
		if(userId==null||"".equals(userId)){
			return "login";
		}
		doPaginationStart();
		
		Result rs = service.queryCart(userId, start, Integer.parseInt(numPerPage));
		
		doPaginationEnd(rs.getTotalCount());
		
		ActionContext.getContext().put("list", rs.getDataList());
		return "toCart";
	}
	
	/**
	 * 删除购物车内商品
	 * @throws IOException 
	 */
	public void deleteCart() throws IOException{
		String id = ServletActionContext.getRequest().getParameter("id");
		Cart cart = (Cart) commonService.getByID(Cart.class, Integer.parseInt(id));
		service.delete(cart);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("删除成功");
		out.flush();
		out.close();
	}
	
	/**
	 * 结算
	 * @throws IOException 
	 */
	public void jiesuan() throws IOException{
		Integer userId = (Integer) ServletActionContext.getRequest().getSession().getAttribute("userId");
		service.jiesuan(userId);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("结算完成");
		out.flush();
		out.close();
	}
	
	/**
	 * 到发布信息页面
	 */
	public String toPublish(){
		Integer userId = (Integer) ServletActionContext.getRequest().getSession().getAttribute("userId");
		if(userId==null||"".equals(userId)){
			return "login";
		}
		return "toPublish";
	}
	
	/**
	 * 发布信息
	 */
	public String publish(){
		Integer userId = (Integer) ServletActionContext.getRequest().getSession().getAttribute("userId");
		String userName = (String) ServletActionContext.getRequest().getSession().getAttribute("userName");
		String title = ServletActionContext.getRequest().getParameter("title");
		String picPath = ServletActionContext.getRequest().getParameter("picPath");
		String price = ServletActionContext.getRequest().getParameter("price");
		String type = ServletActionContext.getRequest().getParameter("type");
		
		Goods good = new Goods();
		good.setPicPath(picPath);
		good.setPrice(Double.parseDouble(price));
		good.setPublishId(userId);
		good.setPublishName(userName);
		good.setTitle(title);
		good.setType(Integer.parseInt(type));
		service.save(good);
		
		return "success";
	}
	
	/**
	 * 上传图片
	 * @throws IOException 
	 */
	public void upload() throws IOException{
		String realpath = ServletActionContext.getServletContext().getRealPath("upload");
		String	extName = filedataFileName.substring(filedataFileName.lastIndexOf("."), filedataFileName.length());
		String name = String.valueOf(new Date().getTime());
            
		File file = new File(new File(realpath), name+extName);
		if (!file.getParentFile().exists())
			file.getParentFile().mkdirs();
			
		FileUtils.copyFile(filedata, file);
		ImageUtil.thumbnailImage(file.getPath(), 255, 255);
		file.delete();
		String picPath = "upload"+"/"+"thumb_"+file.getName();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		out.println(picPath);
		out.flush();
		out.close();
	}

	public File getFiledata() {
		return filedata;
	}

	public void setFiledata(File image) {
		this.filedata = image;
	}

	public String getFiledataFileName() {
		return filedataFileName;
	}

	public void setFiledataFileName(String imageFileName) {
		this.filedataFileName = imageFileName;
	}
}
