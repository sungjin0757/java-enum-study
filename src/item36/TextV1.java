package item36;

/**
 * 비트 필드를 사용하면, 비트별 연산을 사용해 합집합과 교집합 같은 집합 연산을 효율적으로 수행할 수 있다.
 * 하지만, 구닥다리 방법이다.
 * Enum을 적용하지 않았을 때와 똑같은 문제를 갖고 있다.
 * 또한, 비트를 그대로 출력하게 되면 정수 상수보다도 훨씬 해석하기 어려워 진다.
 * 최대 몇 비트가 필요한지도 사전에 작성해야한다.
 */
public class TextV1 {
    public static final int STYLE_BOLD = 1<<0;
    public static final int STYLE_ITALIC = 1<<1;
    public static final int STYLE_UNDERLINE = 1<<2;
    public static final int STYLE_STRIKETHROUGH = 1<<3;

    public void applyStyles(int styles){

    }
}
