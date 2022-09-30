package org.avs.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ConnectionString")
public class ConnectionString {
	@XmlAttribute(name="name", required=true)
	public String name;
	@XmlAttribute(name="providerName", required=true)
	public String providerName;
	@XmlAttribute(name="url", required=true)
	public String url;
	@XmlAttribute(name="user", required=false)
	public String user;
	@XmlAttribute(name="password", required=false)
	public String password;
}
