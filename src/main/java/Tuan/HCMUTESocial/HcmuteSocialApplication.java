package Tuan.HCMUTESocial;

import org.apache.coyote.http11.Http11InputBuffer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HcmuteSocialApplication {

	public static void main(String[] args) {
		SpringApplication.run(HcmuteSocialApplication.class, args);
	}
	@RequestMapping(value="/")
	public ResponseEntity<String> hello() {
		return new ResponseEntity<>("Hello world", HttpStatus.OK);
	}
}
