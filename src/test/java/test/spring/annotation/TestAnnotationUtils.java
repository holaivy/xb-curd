package test.spring.annotation;

import static org.junit.Assert.*;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.RequestMapping;

public class TestAnnotationUtils {

	@Test
	public void test() {
		BeanInfo bi;
		try {
			bi = Introspector.getBeanInfo(SimpleEntity.class);
			PropertyDescriptor[] properties = bi.getPropertyDescriptors();
			for (PropertyDescriptor property : properties) {
				// One way
				Method readMethod = property.getReadMethod();
				System.out.println(property.getDisplayName());
				RequestMapping annotation = readMethod.getAnnotation(RequestMapping.class);
				if(annotation==null) {
					System.out.println("Column is null");
				}
//				for (Annotation annotation : readMethod.getAnnotations()) {
//					if (annotation instanceof Column) {
//						String string = annotation.name();
//					}
//				}
//				// Other way
//				Annotation annotation = property.getAnnotation(Column.class);
//				String string = annotation.name();
			}
		} catch (IntrospectionException e) {
		}

	}

	public void findMethod(Method m) {
		RequestMapping a = AnnotationUtils.findAnnotation(m,
				RequestMapping.class);
		if (a != null) {
			System.out.println(a.value()[0]);
		} else {
			System.out.println("ANNO IS NULL");
		}
	}

}
