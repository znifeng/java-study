package designpattern.command;

public class OpenChromeCommand implements Command{
	MacbookPro macbookPro;
	public OpenChromeCommand(MacbookPro macbookPro) {
		this.macbookPro = macbookPro;
	}

	public void execute() {
		macbookPro.openChrome();
	}

	public void undo() {
		macbookPro.closeChrome();
	}
}
