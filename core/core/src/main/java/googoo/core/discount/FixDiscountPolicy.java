package googoo.core.discount;

import googoo.core.member.Grade;
import googoo.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixedAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixedAmount;
        } else {
            return 0;
        }
    }
}
