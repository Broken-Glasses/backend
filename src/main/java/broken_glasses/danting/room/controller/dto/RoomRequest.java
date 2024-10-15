package broken_glasses.danting.room.controller.dto;

import lombok.Data;

@Data
public class RoomRequest {
    private Long member_id;
    private String title;
    private Long max;
    private String status;
}
