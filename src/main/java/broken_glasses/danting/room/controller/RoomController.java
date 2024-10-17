package broken_glasses.danting.room.controller;

import broken_glasses.danting.room.controller.dto.RoomRequest;
import broken_glasses.danting.room.repository.entity.Room;
import broken_glasses.danting.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor


@RestController
public class RoomController {
    private final RoomService roomService;

    @PostMapping({"/create"})
    public String createRoom(@RequestBody RoomRequest roomRequest) {
        String result = this.roomService.createRoom(roomRequest);
        return result.equals("success") ? "success" : "fail";
    }

    @GetMapping({"/all/list"})
    public ResponseEntity<List<Room>> getRoomList() {
        return ResponseEntity.ok(this.roomService.getRoomList());
    }
}

