package com.back.boundedContext.payout.out;

import com.back.boundedContext.payout.domain.Payout;
import com.back.boundedContext.payout.domain.PayoutMember;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PayoutRepository extends JpaRepository<Payout, Integer> {
    Optional<Payout> findByPayeeAndPayoutDateIsNull(PayoutMember payee);

    // 지급일이 없고, 금액이 0원 초과인 정산 대상 Payout 조회
    List<Payout> findByPayoutDateIsNullAndAmountGreaterThanOrderByIdAsc(long amount, Pageable pageable);
}