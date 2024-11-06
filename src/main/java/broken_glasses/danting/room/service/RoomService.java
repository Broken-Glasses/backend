package broken_glasses.danting.room.service;

import broken_glasses.danting.room.controller.dto.RoomDetailsResponse;
import broken_glasses.danting.room.controller.dto.RoomRequest;
import broken_glasses.danting.room.controller.dto.RoomResponse;

import java.util.List;

public interface RoomService {
    RoomResponse createRoom(RoomRequest roomRequest);

    List<RoomResponse> getRoomList();

    RoomDetailsResponse getRoomInfo(Long roomId);
}
