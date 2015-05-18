package holaivy.web.simple.xb.curd;

import java.util.List;

import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;

public abstract class XbCurdService<D, T> implements XbCurd<T> {

	protected XbCurdDaoImpl<T> curd;

	public XbCurdDaoImpl<T> getCurd() {
		return curd;
	}

	public void setCurd(XbCurdDaoImpl<T> curd) {
		this.curd = curd;
	}

	@Override
	public Dao getDao() {
		return curd.getDao();
	}

	@Override
	public void setDao(Dao dao) {
		throw new RuntimeException("XbCurdService not need support!");
	}

	@Override
	public T fetch(String id) {
		return curd.fetch(id);
	}

	@Override
	public T fetch(long id) {
		return curd.fetch(id);
	}

	@Override
	public T fetch() {
		return curd.fetch();
	}

	@Override
	public List<T> query(Condition condition) {
		return curd.query(condition);
	}

	@Override
	public List<T> query(Condition condition, IXbPager pager) {
		return curd.query(condition, pager);
	}

	@Override
	public Pager createPager(IXbPager pager) {
		return curd.createPager(pager);
	}

	@Override
	public T insertRelation(T t, String relation) {
		return curd.insertRelation(t, relation);
	}

	@Override
	public T insertWith(T t, String with) {
		return curd.insertWith(t, with);
	}

	@Override
	public T insertLinks(T t, String links) {
		return curd.insertLinks(t, links);
	}

	@Override
	public T insert(T t) {
		return curd.insert(t);
	}

	@Override
	public int deleteLinks(T t, String links) {
		return curd.deleteLinks(t, links);
	}

	@Override
	public int deleteWith(T t, String with) {
		return curd.deleteWith(t, with);
	}

	@Override
	public int delete(long id) {
		return curd.delete(id);
	}

	@Override
	public int delete(String id) {
		return curd.delete(id);
	}

	@Override
	public int delete(T t) {
		return curd.delete(t);
	}

	@Override
	public T updateWith(T t, String with) {
		return curd.updateWith(t, with);
	}

	@Override
	public T updateLinks(T t, String links) {
		return curd.updateLinks(t, links);
	}

	@Override
	public int update(T t) {
		return curd.update(t);
	}

	public abstract List<T> query(D dto);

	public abstract T create(T t);
	
	public abstract T edit(T t);
	
	public abstract T remove(T t);
	
	public abstract T removeById(String id);

}
