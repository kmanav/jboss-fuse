package com.redhat.training.jb421;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

public class EnrichRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		 
		//TODO use jpa consumer
		from("jpa:com.redhat.training.jb421.model.Order?persistenceUnit=oracle"
				+ "&consumeDelete=false"
				+ "&consumer.namedQuery=getUndeliveredOrders"
				+ "&maximumResults=1"
				+ "&consumer.delay=30000"
				+ "&consumeLockEntity=false")
		//from("mock:start")
		//TODO add wiretap
		.wireTap("direct:updateOrder")
		
		//TODO add enrich call
		.enrich("direct:enrichOrder")
		.log("Order sent to fulfillment: ${body}")
		.to("mock:fulfillmentSystem");
		
		//TODO add direct: enrichOrder route
		from("direct:enrichOrder")
		.process(new OrderFulfillmentProcessor());
		
		//TODO add direct: updateOrder route
		from("direct:updateOrder")
		.onException(Exception.class).maximumRedeliveries(1).end()
		.marshal().json(JsonLibrary.Jackson)
		.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
		.log("The body after marshal: ${body}");
		//.to("http://localhost:8080/bookstore/rest/order/fulfillOrder/");
		
	}
}
