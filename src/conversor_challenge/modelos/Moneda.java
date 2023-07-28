package conversor_challenge.modelos;

public class Moneda extends Unidades{

	/**
	 * @param unidad
	 * @param equivalencia
	 */
	public Moneda(String unidad, Double equivalencia) {
		super(unidad, equivalencia); //llama al constructor de su padre Unidades
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

}
