import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Clase para tareas comunes en la aplicación.
 */
public class Utilidades {
    /**
     * Método para limpiar la pantalla cada que se ejecuta una conversion y cuando la aplicación se está ejecutando
     * desde la linea de comandos para que la interacción con el usuario sea mas limpia. Cuando está desde IntelliJ no
     * @throws IOException
     * @throws InterruptedException
     */
    public static void clearScreen() throws IOException, InterruptedException {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Leer un archivo que se pasa como parametro y devuleve un String con el contenido del mismo si existe
     * sino devuelve una cadena vacia.
     * @param nombreArchivo
     * @return
     * @throws IOException
     */
    public static String leerArchivo(String nombreArchivo) throws IOException {
        if (!archivoExiste(nombreArchivo)){
            return "";
        }
        return new String(Files.readAllBytes(Paths.get(nombreArchivo)));
    }

    /**
     * Verifica que un archivo existe en el sistema en la ubicación y con el nombre especificado
     * @param nombreArchivo
     * @return
     */
    public static boolean archivoExiste(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists() && !archivo.isDirectory();
    }
}

