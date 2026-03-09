package org.example.dsm.domain.board.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardRequest {

    private String title;
    private String content;

}
