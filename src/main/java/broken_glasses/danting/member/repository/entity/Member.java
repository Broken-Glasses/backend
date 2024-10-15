package broken_glasses.danting.member.repository.entity;

import broken_glasses.danting.memberroom.repository.entity.Member_Room;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Generated;

@Entity
public class Member {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long member_id;
    private String student_no;
    private String gender;
    private String major;
    @JsonManagedReference
    @OneToMany(
            mappedBy = "member"
    )
    private List<Member_Room> userRooms;

    @Generated
    public static MemberBuilder builder() {
        return new MemberBuilder();
    }

    @Generated
    public Member() {
    }

    @Generated
    private Member(final Long member_id, final String student_no, final String gender, final String major, final List<Member_Room> userRooms) {
        this.member_id = member_id;
        this.student_no = student_no;
        this.gender = gender;
        this.major = major;
        this.userRooms = userRooms;
    }

    @Generated
    public Long getMember_id() {
        return this.member_id;
    }

    @Generated
    public String getStudent_no() {
        return this.student_no;
    }

    @Generated
    public String getGender() {
        return this.gender;
    }

    @Generated
    public String getMajor() {
        return this.major;
    }

    @Generated
    public List<Member_Room> getUserRooms() {
        return this.userRooms;
    }

    @Generated
    public static class MemberBuilder {
        @Generated
        private Long member_id;
        @Generated
        private String student_no;
        @Generated
        private String gender;
        @Generated
        private String major;
        @Generated
        private List<Member_Room> userRooms;

        @Generated
        MemberBuilder() {
        }

        @Generated
        public MemberBuilder member_id(final Long member_id) {
            this.member_id = member_id;
            return this;
        }

        @Generated
        public MemberBuilder student_no(final String student_no) {
            this.student_no = student_no;
            return this;
        }

        @Generated
        public MemberBuilder gender(final String gender) {
            this.gender = gender;
            return this;
        }

        @Generated
        public MemberBuilder major(final String major) {
            this.major = major;
            return this;
        }

        @Generated
        public MemberBuilder userRooms(final List<Member_Room> userRooms) {
            this.userRooms = userRooms;
            return this;
        }

        @Generated
        public Member build() {
            return new Member(this.member_id, this.student_no, this.gender, this.major, this.userRooms);
        }

        @Generated
        public String toString() {
            return "Member.MemberBuilder(member_id=" + this.member_id + ", student_no=" + this.student_no + ", gender=" + this.gender + ", major=" + this.major + ", userRooms=" + this.userRooms + ")";
        }
    }
}
