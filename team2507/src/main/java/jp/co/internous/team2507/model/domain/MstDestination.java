package jp.co.internous.team2507.model.domain;

import java.sql.Timestamp;

import jp.co.internous.team2507.model.form.DestinationForm;

/**
 * mst_destinationのドメイン
 * @author インターノウス
 *
 */
public class MstDestination {

	private int id;
	private int userId;
	private String familyName;
	private String firstName;
	private String address;
	private String telNumber;
	private int status;
	private Timestamp createAt;
	private Timestamp updateAt;

	/**
	 * コンストラクタ
	 */
	public MstDestination () {}
	
	/**
	 * コンストラクタ
	 * @param f 宛先情報フォーム
	 */
	public MstDestination(DestinationForm f) {
		userId = f.getUserId();
		familyName = f.getFamilyName();
		firstName = f.getFirstName();
		telNumber = f.getTelNumber();
		address = f.getAddress();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Timestamp getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}
	public Timestamp getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}
}
