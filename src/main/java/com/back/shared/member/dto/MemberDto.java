package com.back.shared.member.dto;

import com.back.boundedContext.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class MemberDto {
    private final int id;
    private final String username;
    private final String password;
    private final String nickname;
    private final int activityScore;
    private final LocalDateTime createDate;
    private final LocalDateTime modifyDate;

    public MemberDto(Member member) {
        this(
                member.getId(),
                member.getUsername(),
                member.getPassword(),
                member.getNickname(),
                member.getActivityScore(),
                member.getCreateDate(),
                member.getModifyDate()
        );
    }
}
