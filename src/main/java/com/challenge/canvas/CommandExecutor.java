package com.challenge.canvas;

import java.util.ArrayList;
import java.util.List;

import com.challenge.commands.CommandOperation;
import com.challenge.shapes.Canvas;

public class CommandExecutor {

	private final List<CommandOperation> commands = new ArrayList<>(); 
	
	public Canvas executeOperation(CommandOperation command) {		
		commands.add(command);
		return command.execute();
	}
}
