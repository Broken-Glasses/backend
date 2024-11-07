package broken_glasses.danting.users.controller.dto;

import lombok.Data;

@Data
public class JoinRequest {
    private String student_no;
    private String gender;
    private String major;
    private String nickName;
}
