package item37;

import java.util.*;
import java.util.stream.Collectors;

public class Plant {
    enum LifeCycle { ANNUAL, PERENNIAL, BIENNIAL}

    final String name;
    final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }
}

class PlantMain{
    public static void main(String[] args){
        /**
         * 배열은 제네릭과 호환되지 않으니 비검사 형변환을 수행해야함.
         * 배열은 각 인덱스의 의미를 모르니 출력 결과에 직접 레이블을 달아야 함.
         * 사용하는 정수값을 클라이언트 쪽에서 직접 보증해야 함.
         */
        Set<Plant>[] plantByLifeCycle = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
        for(int i=0; i < plantByLifeCycle.length; i++){
            plantByLifeCycle[i]=new HashSet<>();
        }

        List<Plant> garden=new ArrayList<>();
        for(Plant p : garden){
            plantByLifeCycle[p.lifeCycle.ordinal()].add(p);
        }

        /**
         * EnumMap 사용
         * 배열 인덱스를 계산하는 과정에서 오류날 확률을 원천 봉쇄함.
         */
        Map<Plant.LifeCycle,Set<Plant>> plants = new EnumMap<>(Plant.LifeCycle.class);
        for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            plants.put(lc,new HashSet<>());
        }

        for(Plant p : garden){
            plants.get(p.lifeCycle).add(p);
        }

        // stream 기반.
        EnumMap<Plant.LifeCycle, Set<Plant>> collect = garden.stream().collect(Collectors.groupingBy(p -> p.lifeCycle,
                () -> new EnumMap<>(Plant.LifeCycle.class), Collectors.toSet()));
    }
}
