import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConvert {
    public static void main(String[] args) throws IOException, InterruptedException {
        String API_KEY = "49482143fbb663c146df72fc";
        Scanner input = new Scanner(System.in);

        /*
        Se puede mejorar este código separando casi toda esta parte que va desde
        la linea 3 hasta mas o menos la 65 en una clase a parte que maneje por ejemplo
        todas las interacciones con el usuario, simplificaría y haria mas mantenible el código
         */
        while (true) {
            Utilidades.clearScreen();
            System.out.println("Currency Converter Service");
            Menu menu = new Menu();
            menu.mostrarMenu();

            //controlar el ingreso de una opción no válida
            while (!input.hasNextInt()) {
                System.out.println("¡Error! Debe ingresar un número entero.");
                input.next();
                System.out.print("Elija una opción válida: ");
            }
            Integer option = input.nextInt();
            input.nextLine();

            /*
            La selección del usuario se guarda en un Map puesto se se adapto
            ara poder tener en un solo tipo tanto la modeda origen y destino
            uaando la opción seleccionada sea "Ver últimas conversiones", Salir o
            ay un error, el segundo componente del Map viene vacío.
             */
            Map<String, String> currencies = menu.selectOption(option);
            String currencyFrom = currencies.keySet().iterator().next();
            String currencyTo = currencies.values().iterator().next();

            if (currencyFrom == "Salir") {
                System.out.println("Gracias por usar Currency Converter");
                break;
            }

            if (currencyFrom == "UltimasLecturas") {
                AuditReader recientes = new AuditReader();
                System.out.print("Registros de auditoria más recientes que desea ver: ");
                int recordsAuditoria = input.nextInt();
                recientes.showAudit(recordsAuditoria);
                System.out.print("Oprima una tecla para continuar.");
                continue;
            }

            if (currencyFrom == "Error") {
                System.out.println("Opción no válida. <Enter> para continuar.");
                input.nextLine();
                continue;
            }

            //Control para asegurar que el usuario entra un valor válido a convertir
            System.out.print("Ingresa el valor que deseas convertir: ");
            while (!input.hasNextDouble()) {
                System.out.println("¡Error! Debe ingresar un número decimal.");
                input.next();
                System.out.print("Ingresa el valor que deseas convertir: ");
            }

            double amount = input.nextDouble();
            input.nextLine();

            //Control para no admitir valores negaricos como entrada
            if (amount < 0) {
                System.out.println("No se admiten cantidades negativas.");
                input.nextLine();
                continue;
            }

            String strAmount = String.format("%.1f", amount);
            Convert convert = new Convert();

            /*
              Conversión propiamente dicha, dentro del metodo converTo de la clase convert
              se llama al metodo para guardar la auditoria una vez la conversión se ha realizado.
            */
            Currency datos = convert.convertTo(API_KEY, currencyFrom, currencyTo, strAmount);
            System.out.println("El valor de " + amount + " " + currencies.keySet() + " corresponde al valor final de =>>> " + datos.conversion_result() + " " + currencies.values());
            System.out.println("Oprima una tecla para continuar.");
            input.nextLine();
        }
    }
}
