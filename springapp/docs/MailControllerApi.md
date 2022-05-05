# MailControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**mail**](MailControllerApi.md#mail) | **POST** /mail/send | 

<a name="mail"></a>
# **mail**
> Mail mail(body)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MailControllerApi;


MailControllerApi apiInstance = new MailControllerApi();
Mail body = new Mail(); // Mail | This is a RequestBody description.
try {
    Mail result = apiInstance.mail(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MailControllerApi#mail");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Mail**](Mail.md)| This is a RequestBody description. |

### Return type

[**Mail**](Mail.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

