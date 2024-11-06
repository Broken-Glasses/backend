package broken_glasses.danting.room.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@AllArgsConstructor
public class RoomResponse {
    private Long room_id;
    private String title;
    private String subTitle;
    private Long maxParticipants;
    private Long maleParticipants;
    private Long femaleParticipants;
    private boolean isReady;
}
