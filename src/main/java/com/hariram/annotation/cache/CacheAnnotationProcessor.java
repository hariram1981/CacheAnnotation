package com.hariram.annotation.cache;

import java.lang.reflect.Field;

import org.apache.log4j.Logger;

import com.hariram.annotation.AnnotationException;
import com.hariram.annotation.AnnotationProcessor;
import com.hariram.cache.CacheManager;
import com.hariram.cache.CacheRefresh;

/**
 * @author hariram
 * date 1-Dec-2014
 */
public class CacheAnnotationProcessor implements AnnotationProcessor {

	public static final Logger LOGGER = Logger.getLogger(CacheAnnotationProcessor.class);
	
	/**
	 * 
	 */
	public void process(Object obj) throws AnnotationException {
		LOGGER.info("CacheAnnotationProcessor.process, obj: " + obj);
		Class<? extends Object> objClass = obj.getClass();
		
		for(Field field: objClass.getDeclaredFields()) {
			field.setAccessible(true);
			if(field.isAnnotationPresent(Cache.class)) {
				Cache cache = field.getAnnotation(Cache.class);
				try {
					Object fieldValue = field.get(obj);
					CacheManager.setRefreshDuration(cache.refreshRate());
					String key = cache.key().equals("") ? field.getName(): cache.key();
					CacheManager.addToCache(key, fieldValue, new CacheRefresh());
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
					throw new AnnotationException("CacheAnnotationProcessor.process, message : " + e.getClass() + " " + e.getMessage(),AnnotationType.CacheAnnotation);
				}
			}
		}
		LOGGER.info("CacheAnnotationProcessor.process, done");
	}

	@Override
	public Object process(Object arg0, String arg1, Object[] arg2)
			throws AnnotationException {
		// TODO Auto-generated method stub
		return null;
	}

}
