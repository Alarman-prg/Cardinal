package com.csc.cardinal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HikeParticipantsService {

    private static HikeParticipantsRepository hikeParticipantsRepository;

    @Autowired
    public HikeParticipantsService(HikeParticipantsRepository hikeParticipantsRepository) {
        this.hikeParticipantsRepository = hikeParticipantsRepository;
    }

    public HikeParticipantsEntity joinHike(GroupHikeEntity hike, UserEntity user) {
        HikeParticipantsEntity participant = new HikeParticipantsEntity();
        participant.setHike(hike);
        participant.setUser(user);
        return hikeParticipantsRepository.save(participant);
    }
}
