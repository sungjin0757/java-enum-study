package item34;

/**
 * 깨지기 쉬운 코드
 * 동작이 추가되면 분기문을 하나씩 더 추가 해야 하고,
 * 혹시라도 깜빡하면 컴파일은 되더라도 연산 수행시 예외 발생.
 */
public enum OperationV1 {
    PLUS, MINUS, TIMES, DIVIDE;

    public double apply(double x, double y){
        switch (this){
            case PLUS: return x+y;
            case MINUS: return x-y;
            case TIMES: return x*y;
            case DIVIDE: return x/y;
        }
        throw new AssertionError("알 수 없는 연산: "+this);
    }
}
