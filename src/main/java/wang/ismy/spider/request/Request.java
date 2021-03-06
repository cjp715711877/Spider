package wang.ismy.spider.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import wang.ismy.spider.enums.RequestMethods;

import java.util.HashMap;
import java.util.Map;


@Data
public class Request {

    private RequestMethods requestMethods = RequestMethods.GET;

    private String url;

    private Map<String,String> headers = new HashMap<>();

    private String body;

    public Request header(String key,String value){
        headers.put(key,value);
        return this;
    }

    public Request url(String url){
        this.url = url;
        return this;
    }

    public Request body(String body){
        this.body = body;
        return this;
    }

    public Request method(RequestMethods requestMethods){
        this.requestMethods = requestMethods;
        return this;
    }



}
