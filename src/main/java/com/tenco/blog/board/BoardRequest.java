package com.tenco.blog.board;

import com.tenco.blog.user.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

public class BoardRequest {

    // 게시글 저장 DTO
    @Data
    public static class SaveDTO {
        @NotEmpty(message = "제목은 공백일 수 없습니다")
        @Size(min = 1, max = 100, message = "제목은 1~100자 이내로 작성해주세요")
        private String title;

        @NotEmpty(message = "내용은 공백일 수 없습니다")
        @Size(min = 1, max = 5000, message = "내용은 1~5000자 이내로 작성해주세요")
        private String content;

        public Board toEntity(User user) {
            return Board.builder()
                    .title(this.title)
                    .user(user)
                    .content(this.content)
                    .build();
        }
    }

    // 게시글 수정용 DTO 설계
    @Data
    public static class UpdateDTO {
        @NotEmpty(message = "제목은 공백일 수 없습니다")
        @Size(min = 1, max = 100, message = "제목은 1~100자 이내로 작성해주세요")
        private String title;

        @NotEmpty(message = "내용은 공백일 수 없습니다")
        @Size(min = 1, max = 5000, message = "내용은 1~5000자 이내로 작성해주세요")
        private String content;
    }


}
