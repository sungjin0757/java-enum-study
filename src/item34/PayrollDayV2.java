package item34;

import static item34.PayrollDayV2.PayType.WEEKDAY;
import static item34.PayrollDayV2.PayType.WEEKEND;

public enum PayrollDayV2 {
    MONDAY(WEEKDAY), TUESDAY(WEEKDAY), WEDNESDAY(WEEKDAY), THURSDAY(WEEKDAY), FRIDAY(WEEKDAY),
    SATURDAY(WEEKEND), SUNDAY(WEEKEND);

    private final PayType payType;

    PayrollDayV2(PayType payType) {
        this.payType = payType;
    }

    int pay(int minutesWorked, int payRate){
        return payType.pay(minutesWorked,payRate);
    }

    enum PayType{
        WEEKDAY{
            @Override
            int overtimePay(int minsWorked,int payRate){
                return minsWorked <= MINS_PER_SHIFT ? 0 : (minsWorked - MINS_PER_SHIFT) * payRate/2;
            }
        },
        WEEKEND{
            @Override
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked * payRate /2;
            }
        };

        abstract int overtimePay(int minsWorked,int payRate);
        private static final int MINS_PER_SHIFT = 8*60;

        int pay(int minsWorked,int payRate){
            int basePay=minsWorked*payRate;
            return basePay + overtimePay(minsWorked,payRate);
        }
    }
}
