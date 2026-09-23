package br.dio.arch.Singleton;

public class SingletonLazyHolder {

    private static class Holder {
        public static SingletonLazyHolder instance = new SingletonLazyHolder();
    }
    private SingletonLazyHolder() {
        super();
    }

    public static SingletonLazyHolder getInstance() {
        return Holder.instance;
    }
}
