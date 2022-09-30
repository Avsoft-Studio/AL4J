package org.avs.core.helper;

/*
 * Copyright 2018-2021 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.avs.core.annotations.Nullable;
import org.avs.core.annotations.tests.Tested;

/**
 * This class contains all the methods used in order to manipulate easily the String and CharSequence
 * object. This is a static class.
 * @apiNote This class 
 * @author Avanzino.A
 * @since 1.0
 * @see String
 */
public final class StringHelper{
	@Tested
	public static final String SepRegex = "SepRegex";
	
	@Tested
	public static final CharSequence[] accents = { "À", "�?", "Â", "Ä", "Ç", "É", "È", "Ê", "Ë", "�?", "Ì", "Î", "�?", "Ñ", "Ó", "Ò", "Ô", "Ö", "Ú", "Ù", "Û", "Ü" };
	@Tested
	public static final CharSequence[] saccents = { "A", "A", "A", "A", "C", "E", "E", "E", "E", "I", "I", "I", "I", "N", "O", "O", "O", "O", "U", "U", "U", "U" };
	
	@Tested
	public static final String Empty = "";
	
	/**
	 * Says if the CharSequence object is null
	 * @param object The CharSequence to test
	 * @return True if the CharSequence is null, else false
	 * @since 1.0
	 */
	@Tested
	public static boolean IsNull(@Nullable final CharSequence object) { return object == null; }

	/**
	 * Says if the CharSequence is null or empty
	 * An empty CharSequence is equal to an array with length equal to zero
	 * @param object The CharSequence object to test
	 * @return True if the CharSequence is null or empty, else false
	 * @since 1.0
	 */
	@Tested
	public static boolean IsNullOrEmpty(@Nullable final CharSequence object) {
		return object == null || object.isEmpty();
	}
	
	/**
	 * Says if the string object is null, empty or contains only whitespace character
	 * @param object The string object to test
	 * @return True if the string is null, empty or contains only whitespace character, else false
	 * @since 1.0
	 */
	@Tested
	public static boolean IsNullOrWhiteSpace(@Nullable final String object) {
		return Objects.isNull(object) || object.isBlank();
	}
	
	public static String substringAfter(final String str, final String separator) {
        if (IsNullOrEmpty(str)) {
            return str;
        }
        if (separator == null) {
            return "";
        }
        final int pos = str.indexOf(separator);
        if (pos == 0) {
            return str;
        }
        return str.substring(pos + separator.length());
    }
	
	/**
	 * Get the message contains in the StackTrace of a Throwable element.
	 * Used getExceptionMessage instead
	 * @param e The Throwable where we get the message
	 * @exception NullPointerException if the throwable given is null
	 * @return A CharSequence which represents the message contains in the stackTrace of the Throwable element
	 * @since 1.0
	 */
	@Tested
	public static String getExceptionMessage(final Throwable e) throws NullPointerException{
		StringWriter sw = new StringWriter();
		try(PrintWriter pw = new PrintWriter(sw)){
			e.printStackTrace(pw);
			return sw.toString();
		}
	}

	/**
	 * Transform the string object into the ASCII format
	 * @param chaine The string object to transform
	 * @return The string object converted into ASCII format
	 * @throws NullPointerException If the string object given is null
	 * @since 1.0
	 */
	@Tested
	public static String ToASCII(String chaine) throws NullPointerException{
		int i = 0;
		chaine = chaine.toUpperCase();
		for (final CharSequence s : accents) {
			chaine = chaine.replace(s, saccents[i]);
			i++;
		}
		return chaine;
	}
	
	/**
	 * Execute a concatenation of two strings object as follow : StringHelper.Concat("A","B") -> "AB"
	 * The method uses the simple concatenation given by the <code>+ operator</code>
	 * @param arg0 The first string to concat
	 * @param arg1 The second string to concat
	 * @return A new String object as the result of the concatenation of the two given in parameters
	 */
	@Tested
	public static String concat(final String arg0, final String arg1) { return arg0 + arg1; }
	
