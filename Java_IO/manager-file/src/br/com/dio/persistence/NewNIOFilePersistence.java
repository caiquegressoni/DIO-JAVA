package br.com.dio.persistence;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NewNIOFilePersistence extends FilePersistence {

    public NewNIOFilePersistence(final String fileName) throws IOException {
        super(fileName,"/managerFiles/NewNIO/");
        var path = Paths.get(currentDir + storageDir);
        if (!Files.exists(path)) {
            Files.createDirectory(path);
        }
        clearFile();
    }

    @Override
    public String write(String data) {
        var path = Paths.get(currentDir + storageDir + fileName);
        try(var lines = Files.lines(path)){
            Files.write(path, data.getBytes(), StandardOpenOption.APPEND);
            Files.write(path, System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
        }catch(IOException e){
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public boolean remove(String sentence) {
        var contentList = toListStrings();
        if(contentList.stream().noneMatch(c -> c.contains(sentence))) return false;

        clearFile();
        contentList.stream()
                .filter(c -> !c.contains(sentence))
                .forEach(this::write);
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
        var path = Paths.get(currentDir + storageDir + fileName);
        var content = "";
        try(var lines = Files.lines(path)){
            content = lines.collect(Collectors.joining(System.lineSeparator()));
        }catch(IOException e){
            e.printStackTrace();
        }
        return content;
    }

    @Override
    public String findBy(String sentence) {
        var content = findAll();
        return Stream.of(content.split(System.lineSeparator()))
                .filter(c -> c.contains(sentence))
                .findFirst()
                .orElse("");
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
