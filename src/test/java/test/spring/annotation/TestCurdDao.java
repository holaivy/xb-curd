package test.spring.annotation;

import holaivy.web.simple.xb.curd.XbCurdDaoImpl;

import org.junit.Test;
import org.nutz.dao.impl.NutDao;

public class TestCurdDao {

	@Test
	public void test() {
		XbCurdDaoImpl<SimpleEntity> dao = new XbCurdDaoImpl<SimpleEntity>() {
		};
		NutDao nutzDao = new NutDao();
		dao.setDao(nutzDao);
		SimpleEntity t = new SimpleEntity();
		t.setName("1");
		dao.insert(t);
		System.out.println(t.getName());
	}

}
