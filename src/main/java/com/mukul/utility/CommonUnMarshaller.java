package com.mukul.utility;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
/*
 * 	Purpose : Un-Marshalling - XML to Java Objects
 * 
 */
@SuppressWarnings("rawtypes")
public class CommonUnMarshaller {

	private CommonUnMarshaller() {
	}



	public static Object readObjectFromXML(Class classObj) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(classObj);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		return jaxbUnmarshaller.unmarshal(new File(classObj.getSimpleName() + "Config.xml"));
	}
}
