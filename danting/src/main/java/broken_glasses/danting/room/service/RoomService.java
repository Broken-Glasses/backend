package broken_glasses.danting.room.service;

import broken_glasses.danting.room.controller.dto.RoomRequest;
import broken_glasses.danting.room.controller.dto.RoomResponse;
import broken_glasses.danting.room.repository.entity.Room;

import java.util.List;

public interface RoomService {
    String createRoom(RoomRequest roomRequest);

    // 방 리스트를 가져오는 메서드
    List<Room> getRoomList();

    // 방 상세 정보를 가져오는 메서드
    Room getRoomInfo(Long roomId);
}

