package org.adapter.framework.utility.contracts;

import java.io.InputStream;

public interface DocumentManager {

	public Object readDoc(String fileName, Class<?> parseToType);

	public InputStream writeDoc(String toFile, Object dataSource);
}
