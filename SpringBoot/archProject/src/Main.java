import br.dio.arch.Facade.Facade;
import br.dio.arch.Singleton.SingletonEager;
import br.dio.arch.Singleton.SingletonLazy;
import br.dio.arch.Singleton.SingletonLazyHolder;
import br.dio.arch.Strategy.*;

public class Main {
    public static void main(String[] args) {
        /*
        Singleton:

        SingletonLazy lazy = SingletonLazy.getInstace();
        System.out.println("Lazy "+lazy);
        lazy = SingletonLazy.getInstace();
        System.out.println("Lazy segundo println "+lazy);
        System.out.println("/----------------------------/");
        SingletonEager eager = SingletonEager.getInstance();
        System.out.println("Eager "+eager);
        eager = SingletonEager.getInstance();
        System.out.println("Eager segundo println "+eager);
        System.out.println("/----------------------------/");
        SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstance();
        System.out.println("Lazy Holder "+lazyHolder);
        lazyHolder = SingletonLazyHolder.getInstance();
        System.out.println("Lazy Holder segundo println "+lazyHolder);
         */

        /*
        Strategy:

        Comportamento normal = new ComportamentoNormal();
        Comportamento def = new ComportamentoDefensivo();
        Comportamento agr = new ComportamentoAgressivo();

        Robo robo = new Robo();
        //Mover normalmente
        robo.setStrategy(normal);
        robo.mover();

        //Mover Def
        robo.setStrategy(def);
        robo.mover();

        //Mover Agr
        robo.setStrategy(agr);
        robo.mover();
        */

        Facade facade = new Facade();

        facade.migrarClient("Zé", "1490000");

    }
}