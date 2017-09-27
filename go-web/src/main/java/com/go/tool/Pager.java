package com.go.tool;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @ClassName: Pager
 * @Description: 对分页进行封装
 * @author 作者：zhouchao
 * @date 创建时间：2017年4月23日 上午11:46:45
 * 
 * @param <T>
 */
public class Pager<T> implements Serializable {

	public static final int DEFAULT_PAGE_SIZE = 10;
	private static final long serialVersionUID = 609222305391683918L;

	private boolean countTotal; // 是否存在数据
	private List<T> records = new ArrayList<T>(); // 查询结果集List<T>结果集
	private int page; // 前台获取的页数
	private int rows; // 前台传过来的每页显示的行数
	private int currentPage; // 显示页数
	private int pageSize; // 显示行数
	private int totalRecords; // 总行数

	public Pager() {
		this.pageSize = DEFAULT_PAGE_SIZE;
		this.currentPage = 1;
		this.countTotal = true;
		this.totalRecords = 0;
	}

	public boolean isCountTotal() {
		return countTotal;
	}

	public void setCountTotal(boolean countTotal) {
		this.countTotal = countTotal;
	}

	public List<T> getRecords() {
		return records;
	}

	/**
	 * 记录并存放显示的行数
	 * 
	 * @param records
	 */
	public void setRecords(List<T> records) {
		if (this.getPageSize() >= this.getTotalRecords()) {
			this.records = records;
		} else {
			int begin = ((this.getCurrentPage() - 1) * this.getPageSize()); // (显示的页数
																			// *显示的行数)
			int end; // 当前页可以显示的行数
			List<T> list = new ArrayList<T>();
			if (this.getCurrentPage() * this.getPageSize() < this
					.getTotalRecords()) {
				end = this.getCurrentPage() * this.getPageSize() - 1;
				for (int i = begin; i < end + 1; i++) {
					list.add(records.get(i));
				}
			} else {
				for (int i = begin; i < records.size(); i++) {
					list.add(records.get(i));
				}
			}
			this.records = list;
		}
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 * 显示的页数
	 * 
	 * @return
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * 初始化页数
	 * 
	 * @param currentPage
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * 获取显示行数
	 * 
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 初始化每页显示的行数
	 * 
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 总行数
	 * 
	 * @return
	 */
	public int getTotalRecords() {
		return totalRecords;
	}

	/**
	 * 存入共有多少条记录
	 * 
	 * @param totalRecords
	 */
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

}
