package broken_glasses.danting.memberroom.repository.entity;

import broken_glasses.danting.member.repository.entity.Member;
import broken_glasses.danting.room.repository.entity.Room;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Member_Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_room_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false, unique = true)
    private Room room;

    private String ready;


}
