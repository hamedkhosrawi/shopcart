package org.acme.entity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.Instant;

public class AuditingEntityListener {
<<<<<<< HEAD

    @PrePersist
    void preCreate(AbstractEntity auditable){

        Instant now = Instant.now();
        auditable.setCreatedDate(now);
        auditable.setLastModifiedDate(now);

    }

=======
    @PrePersist
    void preCreate(AbstractEntity auditable){
        Instant now = Instant.now();
        auditable.setCreateDate(now);
        auditable.setLastModifiedDate(now);
    }
>>>>>>> 4a507626c6b1199483a45b19f2457dadbd61a2db
    @PreUpdate
    void preUpdate(AbstractEntity auditable){
        Instant now = Instant.now();
        auditable.setLastModifiedDate(now);
    }
}
