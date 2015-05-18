package holaivy.web.simple.xb.curd;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.springframework.core.annotation.AnnotationUtils;

public class CurdUtils {
	public static <T extends java.lang.annotation.Annotation> CurdAnnotationInfo<T> findAnnotations(
			Class<?> _class, Class<T> _target) {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(_class);
			PropertyDescriptor[] properties = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor p : properties) {
				Method writeMethod = p.getWriteMethod();
				if (writeMethod == null) {
					continue;
				}
				T annotation = AnnotationUtils.findAnnotation(writeMethod,
						_target);
				if (annotation != null) {
					CurdAnnotationInfo<T> info = new CurdAnnotationInfo<T>();
					info.setAnnotation(annotation);
					info.setProperty(p);
					return info;
				}
			}
		} catch (IntrospectionException e) {
		}
		return null;
	}
}
