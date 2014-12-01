/**
 * 
 */
package com.hariram.annotation.cache.sample;

import com.hariram.annotation.cache.Cache;

/**
 * Sample class to test @Cache
 * 
 * @author hariram
 * date 1-Dec-2014
 */
public class CacheSample {
	@Cache(refreshRate=60)
	public static String data = "abc";
}
