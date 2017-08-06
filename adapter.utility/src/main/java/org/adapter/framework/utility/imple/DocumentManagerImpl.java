package org.adapter.framework.utility.imple;

import java.io.InputStream;

import org.adapter.framework.bean.annotation.Component;
import org.adapter.framework.utility.contracts.DocumentManager;

@Component(name="docManager")
public class DocumentManagerImpl implements DocumentManager {

	public Object readDoc(String fileName, Class<?> parseToType) {

		return null;
	}

	public InputStream writeDoc(String toFile, Object dataSource) {

		return null;
	}

}
