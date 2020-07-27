package by.sokhaeduard.eighthhw.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.sokhaeduard.eighthhw.controller.command.impl.AddBookCommand;
import by.sokhaeduard.eighthhw.controller.command.impl.FindBookByIdCommand;
import by.sokhaeduard.eighthhw.controller.command.impl.FindBookByTitleCommand;
import by.sokhaeduard.eighthhw.controller.command.impl.RemoveBookCommand;
import by.sokhaeduard.eighthhw.controller.command.impl.SortByIdCommand;
import by.sokhaeduard.eighthhw.controller.command.impl.SortByTitleCommand;
import by.sokhaeduard.eighthhw.controller.command.impl.WrongCommand;

public class CommandProvider {
	private static final CommandProvider instanceCommandProvider = new CommandProvider();
	private final Map<CommandName, Command> commands = new HashMap<>();

	private CommandProvider() {
		commands.put(CommandName.ADD_BOOK, new AddBookCommand());
		commands.put(CommandName.REMOVE_BOOK, new RemoveBookCommand());
		commands.put(CommandName.FIND_BY_ID, new FindBookByIdCommand());
		commands.put(CommandName.FIND_BY_TITLE, new FindBookByTitleCommand());
		commands.put(CommandName.SORT_BY_ID, new SortByIdCommand());
		commands.put(CommandName.SORT_BY_TITLE, new SortByTitleCommand());
		commands.put(CommandName.NO_SUCH_COMMAND, new WrongCommand());
	}	

	public static CommandProvider getInstance() {
		return instanceCommandProvider;
	}

	public Command getCommand(String commandName) {
		Command command;
		try {
			command = commands.get(CommandName.valueOf(commandName.toUpperCase()));
		} catch (IllegalArgumentException | NullPointerException e) {
			command = commands.get(CommandName.NO_SUCH_COMMAND);
		}
		return command;
	}
}