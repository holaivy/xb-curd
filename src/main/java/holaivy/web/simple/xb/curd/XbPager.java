package holaivy.web.simple.xb.curd;

/**
 * 分页对象
 * 
 * @author diferent@outlook.com
 *
 */
public class XbPager implements IXbPager {
	private int pageNum;
	private int pageSize;

	/*
	 * (non-Javadoc)
	 * 
	 * @see holaivy.web.simple.xb.curd.IXbPager#getPageNum()
	 */
	@Override
	public int getPageNum() {
		return pageNum;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see holaivy.web.simple.xb.curd.IXbPager#setPageNum(int)
	 */
	@Override
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see holaivy.web.simple.xb.curd.IXbPager#getPageSize()
	 */
	@Override
	public int getPageSize() {
		return pageSize;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see holaivy.web.simple.xb.curd.IXbPager#setPageSize(int)
	 */
	@Override
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
