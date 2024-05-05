public class AuditData {

    /**
    * Clase para el DTO de los registros de auditoria. Contiene únicamente los campos necesarios
    * que requerimos guardar en el archivo auditar.json. Hay dos campos que no estan en servicio
    * que serán capturados al vuelo en tiempo de ejecución: value_to_conver: el valor o la cantidad
    * de la moneda de la cual se desea saber la equivalencia que es digitada por el usuario
     * y el campo: time_conversion que es la fecha y hora del sistema en la que se realizó la operación
    */
    private String result;
    private String base_code;
    private String target_code;
    private Double conversion_rate;
    private Double value_to_convert;
    private Double conversion_result;
    private String time_conversion;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public void setTarget_code(String target_code) {
        this.target_code = target_code;
    }

    public Double getConversion_rate() {
        return conversion_rate;
    }

    public void setConversion_rate(Double conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    public Double getValue_to_convert() {
        return value_to_convert;
    }

    public void setValue_to_convert(Double value_to_convert) {
        this.value_to_convert = value_to_convert;
    }

    public Double getConversion_result() {
        return conversion_result;
    }

    public void setConversion_result(Double conversion_result) {
        this.conversion_result = conversion_result;
    }

    public String getTime_conversion() {
        return time_conversion;
    }

    public void setTime_conversion(String time_conversion) {
        this.time_conversion = time_conversion;
    }

    /**
     * Metodo para mostrar un registro único de audirotia. Se utiliza en cuando se envía a imprimir un AuditData
     * por ejemplo en AuditReader cuando se ejecuta el método showAudit se usa en forma implicita
     * @return
     */

    @Override
    public String toString() {
        return "AuditData{" +
                "result='" + result + '\'' +
                ", base_code='" + base_code + '\'' +
                ", target_code='" + target_code + '\'' +
                ", conversion_rate=" + conversion_rate +
                ", value_to_convert=" + value_to_convert +
                ", conversion_result=" + conversion_result +
                ", time_conversion='" + time_conversion + '\'' +
                '}';
    }
}

