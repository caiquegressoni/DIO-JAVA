import br.com.dio.persistence.FilePersistence;
import br.com.dio.persistence.IOFilePersistence;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FilePersistence persistence = new IOFilePersistence("user.csv");

        persistence.write("Jonas;jonas@jonas;21/01/1999");
        persistence.write("Pedro;pedro@pedro;10/02/1999");
        persistence.write("Joao;joao@joao;05/03/1999");
        persistence.write("Ana;ana@ana;29/04/1999");

        System.out.println(persistence.findAll());
        System.out.println("===============================");
        System.out.println(persistence.remove(";ana@"));
        System.out.println("===============================");
        System.out.println(persistence.findBy("Pedro;"));
        System.out.println(persistence.findBy(";ana@"));
        System.out.println(persistence.findBy(";05/03/1999"));
        System.out.println("===============================");
        System.out.println(persistence.replace("@pedro;10/02;", "Jorge;jorge@jorge;25/10/1999"));
        System.out.println("===============================");
        System.out.println(persistence.findAll());

    }
}
