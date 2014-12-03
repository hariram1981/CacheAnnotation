CacheAnnotation
===============

- @Cache to cache variables in a cache (hashmap)
- @Cache (key="" default "",refreshRate=<seconds> default 3600).
- Annotation is set for variables in the class.
- Variables for which @Cache is set should have value already set as that value will be stored in the cache. 

Interfaces
----------
###1. com.hariram.annotation.cache.Cache 
 - Interface for the annotation - @Cache.
 - Has parameters of String key and long refreshRate 
 
Classes
----------
###1. com.hariram.annotation.cache.CacheAnnotationProcessor
 - Class that processes the @Cache annotation.
 - Implements com.hariram.annotation.AnnotationProcessor. 
 
####void process(Object obj)
 - Processes the annotation and adds the value of the field (with annotation) to Cache (to be fetched later). If key is set in @Cache then that is used to store in the cache and if key is not set, then name of the field (variable) is used to store in the cache.
 
Usage
----------
- In the class where value from key in property file is to be set, @Property annotation has to be set as below:

		@Cache(
			key="mykey",
			refreshRate=60)
		public String data = "123";
		
- In above the value of data will be stored in the cache with key as "mykey". In order to retreive the value from Cache, the below code has to be used:

	String str = (String) CacheManager.getFromCache("data");

- The below code has to be set either in static block for static variables or in constructor for class variables:

		AnnotationProcessor processor = new CacheAnnotationProcessor();
		processor.process(new <class name>());

License
==========
Copyright (c) 2014 GitHub, Inc. See the LICENSE file for license rights and limitations (GNU GPL v2.0)
