import br.com.dio.persistence.FilePersistence;
import br.com.dio.persistence.IOFilePersistence;
import br.com.dio.persistence.NIOFilePersistence;
import br.com.dio.persistence.NewNIOFilePersistence;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FilePersistence persistence = new NewNIOFilePersistence("user.csv");
        System.out.println("===================================");
        System.out.println(persistence.write("Carlos;carlos@gmail.com;27/06/2000;"));
        System.out.println("===================================");
        System.out.println(persistence.write("Casio;casio@hotmail.com;28/07/2000;"));
        System.out.println("===================================");
        System.out.println(persistence.findAll());
        System.out.println("===================================");
        System.out.println(persistence.findBy(";28/07/2000;"));
        System.out.println("===================================");
        System.out.println(persistence.remove("Carlos;"));
        System.out.println("===================================");
        System.out.println(persistence.findAll());
        System.out.println("===================================");
        System.out.println(persistence.replace("Casio;", "Rolex;rolex@yahoo.com;09/09/1999"));
    }
}
