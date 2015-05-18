package test.spring.annotation;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;

public class SimpleBaseEntity {
	@Column(value = "ti")
	private Date ti;

	public Date getTi() {
		return ti;
	}

	public void setTi(Date ti) {
		this.ti = ti;
	}
}
