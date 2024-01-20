package com.ssafy.msg.user.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "회원가입에 대한 요청 DTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpDto {
	
	@Schema(description = "닉네임", nullable = false, example = "홍길동")
	@NotEmpty(message = "닉네임을 입력해주세요.")
	@Pattern(regexp = "^[a-zA-Z0-9ㄱ-힣 ]{1,20}$", message = "닉네임은 1-20자의 영문, 한글, 숫자, 공백만 가능합니다.")
	private String nickname;
	
	@Schema(description = "이메일 아이디", nullable = false, example = "hong@gmail.com")
	@NotEmpty(message = "이메일을 입력해주세요.")
	@Pattern(regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "이메일 형식에 맞지 않습니다.")
	private String emailId;
	
	@Schema(description = "이메일 비밀번호", nullable = false, example = "Hong1234!")
	@NotEmpty(message = "비밀번호를 입력해주세요.")
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,20}$", message = "비밀번호는 8-20자의 영문 대소문자, 숫자, 특수문자로 구성되어야 합니다.")
	private String emailPassword;

}
