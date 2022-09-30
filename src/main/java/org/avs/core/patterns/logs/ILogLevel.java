package org.avs.core.patterns.logs;

import org.avs.core.patterns.enumerations.IBaseEnum;
import org.avs.core.patterns.enumerations.IEnum;

/**
 * This interface is use to indicate that a enumeration is usable
 * by the ILogger in order to generate the level of the log
 * @author Avanzino.A
 * @since 15/07/2022
 * @version 1.0
 * @see IBaseEnum
 * @see IEnum<T>
 */
public interface ILogLevel extends IBaseEnum, IEnum<ILogLevel> {

}
