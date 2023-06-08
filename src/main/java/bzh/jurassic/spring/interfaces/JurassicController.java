package bzh.jurassic.spring.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/jurassic")
public class JurassicController {

    private final DinosFeeder feeder;

    private final SingletonBean singletonBean;

    public JurassicController(DinosFeeder feeder, SingletonBean singletonBean) {
        this.feeder = feeder;
        this.singletonBean = singletonBean;
    }

    @GetMapping
    public ResponseEntity<String> graouuu() {
        return ResponseEntity.ok("\uD83E\uDD96 Graaaaaouuuuu le BreizhCamp !! \uD83E\uDD96");
    }

    @GetMapping("/toto")
    public ResponseEntity<String> toto() {
        singletonBean.titi();
        return ResponseEntity.ok("toto");
    }

    @PostMapping("/feed")
    public ResponseEntity<String> feed(@RequestBody String name) {
        feeder.feed(name);
        return ResponseEntity.ok("miam");
    }
}
