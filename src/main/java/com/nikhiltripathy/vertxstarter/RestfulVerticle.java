package com.nikhiltripathy.vertxstarter;

import com.nikhiltripathy.model.Person;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class RestfulVerticle extends AbstractVerticle {
	
	@Override
	public void start(Promise<Void> promise) {
		
		Router router = Router.router(vertx);
		router.get("/persons/person/:id")
		.handler(this::getPerson);
		
		vertx.createHttpServer()
		 .requestHandler(router)
		 .listen(config().getInteger("http.port",8080), result ->{
			 if(result.succeeded())
				 promise.complete();
			 else
				 promise.fail(result.cause());
		 });
	}
	
	public void getPerson(RoutingContext routingctx) {
		String name = routingctx.request()
						.getParam("id");
		
		
		Person person = new Person(name, "12", "Africa");
		
		routingctx.response()
		.putHeader("content-type", "application/json")
		.setStatusCode(200)
		.end(Json.encodePrettily(person));
	}

}
