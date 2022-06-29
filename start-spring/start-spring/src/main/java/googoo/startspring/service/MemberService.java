package googoo.startspring.service;

import googoo.startspring.domain.Member;
import googoo.startspring.repository.MemberRepository;
import googoo.startspring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 변수 및 클래스 최초 위치 따라가기 단축키: ctrl b


    // 회원가입
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원 안됨
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    // extract method 단축기: ctrl alt m
    // 중복 회원 검증 함수
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 회원 조회
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }


}
