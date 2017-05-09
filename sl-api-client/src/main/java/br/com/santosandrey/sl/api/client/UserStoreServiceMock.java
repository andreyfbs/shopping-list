package br.com.santosandrey.sl.api.client;

import org.springframework.stereotype.Service;

/**
 * User Store Mock
 */
@Service
public class UserStoreServiceMock implements UserStoreService {

    @Override
    public Long retrieveUserId(String token) {
        return 1L;
    }

    @Override
    public boolean isUserLogged(Long id, String token) {
        return true;
    }

    @Override
    public String getUserDetails(Long userId) {
        return null;
    }
}