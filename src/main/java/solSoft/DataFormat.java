package solSoft;

import java.time.format.DateTimeFormatter;

public final class DataFormat {

    private DataFormat(){}

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static DateTimeFormatter getFormatter() {
        return formatter;
    }
}
