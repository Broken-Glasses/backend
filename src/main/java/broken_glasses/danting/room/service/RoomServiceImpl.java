package broken_glasses.danting.room.service;

import broken_glasses.danting.member.repository.entity.Member;
import broken_glasses.danting.member.repository.entity.MemberRepository;
import broken_glasses.danting.memberroom.repository.entity.Member_Room;
import broken_glasses.danting.memberroom.repository.entity.Member_RoomRepository;
import broken_glasses.danting.room.controller.dto.RoomRequest;
import broken_glasses.danting.room.repository.entity.Room;
import broken_glasses.danting.room.repository.entity.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class RoomServiceImpl implements RoomService {

    private final MemberRepository memberRepository;
    private final RoomRepository roomRepository;
    private final Member_RoomRepository member_roomRepository;

    public String createRoom(RoomRequest roomRequest) {
        Member member = (Member)this.memberRepository.findById(roomRequest.getMember_id()).orElseThrow(() -> {
            return new RuntimeException("멤버 정보가 없습니다.");
        });
        Room room = Room.builder().title(roomRequest.getTitle()).max(roomRequest.getMax()).status("이제 만듦").build();
        this.roomRepository.save(room);
        Member_Room userRoom = Member_Room.builder().member(member).room(room).ready("아직 준비 안됨").build();
        this.member_roomRepository.save(userRoom);
        return "success";
    }

    public List<Room> getRoomList() { return this.roomRepository.findAll();}

    }

