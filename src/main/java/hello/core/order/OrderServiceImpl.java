package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
// RequiredArgsConstructor final 붙은 것의 생성자를 자동으로 만들어줌
// @RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // 생성자 주입 방식으로 final을 붙일 수 있음
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // 타입 매칭이 2개 이상일 때
    // 1. Autowired로 중복 이름으로 에러가 나면 파라미터를 이름으로 수정 해서 피할 수 있다. discountPolicy -> fixDiscountPolicy
    // 2. Quilifier 추가 구분자를 붙여주는 방법 discountPolicy -> @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy
    // 3. Primary 우선순위를 지정한다.
    @Autowired
    public OrderServiceImpl( MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
