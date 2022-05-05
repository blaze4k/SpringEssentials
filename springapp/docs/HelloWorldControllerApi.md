# HelloWorldControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**hello**](HelloWorldControllerApi.md#hello) | **GET** /hello/hello | This is a operation code doc.
[**helloCombinded**](HelloWorldControllerApi.md#helloCombinded) | **GET** /hello/combined/{name} | 
[**helloPath**](HelloWorldControllerApi.md#helloPath) | **GET** /hello/{name} | 
[**helloQuery**](HelloWorldControllerApi.md#helloQuery) | **GET** /hello/greeting | 

<a name="hello"></a>
# **hello**
> String hello()

This is a operation code doc.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.HelloWorldControllerApi;


HelloWorldControllerApi apiInstance = new HelloWorldControllerApi();
try {
    String result = apiInstance.hello();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling HelloWorldControllerApi#hello");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="helloCombinded"></a>
# **helloCombinded**
> String helloCombinded(name, greeting)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.HelloWorldControllerApi;


HelloWorldControllerApi apiInstance = new HelloWorldControllerApi();
String name = "name_example"; // String | 
String greeting = "greeting_example"; // String | 
try {
    String result = apiInstance.helloCombinded(name, greeting);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling HelloWorldControllerApi#helloCombinded");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**|  |
 **greeting** | **String**|  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="helloPath"></a>
# **helloPath**
> String helloPath(name)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.HelloWorldControllerApi;


HelloWorldControllerApi apiInstance = new HelloWorldControllerApi();
String name = "name_example"; // String | 
try {
    String result = apiInstance.helloPath(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling HelloWorldControllerApi#helloPath");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**|  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="helloQuery"></a>
# **helloQuery**
> String helloQuery(greeting)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.HelloWorldControllerApi;


HelloWorldControllerApi apiInstance = new HelloWorldControllerApi();
String greeting = "greeting_example"; // String | 
try {
    String result = apiInstance.helloQuery(greeting);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling HelloWorldControllerApi#helloQuery");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **greeting** | **String**|  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

