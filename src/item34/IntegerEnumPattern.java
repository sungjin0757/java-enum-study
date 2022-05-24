package item34;

public class IntegerEnumPattern {
    /**
     * 상당히 취약한 방법.
     * 평범한 상수일 뿐이라 컴파일 하면 그 값이 클라이언트 파일에 그대로 새겨진다.
     * 따라서, 상수의 값이 바뀌면 클라이언트도 반드시 다시 컴파일 해야한다.
     * 디버거로 살펴보면, 단지 숫자로만 표현되기 때문에 의미 파악이 어려울 수 있다.
     */
    public static final int APPLE_FUJI=0;
    public static final int APPLE_PIPPIN=1;
    public static final int APPLE_GRANNY_SMITH=2;

    public static final int ORANGE_NAVEL=0;
    public static final int ORANGE_TEMPLE=0;
    public static final int ORANGE_BLOOD=0;
}

// enum type을 쓰는 것을 권장. 완전한 형태의 클래스라서 다른 언어의 열거 타입 보다 훨씬 강력.

/**
 * 열거 타입 자체는 클래스
 * 상수 하나당 자신의 인스턴스를 하나씩 만들어 public static final 필드로 공개.
 * 밖에서 접근할 수 있는 생성자를 제공하지 않으므로 사실상 final
 * 따라서 클라이언트가 인스턴스를 직접 생성하거나 확장할 수 없으니 열거 타입 선언으로 만들어진 인스턴스들은 딱 하나만 제공이 보장
 * 싱글턴은 원소가 하나뿐인 열거 타입이라 할 수 있고, 거꾸로 열거 타입은 싱글턴을 일반화한 형태라고 볼 수 있다.
 */
enum Apple{FUJI, PIPPIN, GRANNY_SMITH}
enum Orange{NAVEL, TEMPLE, BLOOD}
