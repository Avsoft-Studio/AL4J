package org.avs.core.annotations.infos;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author Avanzino.A
 * @since 07/07/2022
 * @version 1.0
 */
@Documented
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PACKAGE, ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface Todos {
	Todo[] value();
	
	public enum Importance {
		MINOR, IMPORTANT, MAJOR, CRITICAL
	};
	
	@Repeatable(value = Todos.class)
	@Retention(RetentionPolicy.SOURCE)
	public @interface Todo {
		Importance importance() default Importance.MINOR;
		String[] description();
		String assignedTo();
		String assignedDate();
	}
}

