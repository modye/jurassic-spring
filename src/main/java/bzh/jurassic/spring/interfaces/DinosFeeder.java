package bzh.jurassic.spring.interfaces;

import org.springframework.stereotype.Component;

@Component
public class DinosFeeder {

    private final DinosaurLoader dinosaurLoader;

    public DinosFeeder(DinosaurLoader dinosaurLoader) {
        this.dinosaurLoader = dinosaurLoader;
    }

    public void feed(String name) {
        Integer needFeed = dinosaurLoader.getDinosaurs().get(name);
        dinosaurLoader.setMaxStock(needFeed);
    }
}
