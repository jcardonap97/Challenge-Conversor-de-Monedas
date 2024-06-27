import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        Scanner lecturaUsuaio = new Scanner(System.in);
        Consulta consulta = new Consulta();
        Conversion conversion = new Conversion();

        String menu = """
                ****************************************************************
                Bienvenido/a al Conversor de Moneda $$$$$
                
                Elija una opción valida:
                
                1 - Peso colombiano [COP] =>> Dólar [USD]
                2 - Dólar [USD] =>> Peso colombiano [COP]
                3 - Real brasileño [BRL] =>> Dólar [USD]
                4 - Dólar [USD] =>> Real brasileño [BRL]
                5 - Peso chileno [CLP] =>> Dólar [USD]
                6 - Dólar [USD] =>> Peso chileno [CLP]
                7 - Peso colombiano [COP] =>> Real brasileño [BRL]
                8 - Real brasileño [BRL] =>> Peso colombiano [COP]
                9 - Salir
                ****************************************************************
                """;

        int opcion = 0;
        while (opcion != 9){
            System.out.println(menu);
            opcion = lecturaUsuaio.nextInt();

            String monedaBase = "";
            String monedaAConvertir = "";
            switch (opcion){
                case 1:
                    monedaBase = "COP";
                    monedaAConvertir = "USD";
                    break;

                case 2:
                    monedaBase = "USD";
                    monedaAConvertir = "COP";
                    break;

                case 3:
                    monedaBase = "BRL";
                    monedaAConvertir = "USD";
                    break;

                case 4:
                    monedaBase = "USD";
                    monedaAConvertir = "BRL";
                    break;

                case 5:
                    monedaBase = "CLP";
                    monedaAConvertir = "USD";
                    break;

                case 6:
                    monedaBase = "USD";
                    monedaAConvertir = "CLP";
                    break;

                case 7:
                    monedaBase = "COP";
                    monedaAConvertir = "BRL";
                    break;

                case 8:
                    monedaBase = "BRL";
                    monedaAConvertir = "COP";
                    break;

                case 9:
                    System.out.println("Saliendo del programa, gracias por usar nuestros servicios.");
                    continue;

                default:
                    System.out.println("Opción no valida");
                    continue;
            }

            try {
                Moneda moneda = consulta.buscaMoneda(monedaBase);

                System.out.println("Ingrese la cantidad que desea convertir: ");
                double cantidadAConvertir = lecturaUsuaio.nextDouble();

                double resultadoConversion = conversion.convertir(moneda, monedaAConvertir, cantidadAConvertir);
                System.out.println(cantidadAConvertir + " " + "[" + monedaBase + "] son " + resultadoConversion + " " + "[" + monedaAConvertir + "] \n");

            }catch (RuntimeException e){
                System.out.println("Error al buscar la moneda: " + e.getMessage());
                lecturaUsuaio.nextLine();
            }
        }
    }
}
