package broken_glasses.danting.usersroom.controller;

import broken_glasses.danting.usersroom.controller.dto.ReadyRequest;
import broken_glasses.danting.usersroom.service.Users_RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsersroomController {
    private final Users_RoomService users_room_Service;

    @PostMapping({"/ready"})
    public ResponseEntity<?> ready(@RequestBody ReadyRequest request) {
        try {
            String ready = users_room_Service.ready(request);
            return ResponseEntity.ok().body(ready);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping({"/enter"}) // 채팅방 참가
    public ResponseEntity<?> enter(@RequestBody ReadyRequest request) {
        try{
            String enter = users_room_Service.enter(request);
            return ResponseEntity.ok().body(enter);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    }

