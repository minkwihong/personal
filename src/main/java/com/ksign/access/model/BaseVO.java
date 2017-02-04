package com.ksign.access.model;

import java.lang.reflect.Field;

public class BaseVO {
	
	//TODO: JustTest
	public String toString() {
		try {
	        StringBuffer sb = new StringBuffer();
	        Class<?> objClass = this.getClass();
	        sb.append("{");
	        		
	        Field[] fields = objClass.getDeclaredFields();
	        for(Field field : fields) {
	        	field.setAccessible(true);
	            String name = field.getName();
	            Object value = field.get(this);
	            if(value == null) continue;
	            sb.append(name + ": " + value.toString() + ", ");
	        }
	        
	        sb.append("}");
	        return sb.toString();
	    } catch(Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
}
