package broken_glasses.danting.users.service;

import broken_glasses.danting.users.controller.dto.JoinRequest;

public interface UsersService {
    String join(JoinRequest joinRequest);
}
