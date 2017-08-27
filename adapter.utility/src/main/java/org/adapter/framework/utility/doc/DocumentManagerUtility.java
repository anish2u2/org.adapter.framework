package org.adapter.framework.utility.doc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.adapter.framework.bean.annotation.Component;
import org.adapter.framework.bean.annotation.Component.Scope;
import org.adapter.framework.logging.contracts.Logger;
import org.adapter.framework.logging.logger.LoggerFactory;
import org.adapter.framework.utility.contracts.DocumentManager;

@Component(name = "docManager", scope = Scope.SINGLETONE)
public class DocumentManagerUtility implements DocumentManager {

	private Logger logger = LoggerFactory.getLogger();

	private static DocumentManager documentManager = null;

	private DocumentManagerUtility() {
		if (documentManager != null)
			throw new RuntimeException("Object Already Created.");
	}

	/**
	 * This method will return the object of DocumentManager.
	 * 
	 * @return
	 */
	public static DocumentManager getInstance() {
		if (documentManager == null) {
			documentManager = new DocumentManagerUtility();
		}
		return documentManager;
	}

	public Object readXML(String fileName, Class<?> parseToType) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(parseToType);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			InputStream stream = getResourceAsStream(fileName);
			Object result = unmarshaller.unmarshal(stream);
			stream.close();
			return result;
		} catch (Exception ex) {
			logger.logException(ex);
		}
		return null;
	}

	public InputStream writeXML(String toFile, Object dataSource) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(dataSource.getClass());
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.marshal(dataSource, new FileOutputStream(new File(toFile)));
		} catch (Exception ex) {
			logger.logException(ex);
		}
		return null;
	}

	private InputStream getResourceAsStream(String FileName) {
		return Thread.currentThread().getContextClassLoader().getResourceAsStream(FileName);
	}

}
