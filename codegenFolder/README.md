# restchat

OpenAPI definition
- API version: v0

No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)


*Automatically generated by the [Swagger Codegen](https://github.com/swagger-api/swagger-codegen)*


## Requirements

Building the API client library requires:
1. Java 1.7+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>de.vw</groupId>
  <artifactId>restchat</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "de.vw:restchat:1.0.0"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/restchat-1.0.0.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.ChatControllerApi;

import java.io.File;
import java.util.*;

public class ChatControllerApiExample {

    public static void main(String[] args) {
        
        ChatControllerApi apiInstance = new ChatControllerApi();
        try {
            Object result = apiInstance.getMessages();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ChatControllerApi#getMessages");
            e.printStackTrace();
        }
    }
}
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.ChatControllerApi;

import java.io.File;
import java.util.*;

public class ChatControllerApiExample {

    public static void main(String[] args) {
        
        ChatControllerApi apiInstance = new ChatControllerApi();
        String room = "room_example"; // String | 
        try {
            Object result = apiInstance.getMessagesByRoom(room);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ChatControllerApi#getMessagesByRoom");
            e.printStackTrace();
        }
    }
}
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.ChatControllerApi;

import java.io.File;
import java.util.*;

public class ChatControllerApiExample {

    public static void main(String[] args) {
        
        ChatControllerApi apiInstance = new ChatControllerApi();
        try {
            Long result = apiInstance.getMessagesCount();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ChatControllerApi#getMessagesCount");
            e.printStackTrace();
        }
    }
}
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.ChatControllerApi;

import java.io.File;
import java.util.*;

public class ChatControllerApiExample {

    public static void main(String[] args) {
        
        ChatControllerApi apiInstance = new ChatControllerApi();
        try {
            Object result = apiInstance.getRooms();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ChatControllerApi#getRooms");
            e.printStackTrace();
        }
    }
}
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.ChatControllerApi;

import java.io.File;
import java.util.*;

public class ChatControllerApiExample {

    public static void main(String[] args) {
        
        ChatControllerApi apiInstance = new ChatControllerApi();
        String sender = "sender_example"; // String | 
        String room = "room_example"; // String | 
        String message = "message_example"; // String | 
        try {
            Chat result = apiInstance.sendMessagesByRoom(sender, room, message);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ChatControllerApi#sendMessagesByRoom");
            e.printStackTrace();
        }
    }
}
```

## Documentation for API Endpoints

All URIs are relative to *http://localhost:8080*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ChatControllerApi* | [**getMessages**](docs/ChatControllerApi.md#getMessages) | **GET** /chat/messages | 
*ChatControllerApi* | [**getMessagesByRoom**](docs/ChatControllerApi.md#getMessagesByRoom) | **POST** /chat/messages/{room}/show | 
*ChatControllerApi* | [**getMessagesCount**](docs/ChatControllerApi.md#getMessagesCount) | **GET** /chat/messages/count | 
*ChatControllerApi* | [**getRooms**](docs/ChatControllerApi.md#getRooms) | **GET** /chat/rooms | 
*ChatControllerApi* | [**sendMessagesByRoom**](docs/ChatControllerApi.md#sendMessagesByRoom) | **POST** /chat/messages/{room}/send | 
*HelloWorldControllerApi* | [**hello**](docs/HelloWorldControllerApi.md#hello) | **GET** /hello/hello | This is a operation code doc.
*HelloWorldControllerApi* | [**helloCombinded**](docs/HelloWorldControllerApi.md#helloCombinded) | **GET** /hello/combined/{name} | 
*HelloWorldControllerApi* | [**helloPath**](docs/HelloWorldControllerApi.md#helloPath) | **GET** /hello/{name} | 
*HelloWorldControllerApi* | [**helloQuery**](docs/HelloWorldControllerApi.md#helloQuery) | **GET** /hello/greeting | 
*MailControllerApi* | [**mail**](docs/MailControllerApi.md#mail) | **POST** /mail/send | 
*UserControllerApi* | [**user**](docs/UserControllerApi.md#user) | **POST** /user/create | 

## Documentation for Models

 - [Chat](docs/Chat.md)
 - [Mail](docs/Mail.md)
 - [User](docs/User.md)

## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author


