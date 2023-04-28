package com.mukul.utility;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
/*
 * 	Purpose : UMarshalling - Java Objects to XML
 * 
 */
@SuppressWarnings("rawtypes")
public class CommonMarshaller {
	private CommonMarshaller() {
	}

	// Marshalling - Java Objects to XML

	public static void writeObjectToXML(Class classObj, Object Objectobj) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(classObj);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		// Marshal the list in file
		jaxbMarshaller.marshal(Objectobj,
				new File(classObj.getSimpleName() + "Config.xml"));
	}
}
