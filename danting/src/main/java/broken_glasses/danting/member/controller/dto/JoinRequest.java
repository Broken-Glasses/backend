package broken_glasses.danting.member.controller.dto;

import lombok.Data;

@Data
public class JoinRequest {

    private Long user_id;

    private String student_no;

    private String gender;

    private String major;

    private String nickname;

}
