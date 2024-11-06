package broken_glasses.danting.room.controller.dto;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class RoomRequest {
    private Long users_id;
    private String title;
    private Long maxParticipants;
    private String subTitle;

}
