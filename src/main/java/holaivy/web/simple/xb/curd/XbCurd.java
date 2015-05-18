package holaivy.web.simple.xb.curd;

import java.util.List;

import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;

/**
 * @author diferent@outlook.com
 *
 * @param <T>
 */
public interface XbCurd<T> {

	public abstract Dao getDao();

	public abstract void setDao(Dao dao);

	public abstract T fetch(String id);

	public abstract T fetch(long id);

	public abstract T fetch();

	public abstract List<T> query(Condition condition);

	public abstract List<T> query(Condition condition, IXbPager pager);

	public abstract Pager createPager(IXbPager pager);

	T insertRelation(T t, String relation);

	T insertWith(T t, String with);

	T insertLinks(T t, String links);

	T insert(T t);

	int deleteLinks(T t, String links);

	int deleteWith(T t, String with);

	int delete(long id);

	int delete(String id);

	int delete(T t);

	T updateWith(T t, String with);

	T updateLinks(T t, String links);

	int update(T t);

}