package com.hariram.annotation.cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Cache annotation.
 * 
 * @author hariram
 * date 1-Dec-2014
 */

@Retention(RetentionPolicy.RUNTIME)

@Target(ElementType.FIELD)
public @interface Cache {
	String key();
	long refreshRate();
}
