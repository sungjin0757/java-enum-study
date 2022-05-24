package item35;

public enum EnsembleV2 {
    SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5),
    SEXTET(6), SEPTET(7), OCTET(8), NONET(9), DECTET(10);

    private final int numberOfMusicals;
    EnsembleV2(int numberOfMusicals) {
        this.numberOfMusicals = numberOfMusicals;
    }
    public int numberOfMusicals(){
        return numberOfMusicals;
    }
}
