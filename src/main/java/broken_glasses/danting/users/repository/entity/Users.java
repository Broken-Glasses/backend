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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long users_id;
    private String student_no;
    private String gender;
    private String major;
    private String nickName;

    @JsonManagedReference
    @OneToMany(mappedBy = "users")
    private List<Users_Room> usersRooms;

    @Generated
    public static UsersBuilder builder() {
        return new UsersBuilder();
    }

    @Generated
    public Users() {}

    @Generated
    private Users(Long users_id, String student_no, String gender, String major, List<Users_Room> userRooms, String nickName) {
        this.users_id = users_id;
        this.student_no = student_no;
        this.gender = gender;
        this.major = major;
        this.usersRooms = userRooms;
        this.nickName = nickName;
    }

    @Generated
    public Long getUsers_id() {
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
    public String getNickName() {
        return this.nickName;
    }

    @Generated
    public List<Users_Room> getUserRooms() {
        return this.usersRooms;
    }



    @Generated
    public static class UsersBuilder {
        private Long users_id;
        private String student_no;
        private String gender;
        private String major;
        private String nickName;
        private List<Users_Room> userRooms;

        UsersBuilder() {}

        public UsersBuilder users_id(Long users_id) {
            this.users_id = users_id;
            return this;
        }

        public UsersBuilder student_no(String student_no) {
            this.student_no = student_no;
            return this;
        }

        public UsersBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public UsersBuilder major(String major) {
            this.major = major;
            return this;
        }

        public UsersBuilder nickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        public UsersBuilder userRooms(List<Users_Room> userRooms) {
            this.userRooms = userRooms;
            return this;
        }


        public Users build() {
            return new Users(this.users_id, this.student_no, this.gender, this.major, this.userRooms, this.nickName);
        }
    }
}
