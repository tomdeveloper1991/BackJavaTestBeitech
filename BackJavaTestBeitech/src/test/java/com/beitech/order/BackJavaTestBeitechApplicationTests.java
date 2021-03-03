package com.beitech.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.beitech.order.api.OrderApi;

@SpringBootTest
@AutoConfigureMockMvc
class BackJavaTestBeitechApplicationTests {

	@Autowired
	private OrderApi orderApi;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void contextLoads() throws Exception{
		assertThat(orderApi).isNotNull();
	}
	
	@Test
	public void testGetOrdersByCustomerAndDateIsOk() throws Exception{
		String uri="/getOrdersByCustomerAndDate";
		Integer customerId=1;
		String stringDateStart="20190131";
		String stringDateEnd="20201231";
		this.mockMvc.perform(get(uri+"/"+customerId+"/"+stringDateStart+"/"+stringDateEnd)).andExpect(status().isOk())
		.andExpect(content().string(containsString("orderId")));
	}
	
	@Test
	public void testGetOrdersByCustomerAndDateParseIsError() throws Exception{			
		this.mockMvc.perform(get("/getOrdersByCustomerAndDate/1/X20200101/20200431")).andExpect(status().isInternalServerError())
		.andExpect(content().string(containsString("Unparseable date")));
	}
	
	
	@Test
	public void testCreateOrderIsOk() throws Exception{			
		String uri="/createOrder";		
				
		String jsonRequest ="{\n"+
							    " \"creationDate\" : \"20210602\" ,\n"+
							    " \"customerId\": 1 ,\n"+
							    " \"deliveryAddress\": \"Avenida Siempre viva 123\", \n"+
							    " \"products\": [ \n"+
							        "{\n"+
							            " \"productId\": 10,\n"+
							            "\"productDescription\": \"Sin cubiertos ni servilletas\",\n"+
							            "\"quantity\": 3 \n"+
							        "},\n"+
							        "{ \n"+
							           " \"productId\": 15, \n"+
							           " \"productDescription\": \"Sin salsas\",\n"+
							           " \"quantity\": 1\n"+
							        "},\n"+
							        "{\n"+
							           " \"productId\": 16, \n"+
							           " \"productDescription\": \"Sin Azucar\", \n"+
							           " \"quantity\": 1 \n"+
							        "}\n"+
							    "]\n"+
							"}\n";
				
		
		this.mockMvc.perform(post(uri)
							.contentType(MediaType.APPLICATION_JSON)
							.content(jsonRequest)).andExpect(status().isOk())
							.andExpect(content().string(containsString("orderId")));			
	}
	
	@Test
	public void testCreateOrderIsCustomerDoesNotExists() throws Exception{			
		String uri="/createOrder";		
				
		String jsonRequest ="{\n"+
							    " \"creationDate\" : \"20210602\" ,\n"+
							    " \"customerId\": 19999 ,\n"+
							    " \"deliveryAddress\": \"Avenida Siempre viva 123\", \n"+
							    " \"products\": [ \n"+
							        "{\n"+
							            " \"productId\": 10,\n"+
							            "\"productDescription\": \"Sin cubiertos ni servilletas\",\n"+
							            "\"quantity\": 3 \n"+
							        "},\n"+
							        "{ \n"+
							           " \"productId\": 15, \n"+
							           " \"productDescription\": \"Sin salsas\",\n"+
							           " \"quantity\": 1\n"+
							        "},\n"+
							        "{\n"+
							           " \"productId\": 16, \n"+
							           " \"productDescription\": \"Sin Azucar\", \n"+
							           " \"quantity\": 1 \n"+
							        "}\n"+
							    "]\n"+
							"}\n";
				
		
		this.mockMvc.perform(post(uri)
							.contentType(MediaType.APPLICATION_JSON)
							.content(jsonRequest)).andExpect(status().isInternalServerError())
							.andExpect(content().string(containsString("Customer does not exists")));
	}
	
	@Test
	public void testCreateOrderIsProductsQuantity() throws Exception{			
		String uri="/createOrder";		
				
		String jsonRequest ="{\n"+
							    " \"creationDate\" : \"20210602\" ,\n"+
							    " \"customerId\": 1 ,\n"+
							    " \"deliveryAddress\": \"Avenida Siempre viva 123\", \n"+
							    " \"products\": [ \n"+
							        "{\n"+
							            " \"productId\": 10,\n"+
							            "\"productDescription\": \"Sin cubiertos ni servilletas\",\n"+
							            "\"quantity\": 3 \n"+
							        "},\n"+
							        "{ \n"+
							           " \"productId\": 15, \n"+
							           " \"productDescription\": \"Sin salsas\",\n"+
							           " \"quantity\": 6\n"+
							        "},\n"+
							        "{\n"+
							           " \"productId\": 16, \n"+
							           " \"productDescription\": \"Sin Azucar\", \n"+
							           " \"quantity\": 1 \n"+
							        "}\n"+
							    "]\n"+
							"}\n";
				
		
		this.mockMvc.perform(post(uri)
							.contentType(MediaType.APPLICATION_JSON)
							.content(jsonRequest)).andExpect(status().isInternalServerError())
							.andExpect(content().string(containsString("The order cannot have more than 5 products")));
	}
	
	@Test
	public void testCreateOrderIsErrorProductId() throws Exception{			
		String uri="/createOrder";		
				
		String jsonRequest ="{\n"+
							    " \"creationDate\" : \"20210602\" ,\n"+
							    " \"customerId\": 1 ,\n"+
							    " \"deliveryAddress\": \"Avenida Siempre viva 123\", \n"+
							    " \"products\": [ \n"+
							        "{\n"+
							            " \"productId\": 1,\n"+
							            "\"productDescription\": \"Sin cubiertos ni servilletas\",\n"+
							            "\"quantity\": 3 \n"+
							        "},\n"+
							        "{ \n"+
							           " \"productId\": 15, \n"+
							           " \"productDescription\": \"Sin salsas\",\n"+
							           " \"quantity\": 6\n"+
							        "},\n"+
							        "{\n"+
							           " \"productId\": 16, \n"+
							           " \"productDescription\": \"Sin Azucar\", \n"+
							           " \"quantity\": 1 \n"+
							        "}\n"+
							    "]\n"+
							"}\n";
				
		
		this.mockMvc.perform(post(uri)
							.contentType(MediaType.APPLICATION_JSON)
							.content(jsonRequest)).andExpect(status().isInternalServerError())
							.andExpect(content().string(containsString("Product is not avaiable to the customer")));
	}
	
	

}
