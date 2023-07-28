package conversor_challenge.interfaz;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import conversor_challenge.modelos.Conversor;
import conversor_challenge.modelos.Moneda;
import conversor_challenge.modelos.Presion;
import conversor_challenge.modelos.Unidades;

/**
 * clase principal que muestra cada uno de los páneles de navegación
 * @author Carlos Andres Torregrosa
 */
public class PanelPrincipal {

	/**
	 * crea el panel principal donde se selecciona el tipo de conversor a usar
	 */
	private static void panelInicial() {
		Object conversorPanel = JOptionPane.showInputDialog(null, "Seleccione Un Conversor", "CONVERSOR",
				JOptionPane.OK_CANCEL_OPTION, null, new Object[] { "Monedas", "Presion" }, "Seleccione");
		if (conversorPanel != null)
			ingresoValor(conversorPanel);
	}

	/**
	 * crea el panel donde se ingresa el valor a convertir
	 * adicional a ello, usa el valor arrojado por el panelInicial() para
	 * llamar al siguiente panel para escoger desde y hacia donde se hace
	 * la conversión
	 * @param tipoConversor
	 */
	private static void ingresoValor(Object tipoConversor) {
		boolean continua = true;
		while (continua) {
			try {
				String valorConvertir = JOptionPane.showInputDialog("Ingrese la cantidad a convertir");
				double valor = Double.parseDouble(valorConvertir);
				
				if (valor < 0) {
					JOptionPane.showMessageDialog(null, "Ha ingresado un valor negativo, por favor intente de nuevo");
				} else {
					continua = false;
					Conversor conversor = new Conversor();
					ingresoConversor(conversor, (String) tipoConversor, valor);
				}

			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "No ha ingresado ningun valor, por favor intente de nuevo");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ha ingresado valores no numéricos, por favor intente de nuevo");
			}

		}

	}
	
	/**
	 * para ingresar al conversor se necesitar tener una instancia del objeto Conversor
	 * el tipo de conversor a usar (seleccionado en el primer panel) y el valor ingresado
	 * en el panel anterior para su posterior conversión de unidades
	 * @param conversor
	 * @param tipoConversor
	 * @param valorConvertir
	 */
	private static void ingresoConversor(Conversor conversor, String tipoConversor, Double valorConvertir) {
		
		List<Moneda> monedas = conversor.getMonedas();
		List<Presion> presiones = conversor.getPresion();
		
		String[] valores = null;
		
		switch (tipoConversor) {
		case "Monedas":
			valores = new String[monedas.size()];
			
			for(int i = 0; i < monedas.size(); i++) {
				Moneda m = monedas.get(i);
				String a = m.getUnidad();
				valores[i] = a;
			}
			
			break;
			
		case "Presion":
			valores = new String[presiones.size()];
			
			for(int i = 0; i < presiones.size(); i++) {
				Presion p = presiones.get(i);
				String a = p.getUnidad();
				valores[i] = a;
			}
			
			break;
			
		}

		JComboBox<String> menu1 = new JComboBox<>(valores);
		JComboBox<String> menu2 = new JComboBox<>(valores);
		
		// Crear un JPanel para contener los menús desplegables
		JPanel panel = new JPanel();
		panel.add(new JLabel("Convertir de: "));
		panel.add(menu1);
		panel.add(new JLabel(" a: "));
		panel.add(menu2);

		// Mostrar el panel personalizado en el JOptionPane
		int opcion = JOptionPane.showConfirmDialog(null, panel, "Menús Desplegables", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		
		int opcion1 = menu1.getSelectedIndex();
		int opcion2 = menu2.getSelectedIndex();

		if (opcion == JOptionPane.CANCEL_OPTION) {
            System.exit(0); // Terminar el programa
        }else {
    		switch (tipoConversor) {
    		case "Monedas":
        		convertirDivisas(conversor, monedas.get(opcion1), monedas.get(opcion2), valorConvertir);
    			break;
    			
    		case "Presion":
        		convertirDivisas(conversor, presiones.get(opcion1), presiones.get(opcion2), valorConvertir);
    			break;
    			
    		}
        }
	}

	/**
	 * conversor: instancia del objeto Conversor
	 * desde: unidad desde la cual se quiere hacer la conversión
	 * hacia: unidad a la cual se desea convertir el valor ingresado
	 * cantidad: valor ingresado para ser convertido
	 * @param conversor
	 * @param desde
	 * @param hacia
	 * @param cantidad
	 */
	private static void convertirDivisas(Conversor conversor, Unidades desde, Unidades hacia, Double cantidad) {

		String valorConvertido = String.format("%.2f", conversor.convertir(cantidad, desde, hacia));

		JOptionPane.showMessageDialog(null, "Usted tiene " + cantidad + " " + desde.getUnidad() + ", al convertirlos a "
				+ hacia.getUnidad() + " genera un equivalente de " + valorConvertido + " " + hacia.getUnidad());
		int continua = deseaContinuar();

		if (continua == JOptionPane.NO_OPTION || continua == JOptionPane.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(null, "Programa Finalizado");
		} else {
			panelInicial();
		}
	}

	/**
	 * panel para indicar si el usuario desea volver a utilizar el conversor
	 * o si desea dar por finalizado su uso
	 * @return
	 */
	private static Integer deseaContinuar() {
		int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "Confirmar",
				JOptionPane.YES_NO_CANCEL_OPTION);
		return respuesta;
	}

	public static void main(String[] args) {
		panelInicial();

	}
//
//		try {
//			boolean continuar = true;
//			do {
//
//				Object panelInicio = panelInicial();
//				Conversor conversor = null;
//				Double cantidadConvertir = 0.0;
//				Object opcionesConversor = null;
//				String desde = null, hacia = null;
//
//				if (panelInicio != null) {
//					cantidadConvertir = ingresoValor(panelInicio);
//				}
//				if (cantidadConvertir != 0.0) {
//					conversor = new Conversor();
//					opcionesConversor = ingresoConversor(conversor, (String) panelInicio);
//				}
//				if (opcionesConversor != null) {
//					desde = opcionesConversor;
//					hacia = opcionesConversor;
//					continuar = convertirDivisas(conversor, desde, hacia, cantidadConvertir);
//				}
//				if (panelInicio == null || cantidadConvertir == null || opcionesConversor == null)
//					continuar = false;
//			} while (continuar);
//
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}

}
