package broken_glasses.danting.room.controller;

import broken_glasses.danting.BaseResponse;
import broken_glasses.danting.room.controller.dto.RoomDetailsResponse;
import broken_glasses.danting.room.controller.dto.RoomRequest;
import broken_glasses.danting.room.controller.dto.RoomResponse;
import broken_glasses.danting.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RoomController {
    private static final Logger log = LoggerFactory.getLogger(RoomController.class);
    private final RoomService roomService;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse<?>> createRoom(@RequestBody RoomRequest roomRequest) {
        try {
            RoomResponse response = roomService.createRoom(roomRequest);
            return ResponseEntity.ok(new BaseResponse<>(true, response));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(new BaseResponse<>(false, e.getMessage()));
        }
    }

    @GetMapping("/all/list")
    public ResponseEntity<BaseResponse<?>> getRoomList() {
        try {
            List<RoomResponse> rooms = roomService.getRoomList();
            return ResponseEntity.ok(new BaseResponse<>(true, rooms));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(new BaseResponse<>(false, e.getMessage()));
        }
    }

    @GetMapping("/info/{roomId}")
    public ResponseEntity<BaseResponse<?>> info(@PathVariable Long roomId) {
        try {
            RoomDetailsResponse room = roomService.getRoomInfo(roomId);
            return ResponseEntity.ok(new BaseResponse<>(true, room));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(new BaseResponse<>(false, e.getMessage()));
        }
    }
}
