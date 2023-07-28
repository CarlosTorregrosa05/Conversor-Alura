package conversor_challenge.modelos;

/**
 * este enum contiene la abreviatura de cada moneda y su
 * equivalencia en dolares estadounidenses
 * @author Carlos Andres Torregrosa
 */
public enum EquivalenciaUSD {

	COP("COP", 4001.1), USD("USD", 1), EUR("EUR", 0.97),
	GBP("GBP", 0.78), JPY("JPY", 139.32), AUD("AUD", 1.5);

	private String moneda;
	private Double equivale;
	
	/**
	 * constructor del enum donde se solicita la abreviatura de la moneda
	 * y su respectiva equivalencia en dólares estadounidenses
	 * @param moneda
	 * @param equivale
	 */
	EquivalenciaUSD(String moneda, double equivale) {
		// TODO Auto-generated constructor stub
		this.moneda = moneda;
		this.equivale = equivale;
	}
	
	/**
	 * sirve para obtener la abreviatura de la moneda
	 * @return
	 */
	public String getNombreMoneda() {
		return this.moneda;
	}
	
	/**
	 * sirve para obtener la equivalencia de la moneda en USD
	 * @return
	 */
	public Double getEquivalenciaUSD() {
		return this.equivale;
	}	
	
}
