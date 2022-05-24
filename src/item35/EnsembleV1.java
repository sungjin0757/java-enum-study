package item35;

public enum EnsembleV1 {
    SOLO, DUET, TRIO, QUARTET, QUINTET,
    SEXTET, SEPTET, OCTET, NONET, DECTET;

    /**
     * 유지보수 최악
     * 순서가 바뀌는 순간 바로 오동작 가능 + 똑같은 의미의 같은 상수를 가진 값을 정확히 파악 불가.
     * ordinal은 절대 사용하지 말 것
     */
    public int numberOfMusicals(){
        return ordinal()+1;
    }
}
