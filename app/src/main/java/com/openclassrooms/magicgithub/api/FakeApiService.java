package com.openclassrooms.magicgithub.api;

import com.openclassrooms.magicgithub.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.openclassrooms.magicgithub.api.FakeApiServiceGenerator.generateUsers;

public class FakeApiService implements ApiService {

    private List<User> users = generateUsers();
    private List<User> randomUsers = generateRandomUsers();

    /**
     * Return a list of {@link User}
     * Those users must be generated by {@link FakeApiServiceGenerator}
     */
    @Override
    public List<User> getUsers() {
        // TODO: A modifier
        return users;
    }

    /**
     * Generate a random {@link User} and add it {@link FakeApiService#users} list.
     * This user must be get from the {@link FakeApiServiceGenerator#FAKE_USERS_RANDOM} list.
     */
    @Override
    public void generateRandomUser() {
        // TODO: A modifier
        Random rand = new Random();

        if(!(randomUsers.size() == 0)){
            int randomIndex = rand.nextInt(randomUsers.size());
            users.add(randomUsers.get(randomIndex));
            randomUsers.remove(randomIndex);
        }
    }

    static List<User> generateRandomUsers() {
        return new ArrayList<>(FakeApiServiceGenerator.FAKE_USERS_RANDOM);
    }

    /**
     * Delete a {@link User} from the {@link FakeApiService#users} list.
     */
    @Override
    public void deleteUser(User user) {
        // TODO: A modifier
        users.remove(user);
    }
}
