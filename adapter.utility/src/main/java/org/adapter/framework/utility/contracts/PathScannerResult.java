package org.adapter.framework.utility.contracts;

import java.util.List;

/**
 * This interface helps in fetching result after applying file filter.
 * 
 * @author Anish Singh
 *
 */
public interface PathScannerResult {

	/**
	 * This method will return the found file name found using the above filter.
	 * 
	 * @param fileFilter
	 * @return
	 */
	public List<String> getResult(FileFilter fileFilter);

	/**
	 * This method will return all the result found under the path scan
	 * 
	 * @return
	 */
	/*public List<String> getAll();*/
}
