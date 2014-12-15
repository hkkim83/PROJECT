package kr.co.aegis.dto;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class JqGrid {
	private int page;
	private int records;
	private int total;
	private List<Map<String, String>> rows = new ArrayList<Map<String, String>>();
	
	public JqGrid(List<Map<String, String>> list) {
		this.page = 1;
		this.records = 10;
		this.total = rows.size();
		this.rows = list;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRecords() {
		return records;
	}
	public void setRecords(int records) {
		this.records = records;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Map<String, String>> getRows() {
		return rows;
	}
	public void setRows(List<Map<String, String>> rows) {
		this.rows = rows;
	}
}
