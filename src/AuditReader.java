import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class AuditReader {
    /**
     * Leer los registros de auditoria que están en el archivo auditar.json
     * y mostrarlos en pantalla. Siempre muestra los ultimos n registros
     * definidos por el usuario en el momento de invocar la funcionalidad.
     * @param numRecords
     */
    public void showAudit(int numRecords) {
        // Si los registros solicitadas es cero se muestran los 3 registros más recientes por defecto
        int value = (numRecords !=0) ? numRecords : 3;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Scanner input = new Scanner(System.in);

        if (!Utilidades.archivoExiste("auditar.json")) {
            System.out.println("No se ha realizado aún ningún uso de la aplicación");
            System.out.println("No hay nada para mostrar");
            return;
        }

        try (Reader reader = new FileReader("auditar.json")) {
            AuditDataList auditDataList = gson.fromJson(reader, AuditDataList.class);
            Deque<AuditData> lastRecordsAuditData = new ArrayDeque<>();

            int startIndex = Math.max(0, auditDataList.getAuditDataList().size() - value);
            for (int i = startIndex; i < auditDataList.getAuditDataList().size(); i++) {
                lastRecordsAuditData.add(auditDataList.getAuditDataList().get(i));
            }

            // Mostrar los elementos mas recientes pedidos por el usuario
            System.out.println("Conversiones mas recientes");
            System.out.println("-----------------------------------------------");
            for(AuditData auditData : lastRecordsAuditData){
                System.out.println(gson.toJson(auditData));
                System.out.println("-----------------------------------------------");
            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
