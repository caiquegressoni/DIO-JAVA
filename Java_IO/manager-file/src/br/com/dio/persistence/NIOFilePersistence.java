package br.com.dio.persistence;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class NIOFilePersistence extends FilePersistence {

    public NIOFilePersistence(final String fileName) throws IOException {
        super(fileName, "/managerFiles/NIO/");
        var file = new File(currentDir + storageDir);
        //Verifica se o arquivo e caso nao cria um novo. Tambem dispara uma Exception para caso de erro
        if (!file.exists() && !file.mkdirs()) throw new IOException("Erro a criar arquivo");

        clearFile();
    }


    @Override
    public String write(String data) {
        try (var file = new RandomAccessFile(new File(currentDir + storageDir + fileName), "rw");
        ) {
            file.seek(file.length());
            file.writeBytes(data);
            file.writeBytes(System.lineSeparator());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return data;
    }

    @Override
    public boolean remove(String sentence) {
        var content = findAll();
        var contentList = Stream.of(content.split(System.lineSeparator())).toList();

        if(contentList.stream().anyMatch(c -> c.contains(sentence))) return false;

        clearFile();
        contentList.stream().filter(c -> c.contains(sentence)).forEach(this::write);

        return true;
    }

    @Override
    public String replace(String oldContent, String newContent) {
        var contentList = toListStrings();

        if(contentList.stream().noneMatch(c -> c.contains(oldContent))) return "";

        clearFile();
        contentList.stream()
                .map(c -> c.contains(oldContent) ? newContent : c)
                .forEach(this::write);
        return newContent;
    }

    @Override
    public String findAll() {
        var content = new StringBuilder();
        try (var file = new RandomAccessFile(new File(currentDir + storageDir + fileName), "r");
             var channel = file.getChannel();
        ) {
            var buffer = ByteBuffer.allocate(256);
            var byteReader = channel.read(buffer);
            while (byteReader != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    content.append((char) buffer.get());
                }
                buffer.clear();
                byteReader = channel.read(buffer);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return content.toString();
    }

    @Override
    public String findBy(String sentence) {
        var content = new StringBuilder();
        try (var file = new RandomAccessFile(new File(currentDir + storageDir + fileName), "r");
             var channel = file.getChannel();
        ) {
            var buffer = ByteBuffer.allocate(256);
            var byteReader = channel.read(buffer);
            while (byteReader != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    while(!content.toString().endsWith(System.lineSeparator())){
                        content.append((char) buffer.get());
                    }
                    if(content.toString().contains(sentence)){
                        break;
                    }else{
                        content.setLength(0);
                    }
                    if(!content.isEmpty()){
                        break;
                    }
                }
                buffer.clear();
                byteReader = channel.read(buffer);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return content.toString();
    }

    private void clearFile() {
        try (OutputStream outputStream = new FileOutputStream(currentDir + storageDir + fileName)) {
            System.out.printf("Iniciando recursos (%s) \n", currentDir + storageDir + fileName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private List<String> toListStrings() {
        var content = findAll();
        return new ArrayList<>(Stream.of(content.split(System.lineSeparator())).toList());
    }

}
