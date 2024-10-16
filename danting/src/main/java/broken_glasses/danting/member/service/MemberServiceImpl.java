package broken_glasses.danting.member.service;

import broken_glasses.danting.member.controller.dto.JoinRequest;
import broken_glasses.danting.member.repository.entity.Member;
import broken_glasses.danting.member.repository.entity.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public String join(JoinRequest joinRequest) {
        Member member = Member.builder()
                .user_id(joinRequest.getUser_id())
                .student_no(joinRequest.getStudent_no())
                .gender(joinRequest.getGender())
                .major(joinRequest.getMajor())
                .nickname(joinRequest.getNickname())
                .build();
        memberRepository.save(member);
        return "success";
    }
}
