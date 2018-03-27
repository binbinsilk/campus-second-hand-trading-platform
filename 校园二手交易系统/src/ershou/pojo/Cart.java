package ershou.pojo;

/**
 * Administrator entity. @author MyEclipse Persistence Tools
 */

public class Cart implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private Integer userId;
	private Integer goodsId;
	
	// Constructors

	/** default constructor */
	public Cart() {
	}
	

	public Cart(Integer id, Integer userId, Integer goodsId) {
		super();
		this.id = id;
		this.userId = userId;
		this.goodsId = goodsId;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
}