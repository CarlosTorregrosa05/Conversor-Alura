package conversor_challenge.modelos;

import java.util.ArrayList;
import java.util.List;

/**
 * Objeto conversor que se utilizará para cargar las opciones de los paneles
 * según el tipo de conversor a usar (moneda o presion), adicional a esto,
 * implementa el método convertir que convierte un valor de una unidad a otra del mismo tipo
 * @author Carlos Andres Torregrosa
 */

public class Conversor {
	private List<Moneda> monedas;
	private List<Presion> presiones;
	
	/**
	 * se inicializan las listas de monedas y presiones
	 * de igual manera de llenan estas listas con los valores que
	 * se encuentran en EquivalenciaUSD y EquivalenciaPa
	 */
	public Conversor() {
		monedas = new ArrayList<>();
		presiones = new ArrayList<>();

		setMonedas();
		setPresiones();
	}

	private void setMonedas() {
		for (EquivalenciaUSD m : EquivalenciaUSD.values()) {
			this.monedas.add(new Moneda(m.getNombreMoneda(), m.getEquivalenciaUSD()));
		}
	}
	
	private void setPresiones() {
		for (EquivalenciaPa p : EquivalenciaPa.values()) {
			this.presiones.add(new Presion(p.getNombrePresion(), p.getEquivalenciaPa()));
		}
	}

	public List<Moneda> getMonedas() {
		return this.monedas;
	}
	
	public List<Presion> getPresion() {
		return this.presiones;
	}

	/**
	 * retorna el valor de conversión desde la unidad 'desde' hacia la unidad 'hacia'
	 * la cantidad ingresada 'cantidad'
	 * @param cantidad
	 * @param desde
	 * @param hacia
	 * @return
	 */
	public double convertir(double cantidad, Unidades desde, Unidades hacia) {
		return cantidad*hacia.getEquivalencia()/desde.getEquivalencia();
	}

}
