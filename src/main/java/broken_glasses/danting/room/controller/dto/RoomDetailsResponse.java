package broken_glasses.danting.room.controller.dto;

import broken_glasses.danting.users.controller.dto.UserInfoResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDetailsResponse {
    private Long room_id;
    private String title;
    private String subTitle;
    private Long maxParticipants;
    private List<UserInfoResponse> maleParticipants;
    private List<UserInfoResponse> femaleParticipants;
    private boolean isReady;
}
