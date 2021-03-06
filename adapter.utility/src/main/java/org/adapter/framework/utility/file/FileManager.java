package org.adapter.framework.utility.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import org.adapter.framework.bean.annotation.Component;
import org.adapter.framework.bean.annotation.Component.Scope;
import org.adapter.framework.logging.contracts.Logger;
import org.adapter.framework.logging.logger.LoggerFactory;
import org.adapter.framework.utility.contracts.FileFilter;
import org.adapter.framework.utility.contracts.FileProcessing;

@Component(name = "fileManager", scope = Scope.SINGLETONE)
public class FileManager implements FileProcessing {
	Logger logger = LoggerFactory.getLogger();

	private static FileManager fileManager = null;

	private FileManager() {
		if (fileManager != null) {
			throw new RuntimeException("Object Already Created.");
		}
	}

	/**
	 * This method will return the object of FileProcessing.
	 * 
	 * @return
	 */
	public static FileProcessing getInstance() {
		if (fileManager == null) {
			fileManager = new FileManager();
		}
		return fileManager;
	}

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

	@Override
	public List<FileFilter> readJar(String jarPath, List<FileFilter> fileFilter) {
		// jarPath = jarPath.replace("/", File.separator);
		logger.info("Reading jar file :" + jarPath);
		try (JarInputStream jarInputStream = new JarInputStream(new FileInputStream(new File(jarPath)));) {
			JarEntry jarEntry = jarInputStream.getNextJarEntry();
			while (jarEntry != null) {
				if (!jarEntry.isDirectory())
					processFileFilter(jarEntry.getName().replace("/", File.separator), fileFilter);
				jarEntry = jarInputStream.getNextJarEntry();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private void processFileFilter(String fileName, List<FileFilter> fileFilters) {
		for (FileFilter fileFilter : fileFilters) {
			fileFilter.filter(fileName);
		}
	}

	@Override
	protected void finalize() throws Throwable {
		fileManager = null;
		super.finalize();
	}
}
