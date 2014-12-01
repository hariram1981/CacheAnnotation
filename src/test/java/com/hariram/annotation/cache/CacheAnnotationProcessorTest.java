/**
 * 
 */
package com.hariram.annotation.cache;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hariram.annotation.AnnotationException;
import com.hariram.annotation.AnnotationProcessor;
import com.hariram.annotation.cache.sample.CacheSample;
import com.hariram.cache.CacheManager;

/**
 * @author hariram
 * date 1-Dec-2014
 */
public class CacheAnnotationProcessorTest {

	@Test
	public void test() {
		try {
			AnnotationProcessor processor = new CacheAnnotationProcessor();
			processor.process(new CacheSample());
			Object obj = CacheManager.getFromCache("data");
			System.out.println(obj);
			assertTrue(obj != null);
		} catch (AnnotationException e) {
			// TODO Auto-generated catch block
			assertTrue(false);
		}
	}

}
