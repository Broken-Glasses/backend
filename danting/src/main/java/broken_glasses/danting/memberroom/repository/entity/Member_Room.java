package broken_glasses.danting.memberroom.repository.entity;

import broken_glasses.danting.member.repository.entity.Member;
import broken_glasses.danting.room.repository.entity.Room;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Member_Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_room_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    private String ready;


}
