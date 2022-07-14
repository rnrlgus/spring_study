package googoo.core;

import googoo.core.discount.FixDiscountPolicy;
import googoo.core.member.MemberService;
import googoo.core.member.MemberServiceImpl;
import googoo.core.member.MemoryMemberRepository;
import googoo.core.order.OrderService;
import googoo.core.order.OrderServiceImpl;

// 나의 어플리케이션 전체를 설정 및 구상하는 클래스
// 배우는 연기에만 집중하도록. 기획자 역할을 함
public class AppConfig {

    // 생성자 주입
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
