package org.adapter.framework.utility.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.adapter.framework.bean.annotation.Component;
import org.adapter.framework.bean.annotation.Component.Scope;
import org.adapter.framework.utility.contracts.FileProcessing;

@Component(name = "fileManager", scope = Scope.SINGLETONE)
public class FileManager implements FileProcessing {

	public File createNewFile(String fullyQualifiedfileName) {

		return new File(fullyQualifiedfileName);
	}

	public File createNewFile(String fileLocation, String FileName) {

		return new File(fileLocation, FileName);
	}

	public InputStream readFile(String fullyQualifiedFileName) {
		try {
			return new FileInputStream(new File(fullyQualifiedFileName));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public File[] readLocation(String location) {
		File files = new File(location);
		if (files.isDirectory()) {
			return files.listFiles();
		}
		return null;
	}

	public void writeToFile(InputStream inputStream, String fullyQualifiedFileName) {
		try (FileOutputStream outputStream = new FileOutputStream(new File(fullyQualifiedFileName));) {
			int content;
			while ((content = inputStream.read()) != -1) {
				outputStream.write(content);
			}
			inputStream.close();
			outputStream.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public File createDirectory(String location, String directoryName) {
		File file = new File(location, directoryName);
		file.mkdir();
		return file;
	}

}
