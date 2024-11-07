package broken_glasses.danting.usersroom.repository.entity;

import broken_glasses.danting.users.repository.entity.Users;
import broken_glasses.danting.room.repository.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Users_RoomRepository extends JpaRepository<Users_Room, Long> {
    Users_Room findByUsersAndRoom(Users users, Room room);
    List<Users_Room> findByRoom(Room room);
}
