package broken_glasses.danting.users.service;

import broken_glasses.danting.users.controller.dto.JoinRequest;
import broken_glasses.danting.users.repository.entity.Users;
import broken_glasses.danting.users.repository.entity.UsersRepository;
import lombok.Generated;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

    public String join(JoinRequest joinRequest) {
        Users users = Users.builder().student_no(joinRequest.getStudent_no()).gender(joinRequest.getGender()).major(joinRequest.getMajor()).build();
        this.usersRepository.save(users);
        return "success";
    }

    @Generated
    public UsersServiceImpl(final UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
}
