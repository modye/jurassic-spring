package bzh.jurassic.spring.interfaces;

import org.springframework.stereotype.Component;

@Component
public class DinosFeederServiceImpl implements DinosFeederService {
    private final DinosaurLoader dinosaurLoader;

    public DinosFeederServiceImpl(DinosaurLoader dinosaurLoader) {
        this.dinosaurLoader = dinosaurLoader;
    }

    @Override
    public void feed(String name) {
        Integer needFeed = dinosaurLoader.getDinosaurs().get(name);
        dinosaurLoader.setMaxStock(needFeed);
    }
}
