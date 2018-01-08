package designpattern.command;

public class OpenNeteaseMusicCommand implements Command{
	MacbookPro macbookPro;
	public OpenNeteaseMusicCommand(MacbookPro macbookPro) {
		this.macbookPro = macbookPro;
	}
	@Override
	public void execute() {
		macbookPro.openNeteaseMusic();
	}

	@Override
	public void undo() {
		macbookPro.closeNeteaseMusic();
	}
}
