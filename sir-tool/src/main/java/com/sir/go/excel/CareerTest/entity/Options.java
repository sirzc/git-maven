package com.sir.go.excel.CareerTest.entity;

import java.util.ArrayList;
import java.util.List;

public class Options {
	private String tip1; // 选项一
	private String tip2; // 选项二
	private String tip3; // 选项三
	private String tip4; // 选项四
	private String tip5; // 选项五
	private String tip6; // 选项五
	private List<String> list = new ArrayList<String>();

	public String getTip1() {
		return tip1;
	}

	public void setTip1(String tip1) {
		if (!"".equals(tip1) && tip1 != null) {
			this.list.add(tip1);
		}
		this.tip1 = tip1;
	}

	public String getTip2() {
		return tip2;
	}

	public void setTip2(String tip2) {
		if (!"".equals(tip2) && tip2 != null) {
			this.list.add(tip2);
		}
		this.tip2 = tip2;
	}

	public String getTip3() {
		return tip3;
	}

	public void setTip3(String tip3) {
		if (!"".equals(tip3) && tip3 != null) {
			this.list.add(tip3);
		}
		this.tip3 = tip3;
	}

	public String getTip4() {
		return tip4;
	}

	public void setTip4(String tip4) {
		if (!"".equals(tip4) && tip4 != null) {
			this.list.add(tip4);
		}
		this.tip4 = tip4;
	}

	public String getTip5() {
		return tip5;
	}

	public void setTip5(String tip5) {
		if (!"".equals(tip5) && tip5 != null) {
			this.list.add(tip5);
		}
		this.tip5 = tip5;
	}

	public String getTip6() {
		return tip6;
	}

	public void setTip6(String tip6) {
		if (!"".equals(tip6) && tip6 != null) {
			this.list.add(tip6);
		}
		this.tip6 = tip6;
	}
	
	public List<String> getList() {
		return list;
	}

	@Override
	public String toString() {
		return "Options [tip1=" + tip1 + ", tip2=" + tip2 + ", tip3=" + tip3 + ", tip4=" + tip4 + ", tip5=" + tip5
				+ ", tip6=" + tip6 + ", list=" + list + "]";
	}

}
