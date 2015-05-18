package holaivy.web.simple.xb.curd;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;

/**
 * @author diferent@outlook.com
 *
 */
public abstract class XbCurdDaoImpl<T> implements XbCurd<T> {

	protected Dao dao;
	protected Class<T> __class;

	/*
	 * (non-Javadoc)
	 * 
	 * @see holaivy.web.simple.xb.curd.XbCurdDao#getDao()
	 */
	@Override
	public Dao getDao() {
		return dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see holaivy.web.simple.xb.curd.XbCurdDao#setDao(org.nutz.dao.Dao)
	 */
	@Override
	public void setDao(Dao dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see holaivy.web.simple.xb.curd.XbCurdDao#fetch(java.lang.String)
	 */
	@Override
	public T fetch(String id) {
		return dao.fetch(__class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see holaivy.web.simple.xb.curd.XbCurdDao#fetch(long)
	 */
	@Override
	public T fetch(long id) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see holaivy.web.simple.xb.curd.XbCurdDao#fetch()
	 */
	@Override
	public T fetch() {
		return dao.fetch(__class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see holaivy.web.simple.xb.curd.XbCurdDao#query(org.nutz.dao.Condition)
	 */
	@Override
	public List<T> query(Condition condition) {
		return dao.query(__class, condition);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see holaivy.web.simple.xb.curd.XbCurdDao#query(org.nutz.dao.Condition,
	 * holaivy.web.simple.xb.curd.IXbPager)
	 */
	@Override
	public List<T> query(Condition condition, IXbPager pager) {
		return dao.query(__class, condition, createPager(pager));
	}

	@Override
	public int update(T t) {
		return dao.update(t);
	}

	@Override
	public T updateLinks(T t, String links) {
		return dao.updateLinks(t, links);
	}

	@Override
	public T updateWith(T t, String with) {
		return dao.updateWith(t, with);
	}

	@Override
	public int delete(T t) {
		return dao.delete(t);
	}

	@Override
	public int delete(String id) {
		return dao.delete(__class, id);
	}

	@Override
	public int delete(long id) {
		return dao.delete(__class, id);
	}

	@Override
	public int deleteWith(T t, String with) {
		return dao.deleteWith(t, with);
	}

	@Override
	public int deleteLinks(T t, String links) {
		return dao.deleteLinks(t, links);
	}

	@Override
	public T insert(T t) {
		return dao.insert(prev(t));
	}

	protected T prev(T t) {
		genUUID(t);
		return t;
	}
	
	protected T genTimeNow(T t){
		CurdAnnotationInfo<CurdUUID> find = CurdUtils.findAnnotations(__class,
				CurdUUID.class);
		if (find != null) {
			PropertyDescriptor property = find.getProperty();
			Method readMethod = property.getReadMethod();
			Method method = property.getWriteMethod();
			try {
				Object object = readMethod.invoke(t, null);
				if (object == null) {
					method.invoke(t,
							UUID.randomUUID().toString().replace("-", ""));
				}
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				XbCurdLogger.logger
						.error("Entity {} cannot set property {} in method {} while gen uuid",
								t.toString(), property.getName(),
								method.toString());
			}
		}
		return t;
	}

	protected T genUUID(T t) {
		CurdAnnotationInfo<CurdUUID> find = CurdUtils.findAnnotations(__class,
				CurdUUID.class);
		if (find != null) {
			PropertyDescriptor property = find.getProperty();
			Method readMethod = property.getReadMethod();
			Method method = property.getWriteMethod();
			try {
				Object object = readMethod.invoke(t, null);
				if (object == null) {
					method.invoke(t,
							UUID.randomUUID().toString().replace("-", ""));
				}
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				XbCurdLogger.logger
						.error("Entity {} cannot set property {} in method {} while gen uuid",
								t.toString(), property.getName(),
								method.toString());
			}
		}
		return t;
	}

	@Override
	public T insertLinks(T t, String links) {
		return dao.insertLinks(t, links);
	}

	@Override
	public T insertWith(T t, String with) {
		return dao.insertWith(t, with);
	}

	@Override
	public T insertRelation(T t, String relation) {
		return dao.insertRelation(t, relation);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * holaivy.web.simple.xb.curd.XbCurdDao#createPager(holaivy.web.simple.xb
	 * .curd.IXbPager)
	 */
	@Override
	public Pager createPager(IXbPager pager) {
		if (pager == null)
			return null;
		return dao.createPager(pager.getPageNum(), pager.getPageSize());
	}

	@SuppressWarnings("unchecked")
	protected Class<T> myClass() {
		Class<?> clazz = getClass();
		while (clazz != Object.class) {
			Type t = clazz.getGenericSuperclass();
			if (t instanceof ParameterizedType) {
				Type[] args = ((ParameterizedType) t).getActualTypeArguments();
				if (args[0] instanceof Class) {
					return (Class<T>) args[0];
				}
			}
			clazz = clazz.getSuperclass();
		}
		return null;
	}

	public XbCurdDaoImpl() {
		super();
		__class = myClass();
	}

}
