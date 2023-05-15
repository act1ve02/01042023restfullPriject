package com.example.restfullPriject.Player;


import com.example.restfullPriject.waepon.Weapon;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayerConfig {

    @Bean
    CommandLineRunner runner (PlayerRepository repository)  {
        return args -> {
            Player sanja = new Player(
                    "Sanja",
                    19,
                    100,
                    new Weapon(
                            "glock",
                            10,
                            9
                    )
            );
            Player oleg = new Player(
                    "Oleg",
                    15,
                    98,
                    new Weapon(
                            "1911",
                            15,
                            10
                    )
            );
            Player petja = new Player(
                    "Petr",
                    13,
                    90,
                    new Weapon(
                            "Beretta",
                            11,
                            9
                    )
            );
            repository.saveAll(List.of(sanja, oleg, petja));
        };
    }
}
