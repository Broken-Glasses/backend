package broken_glasses.danting.users.service;

import broken_glasses.danting.users.controller.dto.JoinRequest;
import broken_glasses.danting.users.repository.entity.Users;

public interface UsersService {
    Users join(JoinRequest joinRequest);
}
