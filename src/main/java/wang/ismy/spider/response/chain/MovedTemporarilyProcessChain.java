package wang.ismy.spider.response.chain;

import wang.ismy.spider.Spider;
import wang.ismy.spider.request.Request;
import wang.ismy.spider.response.Response;
import wang.ismy.spider.response.ResponseProcessChain;

/*
* 如果一个响应的状态码为302，那么该处理链会处理它的重定向
*/
public class MovedTemporarilyProcessChain implements ResponseProcessChain {
    @Override
    public void process(Request request, Response response, Spider spider) {

        if (response.getHttpCode() == 302){
            String newLocation = response.getResponseHeaders().get("Location").get(0);
            request.setUrl(newLocation);
            spider.request(request, response::copy,false);

        }
    }
}
