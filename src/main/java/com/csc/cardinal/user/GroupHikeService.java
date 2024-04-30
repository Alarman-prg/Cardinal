package com.csc.cardinal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
     * @return List<GroupHikeEntity>
     */
    public List<GroupHikeEntity> fetch() {
        return (List<GroupHikeEntity>) groupHikeRepository.findAll();
    }

    /**
     * Find a hike by its ID
     *
     * @param hikeId The ID of the hike to find
     * @return The found hike, or null if not found
     */
    public GroupHikeEntity findHikeById(Long hikeId) {
        Optional<GroupHikeEntity> hikeOptional = groupHikeRepository.findById(hikeId);
        return hikeOptional.orElse(null); // Return the found hike or null if not found
    }


    public void joinHike(int hikeId, UserEntity user) {
        // Retrieve the hike from the database
        GroupHikeEntity hike = groupHikeRepository.findById((long) hikeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid hike ID: " + hikeId));

        // Add the user to the participants of the hike
        hike.addParticipant(user);

        // Save the updated hike back to the database
        groupHikeRepository.save(hike);
    }
}
