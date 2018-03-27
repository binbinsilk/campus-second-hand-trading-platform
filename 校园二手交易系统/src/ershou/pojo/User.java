package ershou.pojo;

/**
 * Administrator entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private String userName;
	private String account;
	private String password;

	// Constructors

	/** default constructor */
	public User() {
	}
	
	public User(Integer id, String userName, String account, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.account = account;
		this.password = password;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}