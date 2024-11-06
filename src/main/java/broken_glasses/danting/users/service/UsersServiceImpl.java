package broken_glasses.danting.users.service;

import broken_glasses.danting.users.controller.dto.JoinRequest;
import broken_glasses.danting.users.repository.entity.Users;
import broken_glasses.danting.users.repository.entity.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

    @Override
    public Users join(JoinRequest joinRequest) {
        Users newUser = Users.builder()
                .student_no(joinRequest.getStudent_no())
                .gender(joinRequest.getGender())
                .major(joinRequest.getMajor())
                .nickName(joinRequest.getNickName())
                .build();
        return usersRepository.save(newUser); // 저장 후 생성된 사용자 객체 반환
    }
}
