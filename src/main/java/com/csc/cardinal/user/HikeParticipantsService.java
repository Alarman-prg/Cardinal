package com.csc.cardinal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HikeParticipantsService {

    @Autowired
    private HikeParticipantsRepository HikeParticipantsRepository;

    public HikeParticipantsEntity joinHike(GroupHikeEntity hike, UserEntity user) {
        HikeParticipantsEntity participant = new HikeParticipantsEntity();
        participant.setHike(hike);
        participant.setUser(user);
        return HikeParticipantsRepository.save(participant);
    }
}
