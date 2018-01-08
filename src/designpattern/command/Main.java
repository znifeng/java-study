package designpattern.command;

public class Main {

	public static void main(String[] args) {
		Coder coder = new Coder("Nisir");
		System.out.println(coder.getCoderName());
		MacbookPro macbookPro = new MacbookPro();
		MusicPlayer musicPlayer = new MusicPlayer();
		Command  OpenChromeCommand = new OpenChromeCommand(macbookPro);
		Command OpenNeteaseMusicCommand = new OpenNeteaseMusicCommand(macbookPro);
		Command upVoiceCommand = new UpVoiceCommand(musicPlayer);
		Command downVoiceCommand = new DownVoiceCommand(musicPlayer);
		
		System.out.println("=============Dividing Line1=============");
		coder.addCommand(OpenChromeCommand);
		coder.execute();
		coder.undo();
		System.out.println("=============Dividing Line2=============");
		
		coder.setCommand(0, OpenNeteaseMusicCommand);
		coder.execute();
		coder.undo();
		System.out.println("=============Dividing Line3=============");
		
		coder.addCommand(OpenChromeCommand);
		coder.execute();
		coder.undo();
		System.out.println("=============Dividing Line4=============");
		
		coder.clearCommands();
		coder.execute();
		coder.undo();
		System.out.println("=============Dividing Line5=============");
		
		coder.addCommand(upVoiceCommand);
		coder.execute();
		
		System.out.println("=============Dividing Line6=============");
		
		coder.replaceCommand(upVoiceCommand, downVoiceCommand);
		coder.execute();
		coder.undo();
	}

}
