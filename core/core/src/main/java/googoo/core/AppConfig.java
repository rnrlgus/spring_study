package googoo.core;

import googoo.core.discount.DiscountPolicy;
import googoo.core.discount.FixDiscountPolicy;
import googoo.core.discount.RateDiscountPolicy;
import googoo.core.member.MemberService;
import googoo.core.member.MemberServiceImpl;
import googoo.core.member.MemoryMemberRepository;
import googoo.core.order.OrderService;
import googoo.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 나의 어플리케이션 전체를 설정 및 구상하는 클래스
// 배우는 연기에만 집중하도록. 기획자 역할을 함
@Configuration
public class AppConfig {

    // 생성자 주입
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy() );
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
