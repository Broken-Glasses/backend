package broken_glasses.danting.memberroom.controller;

import broken_glasses.danting.memberroom.controller.dto.ReadyRequest;
import broken_glasses.danting.memberroom.service.Member_RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberroomController {
    private final Member_RoomService member_room_service;

    @PostMapping({"/ready"})
    public void ready(@RequestBody ReadyRequest request) {
        this.member_room_service.ready(request);
    }

    }

