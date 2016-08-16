package com.hello;

import io.moquette.interception.InterceptHandler;
import io.moquette.interception.messages.*;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.BoundRequestBuilder;
import org.asynchttpclient.DefaultAsyncHttpClient;

public class WebHookHandler implements InterceptHandler {
  private AsyncHttpClient asyncHttpClient;
  private String url;
  private String token;

  public WebHookHandler(String url, String token) {
    this.asyncHttpClient = new DefaultAsyncHttpClient();
    this.url = url;
    this.token = token;
  }

  @Override
  public void onConnect(InterceptConnectMessage interceptConnectMessage) {
    final String payload = "onConnect: " + interceptConnectMessage.getClientID();
    System.out.println(payload);
    forwardWebHook(payload);
  }

  @Override
  public void onDisconnect(InterceptDisconnectMessage interceptDisconnectMessage) {
    final String payload = "onDisconnect: " + interceptDisconnectMessage.getClientID();
    System.out.println(payload);
    forwardWebHook(payload);
  }

  @Override
  public void onPublish(InterceptPublishMessage interceptPublishMessage) {
    final String payload = "onPublish: " + interceptPublishMessage.getTopicName();
    System.out.println(payload);
    forwardWebHook(payload);
  }

  @Override
  public void onSubscribe(InterceptSubscribeMessage interceptSubscribeMessage) {
    final String payload = "onSubscribe: " + interceptSubscribeMessage.getTopicFilter();
    System.out.println(payload);
    forwardWebHook(payload);
  }

  @Override
  public void onUnsubscribe(InterceptUnsubscribeMessage interceptUnsubscribeMessage) {
    final String payload = "onUnsubscribe: " + interceptUnsubscribeMessage.getTopicFilter();
    System.out.println(payload);
    forwardWebHook(payload);
  }

  private void forwardWebHook(String payload) {
    final BoundRequestBuilder builder = asyncHttpClient.preparePost(url);
    builder.addFormParam("token", token);
    builder.addFormParam("payload", payload);
    builder.execute();
  }
}
