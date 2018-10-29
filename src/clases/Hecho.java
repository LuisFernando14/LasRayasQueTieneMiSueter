/**
 * 
 */
package clases;

/**
 * @author lfern
 *
 */
public class Hecho {
	
	private String [] hecho = null;
	
	public Hecho(String ... hecho) {
		this.hecho = hecho;
	}
	
	public Hecho() {
		// Bien empty!
	}
	
	public boolean define(String ... hecho) {
		if(this.hecho != null)
			return false;
		this.hecho = hecho;
		return true;
	}
	
	public String [] getHecho() {
		return this.hecho;
	}
	
}