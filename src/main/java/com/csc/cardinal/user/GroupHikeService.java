package com.csc.cardinal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GroupHikeService {

    @Autowired
    GroupHikeRepository groupHikeRepository;

    /**
     * Add a record to the groupHike table
     *
     * @param groupHike
     * @return GroupHikeEntity
     */
    public GroupHikeEntity save(GroupHikeEntity groupHike) {
        return groupHikeRepository.save(groupHike);
    }

    @Autowired
    public GroupHikeService(GroupHikeRepository groupHikeRepository) {
        this.groupHikeRepository = groupHikeRepository;
    }

    public void createHike(GroupHikeEntity groupHike) {
        groupHikeRepository.save(groupHike);
    }



    /**
     * Get all records from groupHike table
     *
     * @return List<UserEntity>
     */
    public List<GroupHikeEntity> fetch() {
        return (List<GroupHikeEntity>) groupHikeRepository.findAll();
    }



}
