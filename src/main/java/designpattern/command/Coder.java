package designpattern.command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Coder {
	List<Command> commands;
	String coderName;
	public Coder(String coderName){
		commands = new ArrayList<>();
		this.coderName = coderName;
	}
	
	public String getCoderName() {
		return coderName;
	}

	public void setCoderName(String coderName) {
		this.coderName = coderName;
	}

	public void addCommand(Command command){
		if (!commands.contains(command)){
			this.commands.add(command);
		}
	}
	
	public void deleteCommamd(Command command){
		this.commands.remove(command);
	}
	
	public void setCommand(int index,  Command command){
		if (commands.size()>index){
			commands.set(index, command);
		}
	}
	
	public void replaceCommand(Command preCommand, Command curCommand){
		int index=commands.indexOf(preCommand);
		if ( index>=0 ){
			setCommand(index, curCommand);
		}
	}
	
	public void clearCommands(){
		commands.clear();
	}
	
	public void execute(){
		Iterator<Command> iterator = commands.iterator();
		if (!iterator.hasNext()){
			System.out.println("No command has been added.");
			return;
		}
		
		while (iterator.hasNext()){
			Command command = iterator.next();
			command.execute();
		}
	}
	
	public void undo(){
		Iterator<Command> iterator = commands.iterator();
		while (iterator.hasNext()){
			Command command = iterator.next();
			command.undo();
		}
	}
	
	public void print(){
		StringBuffer stringBuffer = new StringBuffer();
		Iterator<Command> iterator = commands.iterator();
		while (iterator.hasNext()){
			Command command = iterator.next();
			stringBuffer.append(command.getClass().getSimpleName() + "-");
		}
		stringBuffer.deleteCharAt(stringBuffer.length()-1);
		System.out.println(stringBuffer.toString());
	}
}
