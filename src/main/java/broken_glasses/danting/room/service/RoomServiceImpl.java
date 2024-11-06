package broken_glasses.danting.room.service;

import broken_glasses.danting.room.controller.dto.RoomDetailsResponse;
import broken_glasses.danting.users.controller.dto.UserInfoResponse;
import broken_glasses.danting.users.repository.entity.Users;
import broken_glasses.danting.users.repository.entity.UsersRepository;
import broken_glasses.danting.usersroom.repository.entity.Users_Room;
import broken_glasses.danting.usersroom.repository.entity.Users_RoomRepository;
import broken_glasses.danting.room.controller.dto.RoomRequest;
import broken_glasses.danting.room.controller.dto.RoomResponse;
import broken_glasses.danting.room.repository.entity.Room;
import broken_glasses.danting.room.repository.entity.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RoomServiceImpl implements RoomService {

    private final UsersRepository usersRepository;
    private final RoomRepository roomRepository;
    private final Users_RoomRepository users_roomRepository;

    @Override
    public RoomResponse createRoom(RoomRequest roomRequest) {
        Users users = usersRepository.findById(roomRequest.getUsers_id())
                .orElseThrow(() -> new RuntimeException("멤버 정보가 없습니다."));

        Room room = Room.builder()
                .title(roomRequest.getTitle())
                .subTitle(roomRequest.getSubTitle())
                .maxParticipants(roomRequest.getMaxParticipants())
                .maleParticipants((long) (users.getGender().equals("male")?1:0))
                .femaleParticipants((long) (users.getGender().equals("female")?1:0))
                .isReady(false)
                .build();
        roomRepository.save(room);

        Users_Room userRoom = Users_Room.builder()
                .users(users)
                .room(room)
                .isReady(false)
                .build();
        users_roomRepository.save(userRoom);

        return new RoomResponse(room.getRoom_id(), room.getTitle(), room.getSubTitle(),room.getMaxParticipants(),room.getMaleParticipants(),room.getFemaleParticipants(),room.isReady());
    }

    @Override
    public List<RoomResponse> getRoomList() {
        List<Room> rooms = roomRepository.findAll();
        return rooms.stream().map(room -> {
            long maleCount = room.getUserRooms().stream()
                    .filter(ur -> "male".equals(ur.getUsers().getGender()))
                    .count();
            long femaleCount = room.getUserRooms().stream()
                    .filter(ur -> "female".equals(ur.getUsers().getGender()))
                    .count();
            boolean isReady = room.getUserRooms().stream()
                    .allMatch(ur -> false);
            return new RoomResponse(room.getRoom_id(), room.getTitle(), room.getSubTitle(),room.getMaxParticipants(),
                    room.getMaleParticipants(),room.getFemaleParticipants(),room.isReady());
        }).collect(Collectors.toList());
    }

    @Override
    public RoomDetailsResponse getRoomInfo(Long roomId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("방 정보가 없습니다."));

        List<Users> users = getUsers(users_roomRepository.findByRoom(room));
        List<UserInfoResponse> maleParticipants = getUserInfo(users, "male", room);
        List<UserInfoResponse> femaleParticipants = getUserInfo(users, "female", room);

        return new RoomDetailsResponse(
                room.getRoom_id(),
                room.getTitle(),
                room.getSubTitle(),
                room.getMaxParticipants(),
                maleParticipants,
                femaleParticipants,
                room.isReady()
        );
    }

    private List<Users> getUsers(List<Users_Room> usersRooms) {
        return usersRooms.stream().map(Users_Room::getUsers).toList();
    }

    private List<UserInfoResponse> getUserInfo(List<Users> users, String gender, Room room) {
        return users.stream()
                .filter(currUser -> currUser.getGender().equals(gender))
                .map(currUser -> {
                    Users_Room users_room = users_roomRepository.findByUsersAndRoom(currUser, room);

                    return new UserInfoResponse(
                            currUser.getStudent_no(),
                            currUser.getGender(),
                            currUser.getMajor(),
                            users_room.isReady(),
                            currUser.getUsers_id(),
                            currUser.getNickName()
                    );
                }).toList();
    }
}
