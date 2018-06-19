package satguru.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author digi
 *
 */
public class GetPropertyValue {
	/**
	 * @description This method is used to read the value from config.properties file based on key
	 * @param key
	 * @return
	 */
	public static String getPropertyValue(String key) {
		String value="";
		try{
		
		Properties prop=new Properties();
		prop.load(new FileInputStream(new File("/home/ttuser10/workspace/TTNC/config.properties")));
		value = prop.getProperty(key);
		
		}
		catch(IOException e){
			e.printStackTrace();
			
		}
		return value;
		
	}

}


