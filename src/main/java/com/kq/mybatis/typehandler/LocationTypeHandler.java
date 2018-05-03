package com.kq.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.kq.mybatis.entity.Location;

/**
 * TODO
 * @author kongqi
 * @date  2018-04-28 08:45 
 * @since 
 */
public class LocationTypeHandler extends BaseTypeHandler<Location> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Location parameter, JdbcType jdbcType)
			throws SQLException {
		
		String data = null;
		if(parameter!=null) {
			Integer x = parameter.getX();
			Integer y = parameter.getY();
			
			data = x+","+y; 
			
		}
		 ps.setString(i, data);
	}

	@Override
	public Location getNullableResult(ResultSet rs, String columnName) throws SQLException {
		
		String data =  rs.getString(columnName);
		
		return getLocation(data);
	}

	private Location getLocation(String data) {
		if(data==null) {
			return null;
		}
		
		String[] ls = StringUtils.split(data,",");
		
		Location l = new Location();
		try {
			l.setX(Integer.parseInt(ls[0]));
		}catch(Exception e) {
			
		}
		
		try {
			l.setY(Integer.parseInt(ls[1]));
		}catch(Exception e) {
			
		}
		
		System.out.println("typehandler location="+l);
		
		return l;
	}

	@Override
	public Location getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		String data = rs.getString(columnIndex);
		System.out.println("typehandler getNullableResult");
		return getLocation(data);
	}

	@Override
	public Location getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		String data = cs.getString(columnIndex);
		System.out.println("typehandler getNullableResult CallableStatement");
		return getLocation(data);
	}

}
