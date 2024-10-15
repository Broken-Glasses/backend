package broken_glasses.danting.room.service;

import broken_glasses.danting.room.controller.dto.RoomRequest;
import broken_glasses.danting.room.controller.dto.RoomResponse;
import broken_glasses.danting.room.repository.entity.Room;

import java.util.List;

public interface RoomService {
    String createRoom(RoomRequest roomRequest);

    List<Room> getRoomList();
}
