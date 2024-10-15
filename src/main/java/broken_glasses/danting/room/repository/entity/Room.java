package broken_glasses.danting.room.repository.entity;

import broken_glasses.danting.memberroom.repository.entity.Member_Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long room_id;

    private String title;

    private Long max;

    private String status;

    // User_Room과의 1:N 관계 설정
    @OneToMany(mappedBy = "room")
    private List<Member_Room> userRooms;
}
