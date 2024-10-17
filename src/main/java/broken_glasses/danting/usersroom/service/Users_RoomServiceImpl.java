package broken_glasses.danting.usersroom.service;

import broken_glasses.danting.users.repository.entity.Users;
import broken_glasses.danting.users.repository.entity.UsersRepository;
import broken_glasses.danting.usersroom.controller.dto.ReadyRequest;
import broken_glasses.danting.usersroom.repository.entity.Users_Room;
import broken_glasses.danting.usersroom.repository.entity.Users_RoomRepository;
import broken_glasses.danting.room.repository.entity.Room;
import broken_glasses.danting.room.repository.entity.RoomRepository;
import lombok.Generated;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public class Users_RoomServiceImpl implements Users_RoomService {
    private final Users_RoomRepository users_roomRepository;
    private final RoomRepository roomRepository;
    private final UsersRepository usersRepository;

    public String ready(ReadyRequest request) {
        Users users = usersRepository.findById(request.getUsers_id()).orElseThrow(() -> {
            return new RuntimeException("멤버 정보가 없습니다.");
        });
        Room room = roomRepository.findById(request.getRoom_id()).orElseThrow(() -> {
            return new RuntimeException("방의 정보가 없습니다.");
        });

        Users_Room users_room = users_roomRepository.findByUsersAndRoom(users, room);

        if (users_room == null) throw new RuntimeException("멤버와 방의 정보가 없습니다.");

        users_room.setReady("준비 완료");

        this.users_roomRepository.save(users_room);
        return "success";
    }

    @Override
    public String enter(ReadyRequest request) {
        Users users = usersRepository.findById(request.getUsers_id()).orElseThrow(() -> {
            return new RuntimeException("멤버 정보가 없습니다.");
        });
        Room room = roomRepository.findById(request.getRoom_id()).orElseThrow(()-> {
            return new RuntimeException("방의 정보가 없습니다.");
        });

        Users_Room users_room = Users_Room.builder()
                .users(users)
                .room(room)
                .ready("아직 준비 안됨")
                .build();

        this.users_roomRepository.save(users_room);
        return "success";
    }

    @Generated
    public Users_RoomServiceImpl(final Users_RoomRepository users_roomRepository, final RoomRepository roomRepository, final UsersRepository usersRepository) {
        this.users_roomRepository = users_roomRepository;
        this.roomRepository = roomRepository;
        this.usersRepository = usersRepository;
    }
}
