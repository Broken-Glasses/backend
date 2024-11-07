package broken_glasses.danting.room.controller;

import broken_glasses.danting.BaseResponse;
import broken_glasses.danting.room.controller.dto.RoomDetailsResponse;
import broken_glasses.danting.room.controller.dto.RoomRequest;
import broken_glasses.danting.room.controller.dto.RoomResponse;
import broken_glasses.danting.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RoomController {
    private final RoomService roomService;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse<RoomResponse>> createRoom(@RequestBody RoomRequest roomRequest) {
        RoomResponse response = roomService.createRoom(roomRequest);
        return ResponseEntity.ok(new BaseResponse<>(true, response));
    }

    @GetMapping("/all/list")
    public ResponseEntity<BaseResponse<List<RoomResponse>>> getRoomList() {
        List<RoomResponse> rooms = roomService.getRoomList();
        return ResponseEntity.ok(new BaseResponse<>(true, rooms));
    }

    @GetMapping("/info/{roomId}")
    public ResponseEntity<BaseResponse<RoomDetailsResponse>> info(@PathVariable Long roomId) {
        try {
            RoomDetailsResponse room = roomService.getRoomInfo(roomId);
            return ResponseEntity.ok(new BaseResponse<>(true, room));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse<>(false, null));
        }
    }
}
