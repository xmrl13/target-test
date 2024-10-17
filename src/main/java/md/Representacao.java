package md;

public class Representacao {

    static Double sp = 67836.43;
    static Double rj = 36678.66;
    static Double mg = 29229.88;
    static Double es = 27165.48;
    static Double outros = 19849.53;

    public static void main(String[] args) {
        representacao();
    }

    public static void representacao() {

        Double total = sp + rj + mg + es + outros;

        System.out.println("São Paulo representa = " + (sp / total) * 100 + "%");
        System.out.println("Rio de Janeiro representa = " + (rj / total) * 100 + "%");
        System.out.println("Minas Gerais representa = " + (mg / total) * 100 + "%");
        System.out.println("Espirito Santo representa = " + (es / total) * 100 + "%");
        System.out.println("Outros representa = " + (outros / total) * 100 + "%");
    }
}
