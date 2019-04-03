package com.yl.work.entity;
import java.io.Serializable;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
/**		
 * 数据库类型：mysql
 * 表所属schema：price_center
 * 表所属用户：root
 * 表名称：concept_amount
 * 表注释：
 * 类型：table
 * @author：xinli@meicai.cn
 */
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConceptAmountEntity  implements Serializable  {
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
	 * 列类型：varchar(255)
	 * 默认值：
	 * 列的数据类型的长度：255
	 * 列注释：
	 * 列的扩展：
	 * 列名：c_name
	 * 列的数据类型：varchar
	 * 是否是主键：否
	 */
	//@JsonProperty("c_name")
	private String cname;	
	
	/**
	 * 是否可以为NULL：yes
	 * 列类型：decimal(10,2)
	 * 默认值：
	 * 列的数据类型的长度：10.2
	 * 列注释：
	 * 列的扩展：
	 * 列名：amount
	 * 列的数据类型：decimal
	 * 是否是主键：否
	 */
	//@JsonProperty("amount")
	private BigDecimal amount;	
	
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

	
	public Integer getId(){
		return this.id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}

	
	public String getCname(){
		return this.cname;
	}
	
	public void setCname(String cname){
		this.cname = cname;
	}

	
	public BigDecimal getAmount(){
		return this.amount;
	}
	
	public void setAmount(BigDecimal amount){
		this.amount = amount;
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
	public  ConceptAmountEntity deepClone() {
		ConceptAmountEntity entity = new ConceptAmountEntity();
		entity.setId(this.getId());
		entity.setCname(this.getCname());
		entity.setAmount(this.getAmount());
		entity.setDatekey(this.getDatekey());
		return entity;
	}

	@Override
	public String toString() {
		return "ConceptAmountEntity{"
        	+ " \"id\":" + this.getId() +","
        	+ " \"cname\":\"" + this.getCname() +"\","
        	+ " \"amount\":" + this.getAmount() +","
        	+ " \"datekey\":" + this.getDatekey() +""
		+"}";
	}
}