package bzh.jurassic.spring.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/jurassic")
public class JurassicController {

    private final DinosFeeder feeder;

    public JurassicController(DinosFeeder feeder) {
        this.feeder = feeder;
    }

    @GetMapping
    public ResponseEntity<String> graouuu() {
        return ResponseEntity.ok("\uD83E\uDD96 Graaaaaouuuuu le BreizhCamp !! \uD83E\uDD96");
    }

    @PostMapping("/feed")
    public ResponseEntity<String> feed(@RequestBody String name) {
        feeder.feed(name);
        return ResponseEntity.ok("miam");
    }
}
