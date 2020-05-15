package lyli.dessin.DAO;

import lyli.dessin.exeption.FormeDoncExistException;
import lyli.dessin.exeption.FormeExisteDeja;

/**
*interface DAO.
* @author Lylia touazi
*@param T
*une Forme ou un groupe de Forme
*/
public interface DAO<T> {
/**
 * *methode create.
	*@param obj
	*l'object qui sera crée.
	*@return
	*un objet de type T 
 * @throws FormeExisteDeja 
 * @throws FormeDoncExistException 
	*/
	T create(T obj) throws FormeExisteDeja, FormeDoncExistException;
	/**
	*methode update.
	*@param id
	*le nom du fichier qui sera lu.
	*@return
	*un objet de type T
	 * @throws FormeDoncExistException 
	*/
	T read(String id) throws FormeDoncExistException ;
	/**
	*methode update.
	*@param obj
	*l'object qui sera modifier.
	*@return
	*un objet de type T
	 * @throws FormeDoncExistException 
	 * @throws FormeExisteDeja 
	*/
	T update(T obj) throws FormeDoncExistException, FormeExisteDeja ;
	/**
	*methode delete.
	*@param obj
	*l'object qui sera suprimer.
	 * @throws FormeDoncExistException 
	*
	*/
	void delete(T obj) throws FormeDoncExistException ;
	}

