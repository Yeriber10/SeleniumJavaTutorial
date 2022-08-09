package helpers;

public class Helpers {
	
	public void sleepSeconds(int seconds) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
