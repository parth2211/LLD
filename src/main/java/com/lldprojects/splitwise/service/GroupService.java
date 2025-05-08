package com.lldprojects.splitwise.service;

import com.lldprojects.splitwise.models.Group;
import com.lldprojects.splitwise.models.User;
import com.lldprojects.splitwise.repository.GroupRepository;
import com.lldprojects.splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    UserRepository userRepository;

    public Group addGroup(Long createdById, String groupName) {
        Optional<User> optionalUser = userRepository.findById(createdById);
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();

            Group group = new Group();
            group.setName(groupName);
            group.setCreatedBy(user);
            List<User> participants = group.getGroupParticipants();
            participants.add(user);
            group.setGroupParticipants(participants);
            List<User> admins = group.getAdmins();
            admins.add(user);
            group.setAdmins(admins);

            return groupRepository.save(group);
        }
        System.out.println("User is not registered in system!");
        return null;
    }
}
