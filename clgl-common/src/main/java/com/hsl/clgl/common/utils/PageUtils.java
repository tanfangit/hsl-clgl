
package com.hsl.clgl.common.utils;

import com.baomidou.mybatisplus.plugins.Page;

import java.io.Serializable;
import java.util.List;

/**
 * 分页工具类
 * @author zhoucheng
 * @email zhoucheng@hsl56.com
 */
public class PageUtils implements Serializable {
	private static final long serialVersionUID = 1L;
	//总记录数
	private int total;
	//每页记录数
	private int pageSize;
	//总页数
	private int totalPage;
	//当前页数
	private int currPage;
	//列表数据
	private List<?> rows;
	
	/**
	 * 分页
	 * @param rows        列表数据
	 * @param total  总记录数
	 * @param pageSize    每页记录数
	 * @param currPage    当前页数
	 */
	public PageUtils(List<?> rows, int total, int pageSize, int currPage) {
		this.rows = rows;
		this.total = total;
		this.pageSize = pageSize;
		this.currPage = currPage;
		this.totalPage = (int)Math.ceil((double)total/pageSize);
	}

	/**
	 * 分页
	 */
	public PageUtils(Page<?> page) {
		this.rows = page.getRecords();
		this.total = page.getTotal();
		this.pageSize = page.getSize();
		this.currPage = page.getCurrent();
		this.totalPage = page.getPages();
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
}
