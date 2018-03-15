package designpattern.command;

public class UpVoiceCommand implements Command {
	MusicPlayer musicPlayer;
	String preVoice;
	public UpVoiceCommand(MusicPlayer musicPlayer) {
		this.musicPlayer = musicPlayer;
		preVoice = musicPlayer.getVoice();
	}
	
	@Override
	public void execute() {
		preVoice = musicPlayer.getVoice();
		musicPlayer.up();
	}

	@Override
	public void undo() {
		musicPlayer.setVoice(preVoice);
		System.out.println("Voice changed back to " + musicPlayer.getVoice());
	}

}
