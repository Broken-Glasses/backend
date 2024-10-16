package broken_glasses.danting.room.controller.dto;

import lombok.Data;

@Data
public class RoomResponse {
    private Long room_id;
    private String title;
    private Long max;
    private String status;
}
