package holaivy.web.simple.xb.curd;

import java.beans.PropertyDescriptor;

public class CurdAnnotationInfo<T> {
	private PropertyDescriptor property;
	private T annotation;

	public PropertyDescriptor getProperty() {
		return property;
	}

	public void setProperty(PropertyDescriptor property) {
		this.property = property;
	}

	public T getAnnotation() {
		return annotation;
	}

	public void setAnnotation(T annotation) {
		this.annotation = annotation;
	}

}
