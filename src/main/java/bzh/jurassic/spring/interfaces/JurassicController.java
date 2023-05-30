package bzh.jurassic.spring.interfaces;

import bzh.jurassic.spring.application.DinosLister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/jurassic")
public class JurassicController {

    // FIXME not so sure about that, found the answer on ChatGPT
    @Autowired
    private DinosLister dinosLister;

    @GetMapping
    public ResponseEntity<String> graouuu() {
        return ResponseEntity.ok("\uD83E\uDD96 Graaaaaouuuuu le BreizhCamp !! \uD83E\uDD96");
    }

    @GetMapping
    public ResponseEntity<List<String>> dinos() {
        return ResponseEntity.ok(dinosLister.findAllDinos());
    }
}
