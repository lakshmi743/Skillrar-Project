package genericLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class contains reusable java methods
 * @author User
 *
 */
public class JavaUtility {
	
	/**
	 * This method generates random number within the limit
	 * @param limit
	 * @return
	 */
	public int generateRandomNum(int limit) {
		Random random=new Random();
		return random.nextInt(limit);
		
	}
	
	/**
	 * This method returns current time in specified format
	 * @return
	 */
	public String getCurrentTime() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_YY_hh_mm_ss");
		String currentTime=sdf.format(date);
		return currentTime;
	}

}
