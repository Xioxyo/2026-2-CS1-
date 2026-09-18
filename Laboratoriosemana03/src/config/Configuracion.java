
package config;
import java.io.InputStream;
import java.util.Properties;
public class Configuracion {
    private final Properties props = new Properties();

    public Configuracion() throws Exception {

        try (InputStream in = getClass()
                .getClassLoader()
                .getResourceAsStream("application.properties")) {

            props.load(in);
        }
    }

    public String getUrlPagos() {
        return props.getProperty("pagos.url");
    }

    public double getUmbralVip() {
        return Double.parseDouble(
                props.getProperty("pagos.umbral.vip")
        );
    }

    public int getTimeoutSegundos() {
        return Integer.parseInt(
                props.getProperty("pagos.timeout.segundos")
        );
    }
}
