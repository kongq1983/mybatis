package com.kq.mybatis.entity;
/**
 * TODO
 * @author kongqi
 * @date  2018-04-28 08:46 
 * @since 
 */
public class Location {
	
	private Integer x;
	private Integer y;
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Location [x=" + x + ", y=" + y + "]";
	}
	

}
