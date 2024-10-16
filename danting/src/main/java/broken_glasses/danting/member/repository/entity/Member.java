package broken_glasses.danting.member.repository.entity;


import broken_glasses.danting.memberroom.repository.entity.Member_Room;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String student_no;

    private String gender;

    private String major;

    private String nickname;

    // User_Room과의 1:N 관계 설정
    @OneToMany(mappedBy = "member") // User_Room 엔티티에서 가지는 멤버클래스 변수
    @JsonIgnore // 이 필드를 JSON 직렬화에서 제외
    private List<Member_Room> userRooms;
}
