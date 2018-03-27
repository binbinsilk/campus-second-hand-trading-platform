package common.object;

import java.util.List;

public class Result {
	private int totalCount;
	private List<?> dataList;
	
	
	public Result() {
	}
	
	public Result(int totalCount, List<?> dataList) {
		super();
		this.totalCount = totalCount;
		this.dataList = dataList;
	}
	
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<?> getDataList() {
		return dataList;
	}
	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}
}
