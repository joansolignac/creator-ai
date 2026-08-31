package com.ggilos.creatorai.modules.chat.entity;

import com.ggilos.creatorai.common.model.AuditableEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "chats")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@ToString
public class Chat extends AuditableEntity {
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Setter
    @Column(nullable = false, length = 255)
    private String title;

    @Setter
    @Column(nullable = false)
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private ChatStatus status = ChatStatus.AWAITING_TOPIC;
}
