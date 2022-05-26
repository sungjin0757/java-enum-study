package item37;

public enum PhaseV1 {
    SOLID, LIQUID, GAS;

    public enum Transition{
        MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

        private static final Transition[][] transitions={
                {null, MELT, SUBLIME},
                {FREEZE, null, BOIL},
                {DEPOSIT, CONDENSE, null}
        };

        // 컴파일러는 배열 인덱스와 ordinal()의 관계를 알 수 없다.
        // Phase나 Transition이 수정이 일어날 때 같이 수정해주지 않으면 오류가 날 수도 있고, 데이터는 제곱수로 늘어나게 된다.
        // EnumMap을 쓰도록 하자.
        public static Transition from(PhaseV1 from, PhaseV1 to){
            return transitions[from.ordinal()][to.ordinal()];
        }
    }
}
