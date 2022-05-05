# ChatControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMessages**](ChatControllerApi.md#getMessages) | **GET** /chat/messages | 
[**getMessagesByRoom**](ChatControllerApi.md#getMessagesByRoom) | **GET** /chat/messages/{room}/show | 
[**getMessagesCount**](ChatControllerApi.md#getMessagesCount) | **GET** /chat/messages/count | 
[**getRooms**](ChatControllerApi.md#getRooms) | **GET** /chat/rooms | 
[**sendMessagesByRoom**](ChatControllerApi.md#sendMessagesByRoom) | **POST** /chat/messages/{room}/send | 

<a name="getMessages"></a>
# **getMessages**
> List&lt;Chat&gt; getMessages()



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ChatControllerApi;


ChatControllerApi apiInstance = new ChatControllerApi();
try {
    List<Chat> result = apiInstance.getMessages();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ChatControllerApi#getMessages");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Chat&gt;**](Chat.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getMessagesByRoom"></a>
# **getMessagesByRoom**
> List&lt;Chat&gt; getMessagesByRoom(room)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ChatControllerApi;


ChatControllerApi apiInstance = new ChatControllerApi();
String room = "room_example"; // String | 
try {
    List<Chat> result = apiInstance.getMessagesByRoom(room);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ChatControllerApi#getMessagesByRoom");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **room** | **String**|  |

### Return type

[**List&lt;Chat&gt;**](Chat.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getMessagesCount"></a>
# **getMessagesCount**
> Long getMessagesCount()



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ChatControllerApi;


ChatControllerApi apiInstance = new ChatControllerApi();
try {
    Long result = apiInstance.getMessagesCount();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ChatControllerApi#getMessagesCount");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**Long**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getRooms"></a>
# **getRooms**
> List&lt;String&gt; getRooms()



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ChatControllerApi;


ChatControllerApi apiInstance = new ChatControllerApi();
try {
    List<String> result = apiInstance.getRooms();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ChatControllerApi#getRooms");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="sendMessagesByRoom"></a>
# **sendMessagesByRoom**
> Chat sendMessagesByRoom(sender, room, message)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ChatControllerApi;


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
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sender** | **String**|  |
 **room** | **String**|  |
 **message** | **String**|  |

### Return type

[**Chat**](Chat.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

