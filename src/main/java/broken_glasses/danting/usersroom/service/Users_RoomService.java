package broken_glasses.danting.usersroom.service;

import broken_glasses.danting.usersroom.controller.dto.ReadyRequest;
import broken_glasses.danting.usersroom.controller.dto.UnReadyRequest;

public interface Users_RoomService {
    boolean ready(ReadyRequest request);
    Long enter(ReadyRequest request);
    boolean unReady(UnReadyRequest request);
}
