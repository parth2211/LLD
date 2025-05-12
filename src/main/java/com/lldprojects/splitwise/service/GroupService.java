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

    public Group addGroupMember(Long groupAdminId, Long groupId, Long userId) {
        List<User> userList = userRepository.findAllById(List.of(groupAdminId, userId));
        Optional<Group> optionalGroup = groupRepository.findById(groupId);
        if(userList.size() == 2 && optionalGroup.isPresent()) {
            boolean isAdmin = optionalGroup.get().getAdmins()
                    .stream()
                    .anyMatch(admin -> admin.getId() == groupAdminId);

            if(!isAdmin) {
                System.out.println("Admin permission required to add user in group!");
                return null;
            }

            Group group = optionalGroup.get();
            if(userList.get(0).getId() == userId) {
                User user = userList.get(0);
                List<User> participants = group.getGroupParticipants();
                participants.add(user);
                group.setGroupParticipants(participants);
            } else {
                User user = userList.get(1);
                List<User> participants = group.getGroupParticipants();
                participants.add(user);
                group.setGroupParticipants(participants);
            }

            return groupRepository.save(group);
        }
        System.out.println("Either Users are not registered in system! or Group is not registered in system!");
        return null;
    }
}
