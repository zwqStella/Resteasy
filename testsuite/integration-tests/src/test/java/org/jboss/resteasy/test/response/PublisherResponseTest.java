package org.jboss.resteasy.test.response;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.sse.SseEventSource;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.resteasy.test.response.resource.PublisherResponseMessageBodyWriter;
import org.jboss.resteasy.test.response.resource.PublisherResponseResource;
import org.jboss.resteasy.test.response.resource.PublisherResponseTestClass;
import org.jboss.resteasy.utils.PortProviderUtil;
import org.jboss.resteasy.utils.TestUtil;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @tpSubChapter Publisher response type
 * @tpChapter Integration tests
 * @tpSince RESTEasy 4.0
 */
@RunWith(Arquillian.class)
@RunAsClient
public class PublisherResponseTest {

   static Client client;

   @Deployment
   public static Archive<?> deploy() {
      WebArchive war = TestUtil.prepareArchive(PublisherResponseTest.class.getSimpleName());
      war.addClass(PublisherResponseTestClass.class);
      war.addAsLibrary(TestUtil.resolveDependency("io.reactivex.rxjava2:rxjava:2.1.3"));
      return TestUtil.finishContainerPrepare(war, null, PublisherResponseMessageBodyWriter.class, PublisherResponseResource.class);
   }

   private String generateURL(String path) {
      return PortProviderUtil.generateURL(path, PublisherResponseTest.class.getSimpleName());
   }

   @BeforeClass
   public static void setup() {
      client = ClientBuilder.newClient();
   }

   @AfterClass
   public static void close() {
      client.close();
      client = null;
   }

   /**
    * @tpTestDetails Resource method returns Publisher<String>.
    * @tpSince RESTEasy 4.0
    */
   @Test
   public void testText() throws Exception
   {
      Invocation.Builder request = client.target(generateURL("/text")).request();
      Response response = request.get();
      String entity = response.readEntity(String.class);
      System.out.println("STEF: "+entity);
      Assert.assertEquals(200, response.getStatus());
      Assert.assertEquals("[\"one\",\"two\"]", entity);
   }

   /**
    * @tpTestDetails Resource method returns Publisher<String>.
    * @tpSince RESTEasy 4.0
    */
   @Test
   public void testChunked() throws Exception
   {
      Invocation.Builder request = client.target(generateURL("/chunked")).request();
      Response response = request.get();
      String entity = response.readEntity(String.class);
      System.out.println("STEF2: "+entity);
      Assert.assertEquals(200, response.getStatus());
      Assert.assertEquals("onetwo", entity);
   }

   /**
    * @tpTestDetails Resource method returns Publisher<String>.
    * @tpSince RESTEasy 4.0
    */
   @Test
   public void testSse() throws Exception
   {
      WebTarget target = client.target(generateURL("/sse"));
      List<String> collector = new ArrayList<>();
      List<Throwable> errors = new ArrayList<>();
      CompletableFuture<Void> future = new CompletableFuture<Void>();
      SseEventSource source = SseEventSource.target(target).build();
      source.register(evt -> {
    	  String data = evt.readData(String.class);
    	  collector.add(data);
    	  if(collector.size() >= 2) {
    		  future.complete(null);
    	  }
      }, 
    		  t -> {
    			  t.printStackTrace();
    			  errors.add(t);  
    		  }, 
    		  () -> {
    			  // bah, never called
    			  future.complete(null);
    		  });
      source.open();
      future.get();
      Assert.assertEquals(2, collector.size());
      Assert.assertEquals(0, errors.size());
      Assert.assertEquals("one", collector.get(0));
      Assert.assertEquals("two", collector.get(1));
   }
}