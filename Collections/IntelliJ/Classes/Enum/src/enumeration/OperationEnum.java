package enumeration;

import java.util.function.BiFunction;

public enum OperationEnum {
    SUM(Integer::sum, "+"),
    SUBSTRACTION((Integer v1, Integer v2) -> v1 - v2, "-" ),
    MULTIPLAY((Integer v1, Integer v2) -> v1 * v2, "*"),
    DIVISION((Integer v1, Integer v2) -> v1 / v2, "/");

    private final BiFunction<Integer, Integer, Integer> calculate;
    private final String synbol;
    OperationEnum(BiFunction<Integer, Integer, Integer> calculate, String synbol) {
        this.calculate = calculate;
        this.synbol = synbol;
    }

    public BiFunction<Integer, Integer, Integer> getCalculate() {
        return calculate;
    }

    public String getSynbol() {
        return synbol;
    }
}