	/**
	 * Execute a concatenation of two strings object as follow : StringHelper.Concat("A","B", "C") -> "ABC"
	 * The method uses the simple concatenation given by the <code>+ operator</code>
	 * @param arg0 The first string to concat
	 * @param arg1 The second string to concat
	 * @param arg2 The third string to concat
	 * @return A new String object as the result of the concatenation of the two given in parameters
	 */
	@Tested
	public static String concat(final String arg0, final String arg1, final String arg2) { return arg0 + arg1 + arg2; }
	
	/**
	 * Execute a concatenation of two strings object as follow : StringHelper.Concat("A","B", "C") -> "ABC".
	 * The method uses a StringBuilder to do the concatenation (Not Thread Safe !) in order to be faster than
	 * the simple concatenation given by the <code>+ operator</code> of the string class with a high number of elements
	 * @param args The list of string object to concat
	 * @return A new String object as the result of the concatenation of the given strings
	 */
	@Tested
	public static String concat(final String... args) {
		return concat(new StringBuilder(), args);
	}
	
	/**
	 * Execute a concatenation of two strings object as follow : StringHelper.Concat("A","B", "C") -> "ABC".
	 * The method uses a StringBuilder to do the concatenation (Not Thread Safe !) in order to be faster than
	 * the simple concatenation given by the <code>+ operator</code> of the string class with a high number of elements
	 * @param capacity In order to define a default capacity of the StringBuilder
	 * @param args The list of string object to concat
	 * @return A new String object as the result of the concatenation of the given strings
	 */
	@Tested
	public static String concat(int capacity, final String... args) {
		return concat(new StringBuilder(capacity), args);
	}
	
	/**
	 * Private method in order to factorize the code between the concat public method
	 * @param builder The builder used to do the concatenation
	 * @param args he list of string object to concat
	 * @return A new String object as the result of the concatenation of the given strings
	 */
	@Tested
	private static String concat(final StringBuilder builder, final String... args) {
		for(int i = 0; i < args.length; i++) builder.append(args[i]);
		return builder.toString();
	}
	
	/**
	 * 
	 * @param text
	 * @param regex
	 * @param replace
	 * @return
	 */
	public static String regex(String text, final String regex, final String replace) throws PatternSyntaxException, NullPointerException{
		//Pattern pattern = Pattern.compile(regex);
		//Matcher matcher = pattern.matcher(text);
		return Pattern.compile(regex).matcher(text).replaceAll(replace);
	}
	
	/**
	 * 
	 * @param texte
	 * @param args
	 * @return
	 */
	public static String format(String texte, final String... args) {
		for(int i = 0; i < args.length; i++) {
			final String elt = "{"+i+"}";
			if(!texte.contains(elt)) { throw new IndexOutOfBoundsException("METTRE COMMENTAIRE"); }
			texte = texte.replace(elt, args[i]);
		}
		return texte;
	}
	
	public static String streamToString(InputStream stream) throws Exception {
        String result = ""; String line = "";
        try(final BufferedReader reader = new BufferedReader(new InputStreamReader(stream))){
        	while ((line = reader.readLine()) != null) { result += line; }
            return result;
        }
    }
	
	
	@SuppressWarnings("unused") @Deprecated
	private static String regex(String text, final String regex) {
		final String[] patterns = regex.split(SepRegex);
		if(!(patterns.length == 2)) return null; 
		else
			return Pattern.compile(patterns[0]).matcher(text).replaceAll(patterns[1]);	
	}
	

	/**
	 * Get the message contains in the StackTrace of a Throwable element.
	 * Used getExceptionMessage instead
	 * @param e The Throwable where we get the message
	 * @exception NullPointerException if the throwable given is null
	 * @return A CharSequence which represents the message contains in the stackTrace of the Throwable element
	 * @since 1.0
	 */
	@Tested @Deprecated
	public static String getErrorMessage(final Throwable e) throws NullPointerException{
		String result = "";
		for (final StackTraceElement st : e.getStackTrace()) 
			result += "at " + st.toString() + "\n";
		return result;
	}
}

