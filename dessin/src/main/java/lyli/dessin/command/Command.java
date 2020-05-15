package lyli.dessin.command;

import java.sql.SQLException;

import lyli.dessin.exeption.FormeDoncExistException;
import lyli.dessin.exeption.FormeExisteDeja;

public interface Command {
	public void execute() throws SQLException, FormeExisteDeja, FormeDoncExistException; 
}
