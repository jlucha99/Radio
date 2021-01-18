package Radio;
package (default package);

public interface Interface {
	
	public boolean encenderApagar();
	public boolean esFM();		//determina si está en FM
	public String guardar(int btn); 	//solicita el botón a guardar la emisora
	public String seleccionar(int btn); //solicita el botón a seleccionar
	public double avanzar();	//avanza de emisora
}
