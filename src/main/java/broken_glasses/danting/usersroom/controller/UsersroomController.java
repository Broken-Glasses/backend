package broken_glasses.danting.usersroom.controller;

import broken_glasses.danting.BaseResponse;
import broken_glasses.danting.usersroom.controller.dto.ReadyRequest;
import broken_glasses.danting.usersroom.controller.dto.UnReadyRequest;
import broken_glasses.danting.usersroom.controller.dto.response.EnterResponse;
import broken_glasses.danting.usersroom.service.Users_RoomService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UsersroomController {
    private static final Logger log = LoggerFactory.getLogger(UsersroomController.class);
    private final Users_RoomService users_room_Service;

    @PostMapping("/ready")
    public ResponseEntity<BaseResponse<?>> ready(@RequestBody ReadyRequest request) {
        try {
            boolean newState = users_room_Service.ready(request);
            return ResponseEntity.ok(new BaseResponse<>(true, newState));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(new BaseResponse<>(false, e.getMessage()));
        }
    }
    @PostMapping("/unready")
    public ResponseEntity<BaseResponse<?>> ready(@RequestBody UnReadyRequest request) {
        try {
            boolean newState = users_room_Service.unReady(request);
            return ResponseEntity.ok(new BaseResponse<>(true, newState));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(new BaseResponse<>(false, e.getMessage()));
        }
    }

    // BaseResponse 안의 제네릭 타입 T가 불분명 할 때는 ? 로 써주면 됨,
    // 아니면 ? 대신에 EnterResponse 넣으면 명시적으로 코드 작성 가능
    @PostMapping("/enter")
    public ResponseEntity<BaseResponse<?>> enter(@RequestBody ReadyRequest request) {
        try {
            // room_id 가져오기
            Long room_id = users_room_Service.enter(request);

            // enterResponse 객체로 만들어서 baseResponse 안에 result 부분에 넣기
            EnterResponse enterResponse = new EnterResponse(); // 빈 EnterResponse 인스턴스 생성
            enterResponse.setRoom_id(room_id); // {"room_id": 1}

            return ResponseEntity.ok(new BaseResponse<>(true, enterResponse));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(new BaseResponse<>(false, e.getMessage()));
        }
    }

}
