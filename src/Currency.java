import java.math.BigDecimal;
import java.util.Map;

/**
 * record utilizado a modo de DTO para almacenar en una estructura de objeto la respuesta del servicio de conversion.
 * @param result
 * @param documentation
 * @param terms_of_use
 * @param time_last_update_unix
 * @param time_last_update_utc
 * @param time_next_update_unix
 * @param time_next_update_utc
 * @param base_code
 * @param target_code
 * @param conversion_rate
 * @param conversion_result
 */
public record Currency(
        String result,
        String documentation,
        String terms_of_use,
        Integer time_last_update_unix,
        String time_last_update_utc,
        Integer time_next_update_unix,
        String time_next_update_utc,
        String base_code,
        String target_code,
        Double conversion_rate,
        Double conversion_result){}
