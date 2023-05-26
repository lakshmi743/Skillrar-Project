package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class Contains reusable method for
 * the actions performed on properties file
 * @author User
 *
 */
public class PropertyFileUtility {
	
	private Properties property;
	
	/**
	 * This method is used to intialize Properties file
	 * @param filePath
	 */
	public void propertyConfig(String filePath) {
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(filePath);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		 property=new Properties();
		try {
			property.load(fis);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used  to fetch the value from
	 * Properties file based on key
	 * @param key
	 * @return
	 */
		
		public String fetchProperty(String key) {
		return property.getProperty(key);
	}

		/**
		 * This method is used to write data into properties file
		 * @param key
		 * @param value
		 * @param filepath
		 * @param message
		 */
		
		public void setDataToProperties(String key,String value,String filepath,String message) {
		property.put(key, value);
		
		try {
		property.store(new FileOutputStream(filepath), message);
		} catch(IOException e) {
			e.printStackTrace();
		}
		}
}


 
