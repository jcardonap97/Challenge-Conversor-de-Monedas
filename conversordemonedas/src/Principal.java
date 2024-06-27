public class Principal {
    public static void main(String[] args){
        Consulta consulta = new Consulta();
        Moneda moneda = consulta.buscaMoneda("COP");
        System.out.println(moneda);
    }
}
