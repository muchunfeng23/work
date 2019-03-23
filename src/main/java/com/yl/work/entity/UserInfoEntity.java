package com.yl.work.entity;
import java.io.Serializable;

public class UserInfoEntity  implements Serializable  {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String userName;
	private String identiyCard;
	private String phone;
	private String city;
	private Integer ct;	

	
	public Integer getId(){
		return this.id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}

	
	public String getUserName(){
		return this.userName;
	}
	
	public void setUserName(String userName){
		this.userName = userName;
	}

	
	public String getIdentiyCard(){
		return this.identiyCard;
	}
	
	public void setIdentiyCard(String identiyCard){
		this.identiyCard = identiyCard;
	}

	
	public String getPhone(){
		return this.phone;
	}
	
	public void setPhone(String phone){
		this.phone = phone;
	}

	
	public String getCity(){
		return this.city;
	}
	
	public void setCity(String city){
		this.city = city;
	}

	
	public Integer getCt(){
		return this.ct;
	}
	
	public void setCt(Integer ct){
		this.ct = ct;
	}


	/**
	* 深度复制
	*/
	public  UserInfoEntity deepClone() {
		UserInfoEntity entity = new UserInfoEntity();
		entity.setId(this.getId());
		entity.setUserName(this.getUserName());
		entity.setIdentiyCard(this.getIdentiyCard());
		entity.setPhone(this.getPhone());
		entity.setCity(this.getCity());
		entity.setCt(this.getCt());
		return entity;
	}

	@Override
	public String toString() {
		return "UserInfoEntity{"
        	+ " \"id\":" + this.getId() +","
        	+ " \"userName\":\"" + this.getUserName() +"\","
        	+ " \"identiyCard\":\"" + this.getIdentiyCard() +"\","
        	+ " \"phone\":\"" + this.getPhone() +"\","
        	+ " \"city\":\"" + this.getCity() +"\","
        	+ " \"ct\":" + this.getCt() +""
		+"}";
	}
}