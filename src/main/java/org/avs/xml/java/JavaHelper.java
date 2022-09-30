package org.avs.xml.java;

import java.util.Hashtable;
import java.util.Map;

public final class JavaHelper {
	private static Map<String, String> javaType;
	
	static {
		javaType = new Hashtable<String, String>();
		javaType.put("xs:string", "String");
		javaType.put("xs:int", "int");
		javaType.put("xs:datetime", null); //TODO
		javaType.put("xs:boolean", "boolean");
		javaType.put("xs:byte", "byte");
		javaType.put("xs:short", "short");
	}
	
	
}
