import java.util.Map;

public class Conversion {

    public double convertir(Moneda moneda, String monedaAConvertir, double cantidadAConvertir){

        Map<String, Double> tasasDeConversion = moneda.conversion_rates();
        return cantidadAConvertir * tasasDeConversion.get(monedaAConvertir);
    }
}
