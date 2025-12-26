package com.back.boundedContext.cash.app;

import com.back.boundedContext.cash.domain.CashMember;
import com.back.boundedContext.cash.domain.Wallet;
import com.back.boundedContext.cash.out.CashMemberRepository;
import com.back.boundedContext.cash.out.WalletRepository;
import com.back.shared.cash.dto.CashMemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashCreateWalletUseCase {
    private final CashMemberRepository cashMemberRepository;
    private final WalletRepository walletRepository;

    public Wallet createWallet(CashMemberDto member) {
        // getReferenceById를 사용하면 불필요한 SELECT를 방지할 수 있다.
        // 참조할 때만 사용
        CashMember cashMember = cashMemberRepository.getReferenceById(member.getId());
        Wallet wallet = new Wallet(cashMember);

        return walletRepository.save(wallet);
    }
}