package broken_glasses.danting.memberroom.repository.entity;

import broken_glasses.danting.member.repository.entity.Member;
import broken_glasses.danting.room.repository.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Member_RoomRepository extends JpaRepository <Member_Room, Long>{

    Member_Room findByMemberAndRoom(Member member, Room room);
}
