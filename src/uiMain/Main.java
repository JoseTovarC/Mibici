package uiMain;

import gestorAplicacion.Bike.Bicicleta;
import gestorAplicacion.Bike.Distribuidor;
import gestorAplicacion.Bike.Estacion;
import gestorAplicacion.User.*;
import gestorAplicacion.Work.Multa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import BaseDatos.*;

//import gestorAplicacion.Work.*;
public class Main {
	static boolean aux= true;	
	public static Persona user;
	public static void main(String[] args) throws IOException {

		Main.config_inicio();
		// TODO: condicion de break
        try {       
        	while (aux) {	
				Main.user.getMenu().lanzarMenu();											
			}
        }
        catch(Exception e){
        	Datos.guardarDatos();	
    		System.out.println("Adios");
        }
        finally{
        	Datos.guardarDatos();
        }
		

	}

	public static void config_inicio() {

		BaseDatos.Datos.cargarDatos();
		// Cargar las opciones del programa primero
		BaseDatos.Datos.operations.put("0", new Modificar("0"));
		BaseDatos.Datos.operations.put("1", new Login("1"));
		BaseDatos.Datos.operations.put("2", new SignUp("2"));
		BaseDatos.Datos.operations.put("3", new SignOut("3"));
		BaseDatos.Datos.operations.put("4", new salir("4"));
		BaseDatos.Datos.operations.put("5", new ConsultasU("5"));
		BaseDatos.Datos.operations.put("6", new PerfilTarjeta("6"));
		BaseDatos.Datos.operations.put("7", new Deuda("7"));
		BaseDatos.Datos.operations.put("8", new cant_bicicletas_esta("8"));	
		BaseDatos.Datos.operations.put("9", new Pedir_bicicleta("9"));	
		BaseDatos.Datos.operations.put("10", new Devolver_bicicleta("10"));
		BaseDatos.Datos.operations.put("11", new Recargar_tarjeta("11"));
		BaseDatos.Datos.operations.put("12", new Pagar_multas("12"));
		BaseDatos.Datos.operations.put("13", new ConsultasM("13"));
		BaseDatos.Datos.operations.put("14", new CreacionM("14"));
		BaseDatos.Datos.operations.put("15", new CrearBicicleta("15"));
		BaseDatos.Datos.operations.put("16", new crearDistribuidor("16"));
		BaseDatos.Datos.operations.put("17", new crearEstacion("17"));
		BaseDatos.Datos.operations.put("18", new Funcionalidades("18"));
		BaseDatos.Datos.operations.put("19", new MayorUsoP("19"));
		BaseDatos.Datos.operations.put("20", new MayorEdad("20"));
		BaseDatos.Datos.operations.put("21", new MenorEdad("21"));
		BaseDatos.Datos.operations.put("22", new PromEdad("22"));
		BaseDatos.Datos.operations.put("23", new PorcGen("23"));
		BaseDatos.Datos.operations.put("24", new PorcUsoGen("24"));
		BaseDatos.Datos.operations.put("25", new MayorCantM("25"));
		BaseDatos.Datos.operations.put("26", new MayorUsoB("26"));
		BaseDatos.Datos.operations.put("27", new MayorUsoE("27"));
		BaseDatos.Datos.operations.put("28", new PromCantB("28"));
		BaseDatos.Datos.operations.put("29", new CreacionA("29"));
		BaseDatos.Datos.operations.put("30", new SignUpM("30"));
		BaseDatos.Datos.operations.put("31", new SignUpA("31"));
		BaseDatos.Datos.operations.put("32", new Multar("32"));
		
		
		BaseDatos.Datos.hashMulta.put((byte)1, new Multa((byte)1, "Tiempo maximo excedido.", 30000));
		BaseDatos.Datos.hashMulta.put((byte)2, new Multa((byte)2, "Danio intencional.", 75000));
		BaseDatos.Datos.hashMulta.put((byte)3, new Multa((byte)3, "Numero de pasajeros excedido.", 30000));
		BaseDatos.Datos.hashMulta.put((byte)4, new Multa((byte)4, "Fines comerciales", 80000));
		BaseDatos.Datos.hashMulta.put((byte)5, new Multa((byte)5, "Carga maxima excedida", 25000));
		BaseDatos.Datos.hashMulta.put((byte)6, new Multa((byte)6, "Estado Embriaguez", 80000));
		
		
		
		Main.user = Usuario.nuevoUsuarioInvitado();
		
		BaseDatos.Datos.cargarDatos();
		Admin.newAdminUser("Admin", (byte)18, (long)1, "null", "666");
		//Usuario invitado(por defecto)
		
		/*new Estacion("1", "Automatica", true,4, (Moderador) Usuario.getUsuarioPorUsername((long) 1193126480));
		new Bicicleta(1, BaseDatos.Datos.hashEstacion.get("1"));
		new Bicicleta(2, BaseDatos.Datos.hashEstacion.get("1"));*/
		
		ArrayList<OpcionDeMenu> ModeradorOptions = new ArrayList<OpcionDeMenu>(){
			{
						add(BaseDatos.Datos.operations.get("13"));
						add(BaseDatos.Datos.operations.get("9"));
						add(BaseDatos.Datos.operations.get("10"));
						add(BaseDatos.Datos.operations.get("11"));
						add(BaseDatos.Datos.operations.get("14"));
						add(BaseDatos.Datos.operations.get("18"));
						add(BaseDatos.Datos.operations.get("32"));
						add(BaseDatos.Datos.operations.get("3"));						
			}
		};
				
		MenuDeConsola ModeradorMenu = new MenuDeConsola(ModeradorOptions);
		new Moderador("Jose Orlando Tovar Cano", (byte) 18, (long)1193126480, "M", "1193",0,ModeradorMenu,Estacion.getEstacionporId("0"));
		
		

	}

}