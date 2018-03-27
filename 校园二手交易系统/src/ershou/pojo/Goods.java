package ershou.pojo;

/**
 * Administrator entity. @author MyEclipse Persistence Tools
 */

public class Goods implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private String picPath;
	private Integer type;
	private String title;
	private double price;
	private Integer publishId;
	private String publishName;

	// Constructors

	/** default constructor */
	public Goods() {
	}
	

	public Goods(Integer id, String picPath, Integer type, String title,
			double price, Integer publishId, String publishName) {
		super();
		this.id = id;
		this.picPath = picPath;
		this.type = type;
		this.title = title;
		this.price = price;
		this.publishId = publishId;
		this.publishName = publishName;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getPublishId() {
		return publishId;
	}

	public void setPublishId(Integer publishId) {
		this.publishId = publishId;
	}

	public String getPublishName() {
		return publishName;
	}

	public void setPublishName(String publishName) {
		this.publishName = publishName;
	}
}