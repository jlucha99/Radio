package Radio;

//Karina Valladares y José Lucha
//Carnés 18005 y 18904, respectivamente
//Algoritmos y estructura de datos, sección 30
//Hoja de trabajo 1

public class Radio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean estaEncendido;	//verdadero ssi estÃ¡ encendido
		boolean esFM;		//determina si estÃ¡ en FM
		double estRadio; 	//estaciÃ³n actual de la radio
		double estAM;		// estaciÃ³n actual AM
		double estFM;		// estaciÃ³n actual FM
		double favFM; 	// los 'favoritos' del FM
		double favAM;		// los 'favoritos' del AM
		double inicioFM = 88.5;		// valor inicial de la radio FM
		double inicioAM = 1030.0;		// valor inicial de la radio AM
		
		//construye una radio que inicialmente estÃ¡ en FM, con valores predeterminados para AM y FM
		public Radio(){
			favFM = new double[12];
			favAM = new double[12];
			for (int i = 0; i < 12; i++){
				favFM[i] = inicioFM;
				favAM[i] = inicioAM;
			}
			
			on();
			AM();
			press(1);
			FM();
			press(1);
			off();
		}
		
		//es verdadero si y solo si estÃ¡ encendida la radio
		public boolean estaEncendido(){
			return estaEncendido;
		}
		
		//es verdadero si y solo si estÃ¡ en FM
		public boolean esFM(){
			return esFM;
		}
		
		//es verdadero si y solo si es una estaciÃ³n aceptada
		//se encuentra entre 530 y 1610 y es un mÃºltiplo de 10
		//verifica que este en [530, 1610]
		//congruente con 0 en mÃ³dulo 10
		protected boolean validacionAM(double btn){
			return (530 <= btn && btn <= 1610) && (0.0 == btn % 10.0);
		}
		
		//verifica que la estaciÃ³n FM sea vÃ¡lida
		//revisa que estÃ© dentro de [87.9, 107.9]
		//revisa que el residio sea 0 al dividir entre 0.02
		protected boolean validacionFM(double btn){
			return (87.9 <= btn && btn <= 107.9) && ((((int)(btn * 10 + 0.5)) - 879) % 2) == 0;
		}
		
		//determina que estÃ© encendido, el botÃ³n entre 1 y 12 y que la frecuencia sea la indicada
		//guarda la estaciÃ³n en los 'favoritos'
		public void guardar(int btn, double freq) {
			if (!estaEncendido()) return;
			if (btn >= 1 && btn <= 12) throw new FailedPrecondition("Valor del botÃ³n entre 1 y 12");
			if (esFM() && validacionFM(freq)) {
				favFM[btn - 1] = freq;
			}
			if ((!esFM()) && validacionAM(freq)) {
				favAM[btn - 1] = freq;
			}	
		}
		
		//verifica que el botÃ³n estÃ© entre 1 y 12
		//mueve la radio a la estaciÃ³n seleccionada
		public void seleccionar (int btn) {
			if (esFM()) {
				sintonizar(favFM[btn - 1]);
			}
			else {
				sintonizar(favAM[freq - 1]);
			}
		}
		
		//verifica que la radio estÃ© encendida y sea estaciÃ³n vÃ¡lida
		//sintoniza la estaciÃ³n indicada
		public void sintonizar(double freq) {
			if (!estaEncendida()) {
				return;
			}
			if (esFM() && validacionFM(freq)) {
				emisora = emisoraFM = freq;
			}
			else if ((!esFM()) && validacionAM(freq)) {
				emisora = emisoraAM = freq;
			}
		}
		
		//devuelve la emisora sintonizada
		public double emisora() {
			return emisora;
		}
		
		//cambia el rango a AM y lo lleva la Ãºltima emisora AM
		public void AM() {
			esFM = false;
			emisora = emisoraAM;
		}
		
		//cambia el rango a FM y lo lleva la Ãºltima emisora FM
		public void FM() {
			esFM = true;
			emisora = emisoraFM;
		}
		
		//encender la radio
		public void encender() {
			estaEncendido = true;
		}
		
		//apagar la radio
		public void apagar() {
			estaEncendido = false;
		}
		
		//representaciÃ³n de la radio por medio de strings
		public String toString() {
			String resultado = "Radio: ";
			if (estaEncendida()) {
				resultado += "encendida en frecuencia: ";
			}
			else {
				resultado += "apagada";
			}
			if (esFM()) {
				resultado += "FM, sintonizando " + emisora;
			}
			else {
				resultado += "AM, sintonizando " + emisora;
			}
			int i;
			resultado += "Favoritos FM: ";
			for (i = 1; i <= 12; i++) {
				resultado += "\n" + favFM[i -1];
			}
			
			resultado += "\n";
			resultado += "Favoritos AM: ";
			for (i = 1; i <= 12; i++) {
				resultado += "\n" + favAM[i -1];
			}
		}
		return resultado;

	}
}
