package lyli.dessin.command;

import java.sql.SQLException;

public interface Command {
	public void execute() throws SQLException; 
}
