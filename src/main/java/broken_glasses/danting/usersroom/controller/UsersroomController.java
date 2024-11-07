package broken_glasses.danting.usersroom.controller;

import broken_glasses.danting.BaseResponse;
import broken_glasses.danting.room.controller.dto.RoomDetailsResponse;
import broken_glasses.danting.usersroom.controller.dto.ReadyRequest;
import broken_glasses.danting.usersroom.controller.dto.UnReadyRequest;
import broken_glasses.danting.usersroom.service.Users_RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UsersroomController {
    private final Users_RoomService users_room_Service;

    @PostMapping("/ready")
    public ResponseEntity<BaseResponse<Boolean>> ready(@RequestBody ReadyRequest request) {
        try {
            boolean newState = users_room_Service.ready(request);
            return ResponseEntity.ok(new BaseResponse<>(true, newState));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse<>(false, false));
        }
    }
    @PostMapping("/unready")
    public ResponseEntity<BaseResponse<Boolean>> ready(@RequestBody UnReadyRequest request) {
        try {
            boolean newState = users_room_Service.unReady(request);
            return ResponseEntity.ok(new BaseResponse<>(true, newState));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse<>(false, false));
        }
    }

    @PostMapping("/enter")
    public ResponseEntity<BaseResponse<Long>> enter(@RequestBody ReadyRequest request) {
        try {
            Long roomId = users_room_Service.enter(request);
            return ResponseEntity.ok(new BaseResponse<>(true, roomId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse<>(false, null));
        }
    }


}
