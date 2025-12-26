package com.back.global.initData;

import com.back.boundedContext.member.app.MemberFacade;
import com.back.boundedContext.member.domain.Member;
import com.back.global.rsData.RsData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@Slf4j
public class MemberDataInit {
    private final MemberDataInit self;
    private final MemberFacade memberFacade;

    public MemberDataInit(@Lazy MemberDataInit self, MemberFacade memberFacade) {
        this.self = self;
        this.memberFacade = memberFacade;
    }

    @Bean
    @Order(1)
    public ApplicationRunner baseMemberInitDataRunner() {
        return args -> {
            self.makeBaseMembers();
        };
    }

    @Transactional
    public void makeBaseMembers() {
        if (memberFacade.count() > 0) return;

        RsData<Member> systemMember = memberFacade.join("system", "1234", "시스템");
        RsData<Member> holdingMember = memberFacade.join("holding", "1234", "홀딩");
        RsData<Member> adminMember = memberFacade.join("admin", "1234", "관리자");
        RsData<Member> user1Member = memberFacade.join("user1", "1234", "유저1");
        RsData<Member> user2Member = memberFacade.join("user2", "1234", "유저2");
        RsData<Member> user3Member = memberFacade.join("user3", "1234", "유저3");

        log.debug(systemMember.getMsg());
        log.debug(holdingMember.getMsg());
        log.debug(adminMember.getMsg());
        log.debug(user1Member.getMsg());
        log.debug(user2Member.getMsg());
        log.debug(user3Member.getMsg());
    }
}
