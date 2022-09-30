package org.avs.config;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="ConnectionStrings")
@XmlType(name="ConnectionStrings")
public class ConnectionStrings {
	@XmlElementRef(name="ConnectionString")
	public ConnectionString connectionString;
}
