package org.medservice.repository;

import org.springframework.stereotype.Repository;

@Repository("sequenceRepository")
public interface SequenceRepository {

    public Long getNextSequenceId(String key);
}
