package com.keirnellyer.glencaldy.manipulation.property.type;

import com.keirnellyer.glencaldy.exception.InputException;
import com.keirnellyer.glencaldy.exception.UserException;
import com.keirnellyer.glencaldy.repository.UserRepository;
import com.keirnellyer.glencaldy.user.User;

public class UserProperty<T extends User> extends BasicProperty<T> {
    private final UserRepository repository;
    private final Class<T> userClass;

    public UserProperty(String askMsg, UserRepository repository, Class<T> userClass) {
        super(askMsg);
        this.repository = repository;
        this.userClass = userClass;
    }

    public UserProperty(String askMsg, boolean editable, UserRepository repository, Class<T> userClass) {
        super(askMsg, editable);
        this.repository = repository;
        this.userClass = userClass;
    }

    @Override
    protected T parse(String input) throws InputException {
        User user = repository.get(input);

        if (user == null) {
            throw new UserException("User not found.");
        }

        if (!userClass.isAssignableFrom(user.getClass())) {
            throw new UserException("User is not of type: " + userClass.getSimpleName());
        }

        return (T) user;
    }
}
