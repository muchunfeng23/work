package com.yl.work.entity;
import java.io.Serializable;

public class WxUserEntity  implements Serializable  {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String openId;
	private String nickName;
	private Integer gender;
	private String language;
	private String city;
	private String province;
	private String country;
	private String avatarUrl;
	private Integer ct;
	private Integer datekey;

	
	public Integer getId(){
		return this.id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}

	public String getOpenId(){
		return this.openId;
	}
	
	public void setOpenId(String openId){
		this.openId = openId;
	}

	public String getNickName(){
		return this.nickName;
	}
	
	public void setNickName(String nickName){
		this.nickName = nickName;
	}

	public Integer getGender(){
		return this.gender;
	}
	
	public void setGender(Integer gender){
		this.gender = gender;
	}

	public String getLanguage(){
		return this.language;
	}
	
	public void setLanguage(String language){
		this.language = language;
	}

	public String getCity(){
		return this.city;
	}
	
	public void setCity(String city){
		this.city = city;
	}

	public String getProvince(){
		return this.province;
	}
	
	public void setProvince(String province){
		this.province = province;
	}

	public String getCountry(){
		return this.country;
	}
	
	public void setCountry(String country){
		this.country = country;
	}

	public String getAvatarUrl(){
		return this.avatarUrl;
	}
	
	public void setAvatarUrl(String avatarUrl){
		this.avatarUrl = avatarUrl;
	}

	public Integer getCt(){
		return this.ct;
	}
	
	public void setCt(Integer ct){
		this.ct = ct;
	}

	public Integer getDatekey(){
		return this.datekey;
	}
	
	public void setDatekey(Integer datekey){
		this.datekey = datekey;
	}


	/**
	* 深度复制
	*/
	public  WxUserEntity deepClone() {
		WxUserEntity entity = new WxUserEntity();
		entity.setId(this.getId());
		entity.setOpenId(this.getOpenId());
		entity.setNickName(this.getNickName());
		entity.setGender(this.getGender());
		entity.setLanguage(this.getLanguage());
		entity.setCity(this.getCity());
		entity.setProvince(this.getProvince());
		entity.setCountry(this.getCountry());
		entity.setAvatarUrl(this.getAvatarUrl());
		entity.setCt(this.getCt());
		entity.setDatekey(this.getDatekey());
		return entity;
	}

	@Override
	public String toString() {
		return "WxUserEntity{"
        	+ " \"id\":" + this.getId() +","
        	+ " \"openId\":\"" + this.getOpenId() +"\","
        	+ " \"nickName\":\"" + this.getNickName() +"\","
        	+ " \"gender\":" + this.getGender() +","
        	+ " \"language\":\"" + this.getLanguage() +"\","
        	+ " \"city\":\"" + this.getCity() +"\","
        	+ " \"province\":\"" + this.getProvince() +"\","
        	+ " \"country\":\"" + this.getCountry() +"\","
        	+ " \"avatarUrl\":\"" + this.getAvatarUrl() +"\","
        	+ " \"ct\":" + this.getCt() +","
        	+ " \"datekey\":" + this.getDatekey() +""
		+"}";
	}
}