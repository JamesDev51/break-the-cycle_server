package brave.btc.repository;


import brave.btc.domain.SmsCertification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Optional;

public interface SmsCertificationRepository extends JpaRepository<SmsCertification, Long> {

    Optional<SmsCertification> findByPhoneNumber(String phoneNum);

    @Modifying
    @Transactional
    @Query("update SmsCertification s set s.certificationNumber = :certificationNumber, s.created = :created" +
            " where s.phoneNumber = :phoneNumber")
    void updateCertificationNum(@Param("certificationNumber") String certificationNumber, @Param("created") Timestamp createdTime,
                                @Param("phoneNumber") String phoneNumber);
}
