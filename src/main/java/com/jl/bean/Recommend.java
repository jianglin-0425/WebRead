package com.jl.bean;

public class Recommend {
	private String btype;
	private Integer count;
	private Double score;
	public String getBType() {
		return btype;
	}
	public void setBType(String btype) {
		this.btype = btype;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Recommend [btype=" + btype + ", count=" + count + ", score=" + score + "]";
	}
	
}	
