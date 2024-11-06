package broken_glasses.danting.room.repository.entity;

import broken_glasses.danting.usersroom.repository.entity.Users_Room;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long room_id;

    private String title;

    private Long maxParticipants;

    private boolean isReady;

    private Long femaleParticipants= 0L;
    private Long maleParticipants= 0L;

    private String subTitle;

    @OneToMany(mappedBy = "room")
    private List<Users_Room> userRooms;

    public void incrementFemaleParticipants() {
        femaleParticipants++;
    }
    public void incrementMaleParticipants() {
        maleParticipants++;
    }
}
