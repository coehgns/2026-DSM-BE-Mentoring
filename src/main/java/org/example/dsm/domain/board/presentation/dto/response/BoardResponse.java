package org.example.dsm.domain.board.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardResponse {

    private Long id;
    private String title;
    private String content;

}
