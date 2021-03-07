package com.nikhiltripathy.vertxstarter;

import io.vertx.core.Vertx;

public class DeployVerticle {
	public static void main(String...strings ) {
		Vertx vertx = Vertx.vertx();
		
		vertx.deployVerticle(new RestfulVerticle());
		
	}
}
