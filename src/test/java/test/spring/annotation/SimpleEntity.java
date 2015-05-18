package test.spring.annotation;

import holaivy.web.simple.xb.curd.CurdUUID;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;
import org.springframework.web.bind.annotation.RequestMapping;

@Table("hi")
public class SimpleEntity extends SimpleBaseEntity {
	@Name
	@Column("name")
	private String name;

	public String getName() {
		return name;
	}

	@CurdUUID
	public void setName(String name) {
		this.name = name;
	}

}
