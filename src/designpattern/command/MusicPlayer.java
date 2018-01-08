package designpattern.command;

public class MusicPlayer {
	public static final String HIGH = "high";
	public static final String MEDIUM = "medium";
	public static final String LOW = "low";
	private String voice;
	
	public MusicPlayer(){
		voice = MEDIUM;
	}
	public String getVoice() {
		return voice;
	}
	public void setVoice(String voice) {
		this.voice = voice;
	}
	
	public void up(){
		String currentVoice = getVoice();
		switch (currentVoice) {
		case LOW:
			setVoice(MEDIUM);
			break;
		case MEDIUM:
		case HIGH:
		default:
			setVoice(HIGH);
		}
		System.out.println("Voice changed from " + currentVoice + " to " + getVoice());
	}
	
	public void down(){
		String currentVoice = getVoice();
		switch (currentVoice) {
		case HIGH:
			setVoice(MEDIUM);
			break;
		case MEDIUM:
		case LOW:
		default:
			setVoice(LOW);
		}
		
		System.out.println("Voice changed from " + currentVoice + " to " + getVoice());
	}
}
