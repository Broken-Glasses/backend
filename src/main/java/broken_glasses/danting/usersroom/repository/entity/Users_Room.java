package broken_glasses.danting.usersroom.repository.entity;

import broken_glasses.danting.users.repository.entity.Users;
import broken_glasses.danting.room.repository.entity.Room;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Users_Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long users_room_id;

    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private Users users;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    private boolean isReady;
}
