package tn.esprit.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class Filter extends AbstractGatewayFilterFactory<Filter.Config> {

    private static final Logger logger = LoggerFactory.getLogger(Filter.class);

    public Filter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            logger.info("Hello from gateway");
            return chain.filter(exchange);
        };
    }

    public static class Config {
        // No configuration properties needed for this filter
    }
}
