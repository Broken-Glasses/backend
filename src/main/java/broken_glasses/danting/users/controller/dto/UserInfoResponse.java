package broken_glasses.danting.users.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoResponse {
    private String student_no;
    private String gender;
    private String major;
    private boolean isReady;
    private Long user_id;
}
