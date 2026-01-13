import dao.GenericDAO;
import dao.UserDAO;
import domain.UserDomain;

public class Main {

    private final static GenericDAO<Integer, UserDomain> dao = new UserDAO();

    public static void main(String[] args) {
        var user = new UserDomain(1, "Jose", 32);

        System.out.println(dao.save(user));
        System.out.println(dao.save(new UserDomain(2, "Joao", 22)));
        System.out.println(dao.save(new UserDomain(3, "Maria", 33)));
        System.out.println(dao.saveBatch(1, user));
        System.out.println(dao.findAll());
        System.out.println(dao.find(d ->d.getId().equals(1)));
        System.out.println(dao.find(d ->d.getId().equals(4)));
        System.out.println(dao.count());
        System.out.println(dao.delete(new UserDomain(4, "Joao", 22)));
        System.out.println(dao.delete(user));
        System.out.println(dao.count());
    }
}
