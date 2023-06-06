package bzh.jurassic.spring.interfaces;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DinosaurLoader {

    private final ObjectMapper objectMapper;

    private ConcurrentHashMap<String, Integer> dinosaurs = new ConcurrentHashMap<>();

    @Value("${max.stock}")
    private int maxStock;

    public DinosaurLoader(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    private void loadDinosaur() throws IOException {
        File file = new File(this.getClass().getClassLoader().getResource("data/dinosaur.json").getFile());
        List<Dinosaur> list = List.of(objectMapper.readValue(file, Dinosaur[].class));
        list.forEach(data -> dinosaurs.put(data.name, data.feed));
    }

    public ConcurrentHashMap<String, Integer> getDinosaurs() {
        return dinosaurs;
    }

    public int getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(int needFeed) {
        this.maxStock -= needFeed;
    }

    private static class Dinosaur {
        private String name;
        private int feed;

        public int getFeed() {
            return feed;
        }

        public String getName() {
            return name;
        }

        public void setFeed(int feed) {
            this.feed = feed;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}