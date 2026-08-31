package com.ggilos.creatorai.modules.chat.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ChatStatus {
    AWAITING_TOPIC("awaiting_topic"),
    AWAITING_ANSWERS("awaiting_answers"),
    AWAITING_TITLE_SELECTION("awaiting_title_selection"),
    COMPLETED("completed");

    private final String value;
}
