package lyli.dessin.command;

import lyli.dessin.Forme;

public class CommandDeplacer implements Command  {
	Forme f = null;
	public CommandDeplacer(Forme f) {
	 this.f = f;
 }
	@Override
	public void execute() {
		System.out.println("eeeeeeeeeeeeeeeee");
		
	}

}
