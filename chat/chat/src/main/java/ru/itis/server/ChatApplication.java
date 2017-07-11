package ru.itis.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import ru.itis.handlers.AuthHandler;

@SpringBootApplication
@ComponentScan("ru.itis.config")
@EnableTransactionManagement
public class ChatApplication extends SpringBootServletInitializer implements WebSocketConfigurer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		// конфигурирует статистику
		return application.sources(ChatApplication.class);
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(authHandler(), "/authHandler");
	}

	public WebSocketHandler authHandler(){
		return (WebSocketHandler) new AuthHandler();
	}
	public static void main(String[] args) {
		SpringApplication.run(ChatApplication.class, args);
	}
}
