package com.ksign.access.tool;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;

public class DomainUtil {
	static final String setMethodString = "set";
	
	@SuppressWarnings("unchecked")
	public static final <T> T convertMapToDomainVO(HashMap<String, Object> map, Class<?> class1) throws IllegalAccessException, InstantiationException {
		String keyAttribute = null;
		String methodString = null;
		
		Iterator<String> itr = map.keySet().iterator();
		Object o = null;
		try {
			o = class1.cast(class1.newInstance());
		} catch (InstantiationException e1) {
			throw e1;
		} catch (IllegalAccessException e1) {
			throw e1;
		}
		
		while(itr.hasNext()) {
			keyAttribute = itr.next();
			methodString = setMethodString + keyAttribute.substring(0,1).toUpperCase() + keyAttribute.substring(1);
			//System.out.println("methodString : " + methodString);
			try {
				Method[] methods = o.getClass().getDeclaredMethods();

				for(int i=0 ; i <= methods.length-1 ; i++) {
					if(methodString.equals(methods[i].getName())) {
						methods[i].invoke(o, map.get(keyAttribute));
					}
				}
				
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		return (T) o;
	}
}
