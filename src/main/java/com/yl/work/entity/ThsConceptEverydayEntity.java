package com.yl.work.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.math.BigDecimal;
//import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 数据库类型：mysql
 * 表所属schema：price_center
 * 表所属用户：root
 * 表名称：ths_concept_everyday
 * 表注释：
 * 类型：table
 * @author：denghuajie@meicai.cn
 */
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ThsConceptEverydayEntity implements Serializable  {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 是否可以为NULL：no
	 * 列类型：int(11) unsigned
	 * 默认值：
	 * 列的数据类型的长度：10.0
	 * 列注释：
	 * 列的扩展：auto_increment
	 * 列名：id
	 * 列的数据类型：int
	 * 是否是主键：是
	 */
	//@JsonProperty("id")
	private Integer id;	
	
	/**
	 * 是否可以为NULL：yes
	 * 列类型：varchar(20)
	 * 默认值：
	 * 列的数据类型的长度：20
	 * 列注释：行业
	 * 列的扩展：
	 * 列名：hangye
	 * 列的数据类型：varchar
	 * 是否是主键：否
	 */
	//@JsonProperty("hangye")
	private String hangye;	
	
	/**
	 * 是否可以为NULL：yes
	 * 列类型：decimal(10,2)
	 * 默认值：
	 * 列的数据类型的长度：10.2
	 * 列注释：行业指数
	 * 列的扩展：
	 * 列名：hangyezhishu
	 * 列的数据类型：decimal
	 * 是否是主键：否
	 */
	//@JsonProperty("hangyezhishu")
	private BigDecimal hangyezhishu;	
	
	/**
	 * 是否可以为NULL：yes
	 * 列类型：decimal(10,2)
	 * 默认值：
	 * 列的数据类型的长度：10.2
	 * 列注释：
	 * 列的扩展：
	 * 列名：zhangdiefu
	 * 列的数据类型：decimal
	 * 是否是主键：否
	 */
	//@JsonProperty("zhangdiefu")
	private BigDecimal zhangdiefu;	
	
	/**
	 * 是否可以为NULL：yes
	 * 列类型：decimal(10,2)
	 * 默认值：
	 * 列的数据类型的长度：10.2
	 * 列注释：
	 * 列的扩展：
	 * 列名：liuruzijin
	 * 列的数据类型：decimal
	 * 是否是主键：否
	 */
	//@JsonProperty("liuruzijin")
	private BigDecimal liuruzijin;	
	
	/**
	 * 是否可以为NULL：yes
	 * 列类型：decimal(10,2)
	 * 默认值：
	 * 列的数据类型的长度：10.2
	 * 列注释：
	 * 列的扩展：
	 * 列名：liuchuzijin
	 * 列的数据类型：decimal
	 * 是否是主键：否
	 */
	//@JsonProperty("liuchuzijin")
	private BigDecimal liuchuzijin;	
	
	/**
	 * 是否可以为NULL：yes
	 * 列类型：decimal(10,2)
	 * 默认值：
	 * 列的数据类型的长度：10.2
	 * 列注释：
	 * 列的扩展：
	 * 列名：jiner
	 * 列的数据类型：decimal
	 * 是否是主键：否
	 */
	//@JsonProperty("jiner")
	private BigDecimal jiner;	
	
	/**
	 * 是否可以为NULL：yes
	 * 列类型：int(11)
	 * 默认值：
	 * 列的数据类型的长度：10.0
	 * 列注释：
	 * 列的扩展：
	 * 列名：datekey
	 * 列的数据类型：int
	 * 是否是主键：否
	 */
	//@JsonProperty("datekey")
	private Integer datekey;

	private Integer paihangIndex;
	
	/**
	 * 是否可以为NULL：yes
	 * 列类型：int(11)
	 * 默认值：
	 * 列的数据类型的长度：10.0
	 * 列注释：
	 * 列的扩展：
	 * 列名：dayIndex
	 * 列的数据类型：int
	 * 是否是主键：否
	 */
	//@JsonProperty("dayIndex")
	private Integer dayIndex;	
	
	/**
	 * 是否可以为NULL：yes
	 * 列类型：varchar(20)
	 * 默认值：
	 * 列的数据类型的长度：20
	 * 列注释：
	 * 列的扩展：
	 * 列名：mainshare
	 * 列的数据类型：varchar
	 * 是否是主键：否
	 */
	//@JsonProperty("mainshare")
	private String mainshare;	
	
	/**
	 * 是否可以为NULL：yes
	 * 列类型：decimal(10,2)
	 * 默认值：
	 * 列的数据类型的长度：10.2
	 * 列注释：
	 * 列的扩展：
	 * 列名：mainshareup
	 * 列的数据类型：decimal
	 * 是否是主键：否
	 */
	//@JsonProperty("mainshareup")
	private BigDecimal mainshareup;

	public Integer getId(){
		return this.id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}

	
	public String getHangye(){
		return this.hangye;
	}
	
	public void setHangye(String hangye){
		this.hangye = hangye;
	}

	
	public BigDecimal getHangyezhishu(){
		return this.hangyezhishu;
	}
	
	public void setHangyezhishu(BigDecimal hangyezhishu){
		this.hangyezhishu = hangyezhishu;
	}

	
	public BigDecimal getZhangdiefu(){
		return this.zhangdiefu;
	}
	
	public void setZhangdiefu(BigDecimal zhangdiefu){
		this.zhangdiefu = zhangdiefu;
	}

	
	public BigDecimal getLiuruzijin(){
		return this.liuruzijin;
	}
	
	public void setLiuruzijin(BigDecimal liuruzijin){
		this.liuruzijin = liuruzijin;
	}

	
	public BigDecimal getLiuchuzijin(){
		return this.liuchuzijin;
	}
	
	public void setLiuchuzijin(BigDecimal liuchuzijin){
		this.liuchuzijin = liuchuzijin;
	}

	
	public BigDecimal getJiner(){
		return this.jiner;
	}
	
	public void setJiner(BigDecimal jiner){
		this.jiner = jiner;
	}

	
	public Integer getDatekey(){
		return this.datekey;
	}
	
	public void setDatekey(Integer datekey){
		this.datekey = datekey;
	}

	
	public Integer getDayIndex(){
		return this.dayIndex;
	}
	
	public void setDayIndex(Integer dayIndex){
		this.dayIndex = dayIndex;
	}

	
	public String getMainshare(){
		return this.mainshare;
	}
	
	public void setMainshare(String mainshare){
		this.mainshare = mainshare;
	}

	
	public BigDecimal getMainshareup(){
		return this.mainshareup;
	}
	
	public void setMainshareup(BigDecimal mainshareup){
		this.mainshareup = mainshareup;
	}

	public Integer getPaihangIndex() {
		return paihangIndex;
	}

	public void setPaihangIndex(Integer paihangIndex) {
		this.paihangIndex = paihangIndex;
	}

	@Override
	public String toString() {
		return "ThsConceptEverydayEntity{" +
				"id=" + id +
				", hangye='" + hangye + '\'' +
				", hangyezhishu=" + hangyezhishu +
				", zhangdiefu=" + zhangdiefu +
				", liuruzijin=" + liuruzijin +
				", liuchuzijin=" + liuchuzijin +
				", jiner=" + jiner +
				", datekey=" + datekey +
				", paihangIndex=" + paihangIndex +
				", dayIndex=" + dayIndex +
				", mainshare='" + mainshare + '\'' +
				", mainshareup=" + mainshareup +
				'}';
	}
}