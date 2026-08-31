package com.ggilos.creatorai.modules.chat.repository;

import com.ggilos.creatorai.modules.chat.entity.Chat;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChatRepository extends JpaRepository<Chat, UUID> {
    Slice<Chat> findByUserId(int userId, Pageable pageable);
}
