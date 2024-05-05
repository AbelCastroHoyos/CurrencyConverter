import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AuditWriter {
    /**
     * Método que se usa para guardar el registro de cada conversión de moneda
     * realizado con este programa. Recibe como entrada el jSon a guardar y la
     * cantidad convertida (amount). El archivo está ubicado en el directorio
     * del programa por defecto y tiene el nombre de auditor.json
     * @param jSon
     * @param amount
     */
    public AuditWriter(String jSon, String amount){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Currency responseData = gson.fromJson(jSon,Currency.class);

        AuditData auditData = new AuditData();

        auditData.setResult(responseData.result());
        auditData.setBase_code(responseData.base_code());
        auditData.setTarget_code(responseData.target_code());
        auditData.setConversion_rate(responseData.conversion_rate());
        auditData.setValue_to_convert(Double.valueOf(amount));
        auditData.setConversion_result(responseData.conversion_result());
        auditData.setTime_conversion(String.valueOf(LocalDateTime.now()));

        try {
            if (!Utilidades.archivoExiste("auditar.json")) {
                // Si el archivo no existe, crea una lista vacía.
                AuditDataList auditDataList = new AuditDataList(new ArrayList<>());
                gson.toJson(auditDataList, new FileWriter("auditar.json"));
            }

            // Lee la lista actual de registros de auditoria.
            String jsonAnterior = Utilidades.leerArchivo("auditar.json");
            AuditDataList auditDataList = gson.fromJson(jsonAnterior, AuditDataList.class);
            if (auditDataList == null) {
                auditDataList = new AuditDataList(new ArrayList<>());
            }

            // Agrega un nuevo registro a la lista.
            auditDataList.getAuditDataList().add(auditData);

            // Escribe la lista actualizada de registros de auditoria en el archivo.
            FileWriter auditar = new FileWriter("auditar.json");
            gson.toJson(auditDataList, auditar);
            auditar.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
