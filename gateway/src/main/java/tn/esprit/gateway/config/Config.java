package tn.esprit.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("events_route", r -> r.path("/api/events/**")
                        .uri("http://localhost:8082/api/events"))
                .route("transportation_route", r -> r.path("/api/transportations/**")
                        .uri("http://localhost:8090/api/transportations"))
                .route("reservation_route", r -> r.path("/api/reservations/**")
                        .uri("http://localhost:8081/reservations"))
                .route("forum_route", r -> r.path("/api/forum/**")
                        .uri("http://localhost:8086/api/forum"))
                .route("user_route", r -> r.path("/api/user/**")
                        .uri("http://localhost:8091/api/user"))
                .route("user_route", r -> r.path("/api/hebergement/**")
                        .uri("http://localhost:3000"))
                .build();
    }

}