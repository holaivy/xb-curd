package holaivy.web.simple.xb.curd.example;

import holaivy.web.simple.xb.curd.CurdUUID;

import org.nutz.dao.entity.annotation.Column;

public class ExampleEntity {
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
