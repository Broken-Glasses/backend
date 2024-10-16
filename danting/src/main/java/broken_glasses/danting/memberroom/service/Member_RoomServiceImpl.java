package broken_glasses.danting.memberroom.service;

import broken_glasses.danting.member.repository.entity.Member;
import broken_glasses.danting.member.repository.entity.MemberRepository;
import broken_glasses.danting.memberroom.controller.dto.ReadyRequest;
import broken_glasses.danting.memberroom.repository.entity.Member_Room;
import broken_glasses.danting.memberroom.repository.entity.Member_RoomRepository;
import broken_glasses.danting.room.repository.entity.Room;
import broken_glasses.danting.room.repository.entity.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Repository
public class Member_RoomServiceImpl implements Member_RoomService{

    private final Member_RoomRepository member_roomRepository;
    private final RoomRepository roomRepository;
    private final MemberRepository memberRepository;

    @Override
    public String ready(ReadyRequest  request) {

        // 유저 객체를 id 값으로 찾아서 가져오기
        Member member = memberRepository.findById(request.getUser_id()).orElseThrow(()-> new RuntimeException("멤버 정보가 없습니다."));

        // 룸 객체를 id 값으로 찾아서 가져오기
        Room room = roomRepository.findById(request.getRoom_id()).orElseThrow(()-> new RuntimeException("방의 정보가 없습니다."));

        // 유저 방 객체를 유저 객체, 룸 객체를 사용해서 만들기
        Member_Room member_room = Member_Room.builder()
                .member(member)
                .room(room)
                .build();


        //userId 랑 roomId 값으로 Member_Room 테이블에서 데이터를 찾아와야함
        // 찾아서 그 객체의 ready 상태값 변경 후 다시 저장 해야함

        //Member_Room newMember_room = member_roomRepository.findBy();


        member_roomRepository.save(member_room);

        // 저장
        return "success";

        // 유저-방 매핑 정보 확인


        // 확인된 객체에 값 넣기



    }
}
