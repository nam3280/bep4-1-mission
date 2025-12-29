package com.back.shared.cash.dto;


import com.back.boundedContext.cash.domain.Wallet;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor(
        // 불변 DTO를 사용하기 위해 역직렬화 설정 부분
        onConstructor_ = @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
)
@Getter
public class WalletDto {
    private final int id;
    private final LocalDateTime createDate;
    private final LocalDateTime modifyDate;
    private final int holderId;
    private final String holderName;
    private final long balance;

    public WalletDto(Wallet wallet) {
        this(
                wallet.getId(),
                wallet.getCreateDate(),
                wallet.getModifyDate(),
                wallet.getHolder().getId(),
                wallet.getHolder().getUsername(),
                wallet.getBalance()
        );
    }
}