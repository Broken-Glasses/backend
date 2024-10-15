package broken_glasses.danting.member.controller;

import broken_glasses.danting.member.controller.dto.JoinRequest;
import broken_glasses.danting.member.service.MemberService;
import lombok.Generated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    private final MemberService memberService;

    @PostMapping({"/join"})
    public String join(@RequestBody JoinRequest joinRequest) {
        String result = this.memberService.join(joinRequest);
        return result.equals("success") ? "success" : "fail";
    }

    @Generated
    public MemberController(final MemberService memberService) {
        this.memberService = memberService;
    }
}
