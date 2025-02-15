package se.mycompany.fin.track.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvConfig {
    private static final Dotenv dotenv = Dotenv.load();

    static {
        System.setProperty("TRUELAYER_CLIENT_ID", dotenv.get("TRUELAYER_CLIENT_ID"));
        System.setProperty("TRUELAYER_CLIENT_SECRET", dotenv.get("TRUELAYER_CLIENT_SECRET"));
        System.setProperty("TRUELAYER_REDIRECT_URI", dotenv.get("TRUELAYER_REDIRECT_URI"));
    }
}
