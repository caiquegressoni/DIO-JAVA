package br.dio.arch.Singleton;

public class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy() {
        super();
    }

    public static SingletonLazy getInstace(){
        if (instance == null){
            instance = new SingletonLazy();
        }
        return instance;
    }
}
