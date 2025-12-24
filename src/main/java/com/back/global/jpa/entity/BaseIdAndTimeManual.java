package com.back.global.jpa.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public abstract class BaseIdAndTimeManual extends BaseEntity {
    @Id
    private int id;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
}
