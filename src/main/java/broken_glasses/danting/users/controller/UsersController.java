package broken_glasses.danting.users.controller;

import broken_glasses.danting.BaseResponse;
import broken_glasses.danting.users.controller.dto.JoinRequest;
import broken_glasses.danting.users.repository.entity.Users;
import broken_glasses.danting.users.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @PostMapping("/join")
    public ResponseEntity<BaseResponse<Users>> join(@RequestBody JoinRequest joinRequest) {
        Users newUser = usersService.join(joinRequest);
        return ResponseEntity.ok(new BaseResponse<>(true, newUser));
    }
}
