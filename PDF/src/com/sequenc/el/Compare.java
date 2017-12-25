package com.sequenc.el;

import java.io.Serializable;

/**
 * @Title: Compare.java
 * @Package com.sequenc.el
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：Administrator
 * @date 创建时间：2017年12月8日 下午4:26:35
 * @version V1.0
 */
public class Compare implements Serializable,Comparable<Compare>{

 
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long	serialVersionUID	= 1L;
	private String				factorId;
	private float				avg;
	private Integer				max;
	private Integer				maxNum;
	private float 				variance;
	
	public String getFactorId() {
		return factorId;
	}

	public void setFactorId(String factorId) {
		this.factorId = factorId;
	}

	public float getAvg() {
		return avg;
	}

	public void setAvg(float avg) {
		this.avg = avg;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(Integer maxNum) {
		this.maxNum = maxNum;
	}
 
	public float getVariance() {
		return variance;
	}

	public void setVariance(float variance) {
		this.variance = variance;
	}

	@Override
	public String toString() {
		return "Compare [factorId=" + factorId + ", avg=" + avg + ", max=" + max + ", maxNum=" + maxNum + ", variance="
				+ variance + "]";
	}

	@Override
	public int compareTo(Compare o) {
		int sort = Float.compare(o.getAvg(), avg);
		if (sort == 0 ){
			sort = Integer.compare(o.getMax(), max);
		}else if (sort == 0){
			sort = Integer.compare(o.getMaxNum(), maxNum);
		}
		return sort;
	}
}
