package uiMain;

import java.util.ArrayList;

public class ConsultasM extends OpcionDeMenu {

	public ConsultasM(String key){
		super(key);
	}
	
	
	private static ArrayList<OpcionDeMenu> consultOptionsDefault = new ArrayList<OpcionDeMenu>() {
		{
			add(BaseDatos.Datos.operations.get("6"));
			add(BaseDatos.Datos.operations.get("8"));
		}
	};
	

	@Override
	public void ejecutar() {
		ArrayList<OpcionDeMenu> consultOptions = new ArrayList<OpcionDeMenu>() {
			{
				add(BaseDatos.Datos.operations.get("6"));
				add(BaseDatos.Datos.operations.get("8"));
			}
		};

		MenuDeConsola ConsultMenu = new MenuDeConsola(consultOptions);

		ConsultMenu.lanzarMenu();
	}
	



	@Override
	public String toString() {
		return "Consultas";
	}

}