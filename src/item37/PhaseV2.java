package item37;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum PhaseV2 {
    SOLID, LIQUID, GAS;

    public enum Transition{
        MELT(SOLID,LIQUID), FREEZE(LIQUID,SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);

        private final PhaseV2 from;
        private final PhaseV2 to;

        Transition(PhaseV2 from, PhaseV2 to) {
            this.from = from;
            this.to = to;
        }

        private static final Map<PhaseV2,Map<PhaseV2,Transition>>
            m = Stream.of(values()).collect(Collectors.groupingBy(t->t.from,
                ()-> new EnumMap<>(PhaseV2.class),Collectors.toMap(t->t.to,t->t, (x,y) -> y, () ->
                        new EnumMap<>(PhaseV2.class))));

        public static Transition from(PhaseV2 from, PhaseV2 to){
            return m.get(from).get(to);
        }
    }
}
