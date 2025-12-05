import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        var value = "java;java;java;java";
        value = value.replaceFirst("j", "J");
        System.out.println(value.indexOf("a", 1, 2));
        var values = value.split(";");
        for(var v : values){
            System.out.println(v);
        }

        var valueJ = """
                {
                    "name": "Jão",
                    "age": 18
                }
                """;
        Map<String, String> map = new HashMap<>();
        valueJ = valueJ.replace("{","").replace("}","").replace("\"","");
        var valueArr = valueJ.split(",");
        for(var v : valueArr){
            var keyValue = v.split(":");
            map.put(keyValue[0], keyValue[1]);
        }
        System.out.println(map);
    }
}
