package broken_glasses.danting.member.service;

import broken_glasses.danting.member.controller.dto.JoinRequest;
import broken_glasses.danting.member.repository.entity.Member;
import broken_glasses.danting.member.repository.entity.MemberRepository;
import lombok.Generated;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public String join(JoinRequest joinRequest) {
        Member member = Member.builder().student_no(joinRequest.getStudent_no()).gender(joinRequest.getGender()).major(joinRequest.getMajor()).build();
        this.memberRepository.save(member);
        return "success";
    }

    @Generated
    public MemberServiceImpl(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
}
