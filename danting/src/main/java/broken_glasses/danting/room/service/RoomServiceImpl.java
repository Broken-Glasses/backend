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

    @Override
    public String createRoom(RoomRequest roomRequest) {
        // 1. 멤버가 있는지 확인
        Member member = memberRepository.findById(roomRequest.getMember_id()).orElseThrow(() -> new RuntimeException("멤버 정보가 없습니다."));


        // 2. 방을 만들자
        Room room = Room.builder()
                .title(roomRequest.getTitle())
                .max(roomRequest.getMax())
                .status("이제 만듦")
                .build();

        roomRepository.save(room);

        // 3. 방을 만든 회원과 방금 생성된 방 정보를 매핑 테이블에 삽입
        Member_Room userRoom = Member_Room.builder()
                .member(member)
                .room(room)
                .ready("아직 준비 안됨")
                .build();

        // 4. 매핑 정보를 매핑 테이블에 저장
        member_roomRepository.save(userRoom);

        return "success";
    }

    @Override
    public List<Room> getRoomList() {
        // 모든 방의 정보를 가져와서 리스트로 반환
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomInfo(Long roomId) {
        // roomId로 해당 방 정보를 가져옴
        return roomRepository.findById(roomId)
                // 방이 없으면 예외 발생
                .orElseThrow(() -> new RuntimeException("방 정보가 없습니다."));
    }
}
