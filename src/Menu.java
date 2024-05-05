import java.util.HashMap;
import java.util.Map;

/**
 * Esta clase tiene la responsabilidad de mostrar en pantalla el menú de opciones de la aplicación y
 * de permitir seleccionar una opción que el usuario solicite.
 */
public class Menu {

    /**
     * Menú de opciones de la aplicación Currency Converter
     */
    public void mostrarMenu(){
        System.out.println("****************************************************\n");
        System.out.println("1) Dólar => Peso argentino");
        System.out.println("2) Peso argentino => Dólar");
        System.out.println("3) Dólar => Real brasileño");
        System.out.println("4) Real brasileño => Dólar");
        System.out.println("5) Dolar => Peso colombiano");
        System.out.println("6) Peso colombiano => Dolar");
        System.out.println("_____________________________");
        System.out.println("7) Ver conversiones recientes");
        System.out.println("_____________________________");
        System.out.println("8) Salir");
        System.out.println("\n****************************************************");
        System.out.print("Elija una opción válida: ");
    }

    /**
     * Método que informa a quien lo invoque la opción que seleccionó el usuario.
     * La respuesta es una estructura Map con dos componentes <String> que tiene la siguiente lógica
     * en el primer dato del Map va la moneda en la cual se proporciona la cantidad a convertir
     * en el segundo dato se proporciona la moneda destino o sea en la cual se quiere hallar la equivalencia.
     * para opciones que no son de conversión tales como salir, ver auditoria por ejemplo el segundo componente
     * va como una cadena vacía, en esos casos solo es útil el primer componente. Salir, ultimasLecturas y Error
     * en este último caso cuando el usuario selecciona una opción no válida
     */
    public Map<String, String> selectOption(Integer option){
        Map<String, String> optionSelected = new HashMap<>();
        switch (option){
            case 1:
                optionSelected.put("USD","ARS");
                break;
            case 2:
                optionSelected.put("ARS","USD");
                break;
            case 3:
                optionSelected.put("USD","BRL");
                break;
            case 4:
                optionSelected.put("BRL","USD");
                break;
            case 5:
                optionSelected.put("USD","COP");
                break;
            case 6:
                optionSelected.put("COP","USD");
                break;
            case 7:
                optionSelected.put("UltimasLecturas","");
                break;
            case 8:
                optionSelected.put("Salir","");
                break;
            default:
                optionSelected.put("Error","");
        }
        return optionSelected;
    }
}
