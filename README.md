# spring-boot-gcm

```xml
	<repositories>
		<repository>
			<id>spring-boot-gcm-mvn-repo</id>
			<url>https://raw.github.com/wonwoo/spring-boot-gcm/mvn-repo/</url>
		</repository>
	</repositories>
	
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-gcm</artifactId>
		<version>0.1.0-SNAPSHOT</version>
	</dependency>
```

## Sample

```java
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
public class DemoApplicationTests {

	private List<String> regIdList = new ArrayList<String>();

	@Before
	public void setup(){
		regIdList.add("insert regid");
		regIdList.add("insert regid");
		regIdList.add("insert regid");
	}

	@Autowired
	private PushSender pushSender;

	@Test
	public void sendMessage(){
		Message message = new Message.Builder()
			.addData("message", "d")
			.regIds(regIdList)
			.build();

		MulticastResult send = pushSender.send(message);
		assertEquals(send.getFailure(), 0);
		assertEquals(send.getSuccess(), 1);
		assertEquals(send.getTotal(), 1);
//		send.getCanonicalIds()
//		send.getMulticastId()
//		send.getRetryMulticastIds()
//		send.getResults()
	}
}
```
application.properties 
```
spring.push.gcm.key=API_KEY
```


## API

```java
  MulticastResult send(Message message);

  MulticastResult send(Message message, int retries);

  MulticastResult sendNoRetry(Message message);
```

## etc
1. limit 1000
2. apns not support
3. default retries 3
