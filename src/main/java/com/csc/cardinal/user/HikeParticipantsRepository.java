package com.csc.cardinal.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HikeParticipantsRepository extends JpaRepository<HikeParticipantsEntity, Long> {

   //HikeParticipantsEntity save(HikeParticipantsEntity participant);


}
