package br.com.dio.calc;

import java.util.stream.LongStream;

public enum Operation {
    SUM(n -> LongStream.of(n).reduce(0, Long::sum)),
    SUBTRACTION(n ->LongStream.of(n).reduce(0, (n1, n2) -> n1 - n2));

    private final Calc operationCallBack;

    Operation(final Calc operationCallBack) {
        this.operationCallBack = operationCallBack;
    }

    public Calc getOperationCallBack() {
        return operationCallBack;
    }
}
//TODO: Implementar MULTIPLICAÇÃO e DIVISÃO