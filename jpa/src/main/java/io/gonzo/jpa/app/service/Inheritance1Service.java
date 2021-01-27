package io.gonzo.jpa.app.service;

import io.gonzo.jpa.app.repository.inheritance1.Album1Repository;
import io.gonzo.jpa.app.repository.inheritance1.Book1Repository;
import io.gonzo.jpa.app.repository.inheritance1.Item1Repository;
import io.gonzo.jpa.app.repository.inheritance1.Movie1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Inheritance1Service {

    private final Item1Repository item1Repository;

    private final Book1Repository book1Repository;

    private final Album1Repository album1Repository;

    private final Movie1Repository movie1Repository;

    public void saveToBook(){

    }

}
