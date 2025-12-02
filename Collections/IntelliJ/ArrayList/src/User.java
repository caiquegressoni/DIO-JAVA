import java.util.Objects;

public class User {
    private int code;
    private String name;

    public User() {
    }

    public User(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object obj){
        var isEqual = false;
        if(obj instanceof User user){
            if (this == user) return true;
            if (this.code == user.code && Objects.equals(this.name, user.name)) return true;
        }else{
            return false;
        }
        return false;
    }

    @Override
    public String toString(){
        return String.format("{ code : %s, 'name' : %s}", this.code, this.name);
    }
}
