package broken_glasses.danting.usersroom.controller.dto;

import lombok.Data;

@Data
public class UnReadyRequest {
    private Long users_id;
    private Long room_id;
}
