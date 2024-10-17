package broken_glasses.danting.room.service;

import broken_glasses.danting.users.repository.entity.Users;
import broken_glasses.danting.users.repository.entity.UsersRepository;
import broken_glasses.danting.usersroom.repository.entity.Users_Room;
import broken_glasses.danting.usersroom.repository.entity.Users_RoomRepository;
import broken_glasses.danting.room.controller.dto.RoomRequest;
import broken_glasses.danting.room.repository.entity.Room;
import broken_glasses.danting.room.repository.entity.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class RoomServiceImpl implements RoomService {

    private final UsersRepository usersRepository;
    private final RoomRepository roomRepository;
    private final Users_RoomRepository users_roomRepository;

    public String createRoom(RoomRequest roomRequest) {
        Users users = (Users)this.usersRepository.findById(roomRequest.getUsers_id()).orElseThrow(() -> {
            return new RuntimeException("멤버 정보가 없습니다.");
        });
        Room room = Room.builder().title(roomRequest.getTitle()).max(roomRequest.getMax()).status("이제 만듦").build();
        this.roomRepository.save(room);
        Users_Room userRoom = Users_Room.builder().users(users).room(room).ready("아직 준비 안됨").build();
        this.users_roomRepository.save(userRoom);
        return "success";
    }

    public List<Room> getRoomList() { return this.roomRepository.findAll();}

    }

