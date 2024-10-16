package broken_glasses.danting.room.controller;

import broken_glasses.danting.member.controller.dto.JoinRequest;
import broken_glasses.danting.room.controller.dto.RoomRequest;
import broken_glasses.danting.room.controller.dto.RoomResponse;
import broken_glasses.danting.room.repository.entity.Room;
import broken_glasses.danting.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable; // PathVariable import

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping("/create")
    public String createRoom(@RequestBody RoomRequest roomRequest) {
        String result = roomService.createRoom(roomRequest);

        if(result.equals("success")){
            return "success";
        }else{
            return "fail";
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Room>> getRoomList() {
        return ResponseEntity.ok(roomService.getRoomList());
    }


    // 채팅방 상세 정보를 가져오는 API
    @GetMapping("/info/{roomId}") // URL 경로에서 roomId를 받아오는 GET 메서드
    public ResponseEntity<Room> getRoomInfo(@PathVariable Long roomId) {
        // roomId를 사용하여 서비스에서 해당 방 정보를 가져오는 메서드 호출
        Room room = roomService.getRoomInfo(roomId);
        // 방 정보를 정상적으로 가져오면 ResponseEntity로 200 OK 상태와 함께 반환
        return ResponseEntity.ok(room);
    }
}
