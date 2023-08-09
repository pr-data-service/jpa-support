package com.jpasupport.utils;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.BeanUtils;

import com.jpasupport.constants.ApiConstants;
import com.jpasupport.constants.DBConstants;

public class Utils {
		
    // Method to generate a random alphanumeric password of a specific length
    public static String generateRandomPassword(int len) {
        // ASCII range – alphanumeric (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
 
        SecureRandom random = new SecureRandom();
 
        // each iteration of the loop randomly chooses a character from the given
        // ASCII range and appends it to the `StringBuilder` instance
        return IntStream.range(0, len)
                .map(i -> random.nextInt(chars.length()))
                .mapToObj(randomIndex -> String.valueOf(chars.charAt(randomIndex)))
                .collect(Collectors.joining());
    }
    
    public static String[] getIgnoreEntityPropsOnUpdate(String[] fields) {
    	List<String> list = new ArrayList<String>(ApiConstants.DEFAULT_FIELDS_NOT_TO_MODIFY_ON_UPDATE);
    	if(fields != null) {
    		list.addAll(Arrays.asList(fields));
    	}    	
    	return list.toArray(new String[0]);
    }
    
    
    
    public static <T,M> List<T> convertList(List<M> list, Class<T> cls) {
    	List<T> rtnList = new ArrayList<>();
    	try {
    		if(list != null && !list.isEmpty() && cls != null) {    			
        		T t = null;
        		for(M m : list) {
        			t = cls.newInstance();
        			BeanUtils.copyProperties(m, t);
    				rtnList.add(t);
        		}
        	}
    	} catch (Exception e) {
    		throw new RuntimeException(e.getMessage());
		}    	
		return rtnList;
    }
    
    public static <T, M> T copyProps(M m, Class<T> cls, boolean isIgonreProps) {
    	T t = null;
    	try {
    		if(m != null) {
        		t = cls.newInstance();
        		if(isIgonreProps) {
        			BeanUtils.copyProperties(m, t, Utils.getIgnoreEntityPropsOnUpdate(null));
        		} else {
        			BeanUtils.copyProperties(m, t);
        		}        		
        	}
    	} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return t;
    }
    

    
    public static Map<String, Object> convertArrayToMap(Object values[], String fieldNames[]) {
    	Map<String, Object> map = new HashMap<>();
    	if(values != null && fieldNames != null && values.length == fieldNames.length) {
    		
    		int pos = 0;
    		for(String fldNm : fieldNames) {
    			map.put(fldNm, values[pos++]);
    		}
    	}
    	return map;
    }
    
    public static String getFKField(String fieldName, String keyConstraints) {
    	if("FK".equalsIgnoreCase(keyConstraints)) {
    		return DBConstants.DATABASE_KEY_CONSTRAINTS_MAP.getOrDefault(fieldName, null);
    	}
    	return null;
    }
    
    public static String wordCamelCase(String str) {
    	return Arrays.asList(str.split(" ")).stream().map( input -> Character.toLowerCase(input.charAt(0)) +
                (input.length() > 1 ? input.substring(1) : "")).collect(Collectors.joining(" "));
    }
}
