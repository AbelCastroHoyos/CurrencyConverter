import java.util.List;

public class AuditDataList {
    /**
     * Se usa esta clase para proporcionar una estructura adecuada para la lectura del archivo de auditoria
     * Esta clase es usada en la clase AuditReader.
     */
    private List<AuditData> auditDataList;

    public AuditDataList(List<AuditData> auditDataList){
        this.auditDataList = auditDataList;
    }

    public List<AuditData> getAuditDataList(){
        return auditDataList;
    }

    public void setAuditDataList(List<AuditData> auditDataList){
        this.auditDataList = auditDataList;
    }
}
