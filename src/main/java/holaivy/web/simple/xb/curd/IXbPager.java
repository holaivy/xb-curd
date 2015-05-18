package holaivy.web.simple.xb.curd;

/**
 * 分页对象
 * 
 * @author diferent@outlook.com
 *
 */
public interface IXbPager {

	/**
	 * 页码,从1开始
	 * 
	 * @return
	 */
	public abstract int getPageNum();

	/**
	 * 页码,从1开始
	 * 
	 * @param pageNum
	 */
	public abstract void setPageNum(int pageNum);

	/**
	 * 页容量,页大小
	 * 
	 * @return
	 */
	public abstract int getPageSize();

	/**
	 * 页容量,页大小
	 * 
	 * @param pageSize
	 */
	public abstract void setPageSize(int pageSize);

}