package broken_glasses.danting.users.repository.entity;

import broken_glasses.danting.usersroom.repository.entity.Users_Room;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Generated;

@Entity
public class Users {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long users_id;
    private String student_no;
    private String gender;
    private String major;
    @JsonManagedReference
    @OneToMany(
            mappedBy = "users"
    )
    private List<Users_Room> userRooms;

    @Generated
    public static UsersBuilder builder() {
        return new UsersBuilder();
    }

    @Generated
    public Users() {
    }

    @Generated
    private Users(final Long member_id, final String student_no, final String gender, final String major, final List<Users_Room> userRooms) {
        this.users_id = member_id;
        this.student_no = student_no;
        this.gender = gender;
        this.major = major;
        this.userRooms = userRooms;
    }

    @Generated
    public Long getMember_id() {
        return this.users_id;
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
    public List<Users_Room> getUserRooms() {
        return this.userRooms;
    }

    @Generated
    public static class UsersBuilder {
        @Generated
        private Long users_id;
        @Generated
        private String student_no;
        @Generated
        private String gender;
        @Generated
        private String major;
        @Generated
        private List<Users_Room> userRooms;

        @Generated
        UsersBuilder() {
        }

        @Generated
        public UsersBuilder member_id(final Long member_id) {
            this.users_id = member_id;
            return this;
        }

        @Generated
        public UsersBuilder student_no(final String student_no) {
            this.student_no = student_no;
            return this;
        }

        @Generated
        public UsersBuilder gender(final String gender) {
            this.gender = gender;
            return this;
        }

        @Generated
        public UsersBuilder major(final String major) {
            this.major = major;
            return this;
        }

        @Generated
        public UsersBuilder userRooms(final List<Users_Room> userRooms) {
            this.userRooms = userRooms;
            return this;
        }

        @Generated
        public Users build() {
            return new Users(this.users_id, this.student_no, this.gender, this.major, this.userRooms);
        }

        @Generated
        public String toString() {
            return "Member.MemberBuilder(member_id=" + this.users_id + ", student_no=" + this.student_no + ", gender=" + this.gender + ", major=" + this.major + ", userRooms=" + this.userRooms + ")";
        }
    }
}
