package br.com.dio.persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Stream;

public class IOFilePersistence implements FilePersistence {

    private final String currentDir = System.getProperty("user.dir"); //Retorna o diretorio atual.
    private final String storageDir = "/managerFiles/IO/"; //Salvar os arquivos manipulados.
    private final String fileName;

    public IOFilePersistence(String fileName) throws IOException {
        this.fileName = fileName;
        var file = new File(currentDir + storageDir);
        //Verifica se o arquivo e caso nao cria um novo. Tambem dispara uma Exception para caso de erro
        if (!file.exists() && !file.mkdirs()) throw new IOException("Erro a criar arquivo");

        clearFile();
    }

    @Override
    public String write(String data) {
        try (
                var fileWriter = new FileWriter(currentDir + storageDir + fileName, true);
                var bufferedWriter = new BufferedWriter(fileWriter);
                var printWriter = new PrintWriter(bufferedWriter);
        ) {
            printWriter.println(data);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return data;
    }

    @Override
    public boolean remove(String sentence) {
        var content = findAll();
        var contentList = new ArrayList<>(Stream.of(content.split(System.lineSeparator())).toList());

        clearFile();
        if (contentList.stream().noneMatch(c -> c.contains(sentence))) return false;

        contentList.stream()
                .filter(c -> !c.contains(sentence))
                .forEach(this::write);
        return true;
    }

    @Override
    public String replace(String oldContent, String newContent) {

        return null;
    }

    @Override
    public String findAll() {
        var content = new StringBuilder();
        try (var reader = new BufferedReader(new FileReader(currentDir + storageDir + fileName));) {
            String line;
            do {
                line = reader.readLine();
                if ((line != null)) content.append(line).append(System.lineSeparator());
            } while (line != null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return content.toString();
    }

    @Override
    public String findBy(String sentence) {
        String found = "";
        try (
                var reader = new BufferedReader(new FileReader(currentDir + storageDir + fileName))
        ) {
            var line = reader.readLine();
            while (line != null) {
                if (line.contains(sentence)) {
                    found = line;
                    break;
                }
                line = reader.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return found;
    }

    private void clearFile() {
        try (OutputStream outputStream = new FileOutputStream(currentDir + storageDir + fileName)) {
            System.out.printf("Iniciando recursos (%s) \n", currentDir + storageDir + fileName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
