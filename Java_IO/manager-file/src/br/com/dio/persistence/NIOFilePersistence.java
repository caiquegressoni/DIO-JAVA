package br.com.dio.persistence;

import java.io.*;

public class NIOFilePersistence implements FilePersistence {

    private final String currentDir = System.getProperty("user.dir"); //Retorna o diretorio atual.
    private final String storageDir = "/managerFiles/IO/"; //Salvar os arquivos manipulados.
    private final String fileName;

    public NIOFilePersistence(String fileName) throws IOException {
        this.fileName = fileName;
        var file = new File(currentDir + storageDir);
        //Verifica se o arquivo e caso nao cria um novo. Tambem dispara uma Exception para caso de erro
        if (!file.exists() && !file.mkdirs()) throw new IOException("Erro a criar arquivo");

        clearFile();
    }


    @Override
    public String write(String data) {
        try (var file = new RandomAccessFile(new File(currentDir + storageDir + fileName), "rw");
             var channel=file.getChannel();
        ){
            file.seek(file.length());
            file.writeBytes(data);
            file.writeBytes(System.lineSeparator());
        } catch(IOException ex){
            ex.printStackTrace();
        }
        return data;
    }

    @Override
    public boolean remove(String sentence) {
        return false;
    }

    @Override
    public String replace(String oldContent, String newContent) {
        return "";
    }

    @Override
    public String findAll() {
        return "";
    }

    @Override
    public String findBy(String sentence) {
        return "";
    }

    private void clearFile() {
        try (OutputStream outputStream = new FileOutputStream(currentDir + storageDir + fileName)) {
            System.out.printf("Iniciando recursos (%s) \n", currentDir + storageDir + fileName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
