package br.com.dio.persistence;

public abstract class FilePersistence {

    protected final String currentDir = System.getProperty("user.dir"); //Retorna o diretorio atual.
    protected final String storageDir; //Salvar os arquivos manipulados.
    protected final String fileName;

    protected FilePersistence(final String fileName, final String storageDir) {
        this.storageDir = storageDir;
        this.fileName = fileName;
    }

    public abstract String write(final String data);

    public abstract boolean remove(final String sentence);

    public abstract String replace(final String oldContent, final String newContent);

    public abstract String findAll();
    public abstract String findBy(final String sentence);
}
