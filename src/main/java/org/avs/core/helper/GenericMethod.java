package org.avs.core.helper;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.avs.core.annotations.infos.AlphaVersion;
import org.avs.core.patterns.enumerations.IBaseEnum;

/**
 * Static class that give a list of generic method than can be used in order
 * to regroup some specific code into the same place
 * Careful, due to genericity of some methods, the perf of the code can be reduce
 * @author Avanzino.A
 * @since 2020
 * @version 1.0
 */
public final class GenericMethod {
	/**
	 * Allows to return a object that correspond to the charSequence given in parameter
	 * @implSpec Used especially for enumeration
	 * @implNote How to call : EnumTools.<String>fromValue(strings, {my array...})
	 * @param v the string to check
	 * @param valuesToCheck The list of values to check
	 * @param <T> The type of object in the list
	 * @return The corresponding object if we find it in the list, null else
	 */
	public static <T> T fromValue(final String v, T[] valuesToCheck) {
        for (T c: valuesToCheck) {
            if (c.toString().equals(v)) return c;
        }
        return null;
    }
	
	/**
	 * Allows to return a object that correspond to the charSequence given in parameter
	 * @implSpec Used especially for enumeration
	 * @implNote How to call : EnumTools.<String>fromValue(strings, {my array...}, exception)
	 * @param v the string to check
	 * @param valuesToCheck The list of values to check
	 * @param <T> The type of object in the list
	 * @param ex The exception to throw if we don't find the corresponding object
	 * @exception Exception The specific exception given in parameter
	 * @return The corresponding object if we find it in the list
	 */
	public static <T> T fromValue(final String v, T[] valuesToCheck, Exception ex) throws Exception {
		for(T c: valuesToCheck) {
			if(c.toString().equals(v)) return c;
		}
		throw ex;
	}
	
	/**
	 * 
	 * @implSpec Used especially for enumeration
	 * @implNote How to call : EnumTools.<String>fromValue(strings, {my array...}, exception)
	 * @param <T> The type of enumeration. Must implements IBaseEnum interfaces
	 * @param v the string to check
	 * @param valuesToCheck The list of values to check
	 * @return The corresponding object if we find it in the list, null else
	 * @see IBaseEnum
	 */
	public static <T extends IBaseEnum> T fromValue(final String v, T[] valuesToCheck) {
		 for (T c: valuesToCheck) {
			 if (c.getCode().equals(v)) return c;
	     }
	     return null;
	}
	
	public static <T> T requireNonNull(T obj) {
		if(obj == null)
			throw new NullPointerException();
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[] toArray(List<T> list) {
		T[] result = (T[]) Array.newInstance(list.get(0).getClass(), list.size());
		for(int i = 0; i < list.size(); i++)
			result[i] = list.get(i);
		return result;
	}
	
	
	
	/**
	 * Permet d'effectuer une action en parallèle sur l'ensemble des éléments d'une liste
	 * @param <T> Le type d'objet contenu dans la liste
	 * @param list Collection des élements sur lesquels appliqués le traitement
	 * @param arg0 La fonction à appliquer sur les éléments de la liste
	 * @return
	 */
	@AlphaVersion
	public static <T> boolean tryParrallelProcess(Collection<? extends T> list, final java.util.function.Consumer<T> arg0) {
		list.parallelStream().forEach(arg0);
		return true;
	}
	
	@SuppressWarnings("unchecked") @AlphaVersion
	public static <T> T getJaxbObjectFromFile(final String fileName, Class<T> classe) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(classe);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return (T)unmarshaller.unmarshal(new File(fileName));
	}
}
