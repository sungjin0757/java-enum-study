package item34;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum OperationV3 {
    PLUS("+"){
        public double apply(double x, double y){return x+y;}
    },
    MINUS("-"){
        public double apply(double x, double y){return x-y;}
    },
    TIMES("*"){
        public double apply(double x, double y){return x*y;}
    },
    DIVIDE("/"){
        public double apply(double x, double y){return x/y;}
    };

    private final String symbol;

    OperationV3(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public abstract double apply(double x, double y);

    private static final Map<String, OperationV3> stringToEnum = Arrays.stream(values()).collect(Collectors.toMap(
            e->e.toString(),e->e
    ));

    public static Optional<OperationV3> fromString(String symbol){
        return Optional.ofNullable(stringToEnum.get(symbol));
    }
}

class OperationV3Main{
    public static void main(String[] args){
        double x=15;
        double y=15;
        for(OperationV3 op : OperationV3.values()){
            System.out.printf("%f %s %f = %f%n",x,op,y,op.apply(x,y));
        }
        System.out.println(OperationV3.fromString("+").get().apply(x,y));
    }
}

