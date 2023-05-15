//package com.example.restfullPriject.waepon;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class WeaponConfig {
//    @Bean
//    CommandLineRunner WeaponRunner(WeaponRepository repository) {
//        return args -> {
//            Weapon glock = new Weapon(
//                    "glock",
//                    10,
//                    9
//            );
//            Weapon colt = new Weapon(
//                    "1911",
//                    13,
//                    10
//            );
//            Weapon beretta = new Weapon(
//                    "beretta",
//                    10,
//                    9
//            );
//            repository.saveAll(List.of(glock, colt,beretta));
//        };
//    }
//}
