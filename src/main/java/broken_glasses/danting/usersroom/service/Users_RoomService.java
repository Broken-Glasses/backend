package broken_glasses.danting.usersroom.service;

import broken_glasses.danting.usersroom.controller.dto.ReadyRequest;


public interface Users_RoomService {
    String ready(ReadyRequest request);

    String enter(ReadyRequest request);
}
