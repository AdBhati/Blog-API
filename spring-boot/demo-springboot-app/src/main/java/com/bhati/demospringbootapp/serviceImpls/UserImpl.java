package com.bhati.demospringbootapp.serviceImpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhati.demospringbootapp.models.Project;
import com.bhati.demospringbootapp.models.State;
import com.bhati.demospringbootapp.models.User;
import com.bhati.demospringbootapp.repositories.ProjectRespository;
import com.bhati.demospringbootapp.repositories.RoleRespository;
import com.bhati.demospringbootapp.repositories.StateRespository;
import com.bhati.demospringbootapp.repositories.UserRespository;
import com.bhati.demospringbootapp.services.UserService;

@Service
public class UserImpl implements UserService {

    private final UserRespository userRespository;
    private RoleRespository roleRespository;
    private ProjectRespository projectRespository;
    private StateRespository stateRespository;

    @Autowired
    public UserImpl(UserRespository userRespository, RoleRespository roleRespository,
            ProjectRespository projectRespository, StateRespository stateRespository) {
        this.userRespository = userRespository;
        this.roleRespository = roleRespository;
        this.projectRespository = projectRespository;
        this.stateRespository = stateRespository;
    }

    @Override
    public User createUser(User user) throws Exception {
        User existedUser = userRespository.findByEmail(user.getEmail());
        if (existedUser != null) {
            throw new Exception("User Already Exists");
        }
        if (user.getExperience() >= 3 && user.getExperience() <= 5) {
            user.setRole(roleRespository.findById(3).orElse(null));
            // user.setProject(roleRespository.findById(3).orElse(null));
            return userRespository.save(user);
        } else if (user.getExperience() == 1) {
            user.setRole(roleRespository.findById(1).orElse(null));
            // user.setProject(roleRespository.findById(1).orElse(null));
            return userRespository.save(user);
        } else if (user.getExperience() > 5) {
            user.setRole(roleRespository.findById(4).orElse(null));
            // user.setProject(roleRespository.findById(4).orElse(null));
            return userRespository.save(user);
        }
        user.setRole(roleRespository.findById(2).orElse(null));

        return userRespository.save(user);

    }

    @Override
    public List<User> findAllUsers() {
        return userRespository.findAll();
    }

    @Override
    public User getUserById(Integer uid) throws Exception {
        User usr = userRespository.findById(uid).orElse(null);
        if (uid == null) {
            throw new Exception("Record not Found");
        }

        System.out.println("@@@@@@===>>>" + usr.getEmail());

        return usr;
    }

    @Override
    public State updatedata(Integer id, User user) throws Exception {
        User updUser = userRespository.findById(id).orElse(null);
        if (updUser == null) {
            throw new Exception();
        }

        if (user.getName() != null) {
            updUser.setName(user.getName());
        }

        Project project = projectRespository.findByName("Blockchain_Project");
        updUser.getProjects().add(project);

        State state = stateRespository.findByName("Rajasthan");
        state.getUsers().add(updUser);
        stateRespository.save(state);

        userRespository.save(updUser);
        return state;

    }

    @Override
    public void deleteuser(Integer id, User user) throws Exception {
        User delUser = userRespository.findById(id).orElse(null);
        userRespository.delete(delUser);

    }

}
