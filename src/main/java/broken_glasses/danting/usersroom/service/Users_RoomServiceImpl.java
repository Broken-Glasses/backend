package broken_glasses.danting.usersroom.service;

import broken_glasses.danting.users.repository.entity.Users;
import broken_glasses.danting.users.repository.entity.UsersRepository;
import broken_glasses.danting.usersroom.controller.dto.ReadyRequest;
import broken_glasses.danting.usersroom.controller.dto.UnReadyRequest;
import broken_glasses.danting.usersroom.repository.entity.Users_Room;
import broken_glasses.danting.usersroom.repository.entity.Users_RoomRepository;
import broken_glasses.danting.room.repository.entity.Room;
import broken_glasses.danting.room.repository.entity.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Users_RoomServiceImpl implements Users_RoomService {
    private final Users_RoomRepository users_roomRepository;
    private final RoomRepository roomRepository;
    private final UsersRepository usersRepository;

    @Override
    public boolean ready(ReadyRequest request) {
        Users users = usersRepository.findById(request.getUsers_id())
                .orElseThrow(() -> new RuntimeException("멤버 정보가 없습니다."));
        Room room = roomRepository.findById(request.getRoom_id())
                .orElseThrow(() -> new RuntimeException("방의 정보가 없습니다."));

        Users_Room users_room = users_roomRepository.findByUsersAndRoom(users, room);

        if (users_room == null) throw new RuntimeException("멤버와 방의 정보가 없습니다.");

        boolean newState = true;
        users_room.setReady(newState);
        users_roomRepository.save(users_room);
        return newState;
    }

    public boolean unReady(UnReadyRequest request) {
        Users users = usersRepository.findById(request.getUsers_id())
                .orElseThrow(() -> new RuntimeException("멤버 정보가 없습니다."));
        Room room = roomRepository.findById(request.getRoom_id())
                .orElseThrow(() -> new RuntimeException("방의 정보가 없습니다."));

        Users_Room users_room = users_roomRepository.findByUsersAndRoom(users, room);

        if (users_room == null) throw new RuntimeException("멤버와 방의 정보가 없습니다.");

        boolean newState = false;
        users_room.setReady(newState);
        users_roomRepository.save(users_room);
        return newState;
    }

    @Override
    public Long enter(ReadyRequest request) {
        Users users = usersRepository.findById(request.getUsers_id())
                .orElseThrow(() -> new RuntimeException("멤버 정보가 없습니다."));
        Room room = roomRepository.findById(request.getRoom_id())
                .orElseThrow(() -> new RuntimeException("방의 정보가 없습니다."));

        // 1. 이미 참여한 사용자인지 확인
        boolean isAlreadyJoined = users_roomRepository.existsByUsersAndRoom(users, room);
        if (isAlreadyJoined) {
            throw new RuntimeException("이미 참여한 방입니다.");
        }
        // 2. 전체 인원 확인
        if (room.getMaleParticipants() + room.getFemaleParticipants() >= room.getMaxParticipants()) {
            throw new RuntimeException("방 인원이 초과되었습니다.");
        }

        // 3. 성별에 따른 인원 제한 확인
        if(users.getGender().equals("male")) {
            if (room.getMaleParticipants() >= room.getMaxParticipants() / 2) {  // 남성 인원이 꽉 찼는지 확인
                throw new RuntimeException("남성 인원이 가득 찼습니다.");
            }
            room.incrementMaleParticipants();
        } else {
            if (room.getFemaleParticipants() >= room.getMaxParticipants() / 2) {  // 여성 인원이 꽉 찼는지 확인
                throw new RuntimeException("여성 인원이 가득 찼습니다.");
            }
            room.incrementFemaleParticipants();
        }


        Users_Room users_room = Users_Room.builder()
                .users(users)
                .room(room)
                .isReady(false)
                .build();

        users_roomRepository.save(users_room);
        return room.getRoom_id();
    }
}