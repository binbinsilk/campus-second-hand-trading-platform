package common.action;

import javax.annotation.Resource;
import org.apache.struts2.ServletActionContext;

import common.service.CommonService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class CommonAction extends ActionSupport {

	@Resource CommonService service;
 
	private static final long serialVersionUID = 1L;
	
	public int start;

	public String pageNum;

	public String numPerPage;
	
	public String orderField;
	
	public String orderDirection;
	
	public void doPaginationStart() {
		pageNum = ServletActionContext.getRequest().getParameter("pageNum");
		numPerPage = ServletActionContext.getRequest().getParameter(
				"numPerPage");

		// 第一次打开列表
		if (pageNum == null || "".equals(pageNum)) {
			pageNum = "1";
		}

		// 默认每页显示20条记录
		if (numPerPage == null || "".equals(numPerPage)) {
			numPerPage = "20";
		}

		start = (Integer.parseInt(pageNum)-1) * Integer.parseInt(numPerPage);
	}

	public void doPaginationEnd(int totalCount) {

		int pageNumShown = (totalCount - 1) % Integer.parseInt(numPerPage) + 1;
		
		int totalPages = 0;
		if(totalCount  % Integer.parseInt(numPerPage)>0)
			totalPages = totalCount/Integer.parseInt(numPerPage)+1;
		else
			totalPages = totalCount/Integer.parseInt(numPerPage);
		ActionContext.getContext().put("pageNum", pageNum);
		ActionContext.getContext().put("numPerPage", numPerPage);
		ActionContext.getContext().put("pageNumShown", pageNumShown);
		ActionContext.getContext().put("totalPages", totalPages);
		ActionContext.getContext().put("totalCount", totalCount);
		ActionContext.getContext().put("orderField", orderField);
		ActionContext.getContext().put("orderDirection", orderDirection);
	}
	

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}
	
	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderDirection() {
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}
}
