package genericlibr;

import java.util.Random;

/**
*this below method is used to get random number
*/
public class JavaUtil {
	
	public int getRandomNumber() {
		Random random  = new Random();
		int num = random.nextInt(100);
		return num;
	}
}
