package broken_glasses.danting.member.controller;

import broken_glasses.danting.member.controller.dto.JoinRequest;
import broken_glasses.danting.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/join")
    public String join(@RequestBody JoinRequest joinRequest) {

        String result = memberService.join(joinRequest);

        if(result.equals("success")){
            return "success";
        }else{
            return "fail";
        }
    }

}