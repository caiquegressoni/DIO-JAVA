import br.com.dio.persistence.FilePersistence;
import br.com.dio.persistence.IOFilePersistence;
import br.com.dio.persistence.NIOFilePersistence;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FilePersistence persistence = new NIOFilePersistence("user.csv");

    }
}
