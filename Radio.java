package Radio;

//Karina Valladares y José Lucha
//Carnés 18005 y 18904, respectivamente
//Algoritmos y estructura de datos, sección 30
//Hoja de trabajo 1

public class Radio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		protected boolean estaEncendido;
		protected boolean esFM;		//determina si está en FM
		protected double estRadio; 	//estación actual de la radio
		protected double estAM;		// estación actual AM
		protected double estFM;		// estación actual FM
		protected double favFM; 	// los 'favoritos' del FM
		protected double favAM;		// los 'favoritos' del AM
		protected double inicioFM;		// valor inicial de la radio FM
		protected double inicioAM;		// valor inicial de la radio AM
		
		//construye una radio que inicialmente está en FM, con valores predeterminados para AM y FM
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
		
		//es verdadero si y solo si está encendida la radio
		public boolean estaEncendido(){
			return estaEncendido;
		}
		
		//es verdadero si y solo si está en FM
		public boolean esFM(){
			return esFM;
		}
		
		//es verdadero si y solo si es una estación aceptada
		//se encuentra entre 530 y 1610 y es un múltiplo de 10
		//verifica que este en [530, 1610]
		//congruente con 0 en módulo 10
		protected boolean validacionAM(double btn){
			return (530 <= btn && btn <= 1610) && (0.0 == btn % 10.0);
		}
		
		//verifica que la estación FM sea válida
		//revisa que esté dentro de [87.9, 107.9]
		//revisa que el residio sea 0 al dividir entre 0.02
		protected boolean validacionFM(double btn){
			return (87.9 <= btn && btn <= 107.9) && ((((int)(btn * 10 + 0.5)) - 879) % 2) == 0;
		}
		
		//determina que esté encendido, el botón entre 1 y 12 y que la frecuencia sea la indicada
		//guarda la estación en los 'favoritos'
		public void guardar(int btn, double freq) {
			if (!estaEncendido()) return;
			if (btn >= 1 && btn <= 12) throw new FailedPrecondition("Valor del botón entre 1 y 12");
			if (esFM() && validacionFM(freq)) {
				favFM[btn - 1] = freq;
			}
			if ((!esFM()) && validacionAM(freq)) {
				favAM[btn - 1] = freq;
			}	
		}
		
		//verifica que el botón esté entre 1 y 12
		//mueve la radio a la estación seleccionada
		public void seleccionar (int btn) {
			if (esFM()) {
				sintonizar(favFM[btn - 1]);
			}
			else {
				sintonizar(favAM[freq - 1]);
			}
		}
		
		//verifica que la radio esté encendida y sea estación válida
		//sintoniza la estación indicada
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
		
		//cambia el rango a AM y lo lleva la última emisora AM
		public void AM() {
			esFM = false;
			emisora = emisoraAM;
		}
		
		//cambia el rango a FM y lo lleva la última emisora FM
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
		
		
		
		
		
		
		

	}
}
