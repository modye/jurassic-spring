package bzh.jurassic.spring.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/jurassic")
public class JurassicController {

    @GetMapping
    public ResponseEntity<String> graouuu() {
        return ResponseEntity.ok("\uD83E\uDD96 Graaaaaouuuuu le BreizhCamp !! \uD83E\uDD96");
    }
}
