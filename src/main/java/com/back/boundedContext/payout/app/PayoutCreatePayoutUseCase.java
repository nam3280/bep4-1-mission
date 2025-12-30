package com.back.boundedContext.payout.app;

import com.back.boundedContext.payout.domain.Payout;
import com.back.boundedContext.payout.domain.PayoutMember;
import com.back.boundedContext.payout.out.PayoutMemberRepository;
import com.back.boundedContext.payout.out.PayoutRepository;
import com.back.shared.payout.dto.PayoutMemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PayoutCreatePayoutUseCase {
    private final PayoutMemberRepository payoutMemberRepository;
    private final PayoutRepository payoutRepository;

    //PayoutMember가 생성되는 이벤트가 발행이 될 때 payout을 만든다.
    public Payout createPayout(PayoutMemberDto payee) {
        PayoutMember _payee = payoutMemberRepository.getReferenceById(payee.getId());
        return payoutRepository.save(new Payout(_payee));
    }
}
