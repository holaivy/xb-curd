package holaivy.web.simple.xb.curd;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author diferent@outlook.com
 *
 * @param <T>
 */
public class EasyCurdService<T> extends XbCurdService<JsonNode, T> {

	@Override
	public List<T> query(JsonNode dto) {
		return null;
	}

	@Override
	public T create(T t) {
		return null;
	}

	@Override
	public T edit(T t) {
		return null;
	}

	@Override
	public T remove(T t) {
		return null;
	}

	@Override
	public T removeById(String id) {
		return null;
	}

}
