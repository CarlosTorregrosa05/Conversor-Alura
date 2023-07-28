package conversor_challenge.modelos;

/**
 * este enum contiene la abreviatura de cada presión y su
 * equivalencia en atmosferas
 * @author Carlos Andres Torregrosa
 */
public enum EquivalenciaPa {
	Pa("Pa", 101325), Bar("Bar", 1.01325), 
	ATM("atm", 1), Torr("torr", 760),
	PSI("psi", 14.6959), MCA("mca", 10.3326);

	private String presion;
	private Double equivale;

	/**
	 * constructor del enum donde se solicita la abreviatura de la presion
	 * y su respectiva equivalencia en atmosferas
	 * @param moneda
	 * @param equivale
	 */
	EquivalenciaPa(String presion, double equivale) {
		this.presion = presion;
		this.equivale = equivale;
	}

	/**
	 * sirve para obtener la abreviatura de la presion
	 * @return
	 */
	public String getNombrePresion() {
		return this.presion;
	}
	
	/**
	 * sirve para obtener la equivalencia de la presion en atmosferas
	 * @return
	 */
	public Double getEquivalenciaPa() {
		return this.equivale;
	}

}
