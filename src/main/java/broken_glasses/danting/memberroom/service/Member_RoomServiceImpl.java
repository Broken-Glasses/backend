package broken_glasses.danting.memberroom.service;

import broken_glasses.danting.member.repository.entity.Member;
import broken_glasses.danting.member.repository.entity.MemberRepository;
import broken_glasses.danting.memberroom.controller.dto.ReadyRequest;
import broken_glasses.danting.memberroom.repository.entity.Member_Room;
import broken_glasses.danting.memberroom.repository.entity.Member_RoomRepository;
import broken_glasses.danting.room.repository.entity.Room;
import broken_glasses.danting.room.repository.entity.RoomRepository;
import lombok.Generated;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public class Member_RoomServiceImpl implements Member_RoomService {
    private final Member_RoomRepository member_roomRepository;
    private final RoomRepository roomRepository;
    private final MemberRepository memberRepository;

    public String ready(ReadyRequest request) {
        Member member = (Member)this.memberRepository.findById(request.getMember_id()).orElseThrow(() -> {
            return new RuntimeException("멤버 정보가 없습니다.");
        });
        Room room = (Room)this.roomRepository.findById(request.getRoom_id()).orElseThrow(() -> {
            return new RuntimeException("방의 정보가 없습니다.");
        });

        Member_Room member_room = member_roomRepository.findByMemberAndRoom(member, room);

        if (member_room == null) throw new RuntimeException("멤버와 방의 정보가 없습니다.");

        member_room.setReady("준비 완료");

        this.member_roomRepository.save(member_room);
        return "success";
    }

    @Generated
    public Member_RoomServiceImpl(final Member_RoomRepository member_roomRepository, final RoomRepository roomRepository, final MemberRepository memberRepository) {
        this.member_roomRepository = member_roomRepository;
        this.roomRepository = roomRepository;
        this.memberRepository = memberRepository;
    }
}
