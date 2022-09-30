package org.avs.core.http;

import java.util.Map;
import java.util.Map.Entry;

import org.avs.core.helper.StringHelper;

public final class HttpHelper {
	
	public static String GetUrlQuery(Map<String, String> paramValues) {
		StringBuilder builder = new StringBuilder();
		for(Entry<String, String> paramValue: paramValues.entrySet()) {
			if(builder.length() > 0) {
				builder.append("&");
			}
			builder.append(paramValue.getKey()).append("=").append(paramValue.getValue());
		}
		return builder.toString();
	}
	
	private static String Encode(String value) {
		if(StringHelper.IsNullOrEmpty(value)) {
			return StringHelper.Empty;
		}
		return null;
	}
}
