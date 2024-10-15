package broken_glasses.danting.memberroom.service;

import broken_glasses.danting.memberroom.controller.dto.ReadyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


public interface Member_RoomService {
    String ready(ReadyRequest request);
}
