package broken_glasses.danting.users.controller;

import broken_glasses.danting.users.controller.dto.JoinRequest;
import broken_glasses.danting.users.service.UsersService;
import lombok.Generated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
    private final UsersService usersService;

    @PostMapping({"/join"})
    public String join(@RequestBody JoinRequest joinRequest) {
        String result = this.usersService.join(joinRequest);
        return result.equals("success") ? "success" : "fail";
    }

    @Generated
    public UsersController(final UsersService usersService) {
        this.usersService = usersService;
    }
}
