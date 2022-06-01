
public class Cronometro extends Thread {
	
	private long t;
	private int millis;
	
	public Cronometro() {
		millis=0;
	}
	
	public void startC() {
		t = System.currentTimeMillis();
	}
	
	public void stopC() {
		millis += (int)(Math.ceil((System.currentTimeMillis()-t)));
	}
	
	public double get() {
		return (millis/1000.0);
	}
}
