package conversor_challenge.modelos;

/**
 * @author Carlos Torregrosa
 */
public abstract class Unidades {

	private String unidad;
	private Double equivalencia;
	
	/**
	 * Constructor de la unidad dando su nomnre y equivalencia en USD para monedas,
	 * en metros cubicos para medidas de volumen.
	 * @param unidad
	 * @param equivalencia
	 */
	public Unidades(String unidad, Double equivalencia) {
		this.unidad = unidad;
		this.equivalencia = equivalencia;
	}
	
	
	public String getUnidad() {
		return this.unidad;
	}

	public Double getEquivalencia() {
		return this.equivalencia;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.unidad + " " + this.equivalencia;
	}
	
}
