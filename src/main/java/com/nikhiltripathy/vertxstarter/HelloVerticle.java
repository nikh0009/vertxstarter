package com.nikhiltripathy.vertxstarter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloVerticle extends AbstractVerticle {
	Logger logger = LoggerFactory.getLogger(HelloVerticle.class);
	Vertx vertx = Vertx.vertx();
	@Override
	public void start(Promise<Void> future) {
		logger.debug("Verticle started");
		vertx.createHttpServer()
			.requestHandler(r -> r.response().end("Welcome to Hello Verticle, once again"))
			.listen(config().getInteger("http.port",9090), 
					result -> {
						if (result.succeeded()) {
							future.complete();
							System.out.println("success");
						}
						else
							future.fail(result.cause());
					});
	}
	
	@Override
	public void stop() {
		System.out.println("Working on shutting down the verticle");
	}

}
