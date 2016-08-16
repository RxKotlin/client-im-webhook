package com.hello;

import io.moquette.interception.InterceptHandler;
import io.moquette.interception.messages.*;
import io.moquette.server.Server;
import io.moquette.server.config.ClasspathConfig;
import io.moquette.server.config.IConfig;

import java.io.IOException;
import java.util.Arrays;

public class Hello {

  public static void main(String[] args) {
    System.out.println("localhost:1883 please");
    final Server server = new Server();
    final IConfig config = new ClasspathConfig();
    final InterceptHandler handler1 = new WebHookHandler("http://127.0.0.1:3000", "token1");
    final InterceptHandler handler2 = new WebHookHandler("http://127.0.0.1:3001", "token2");
    try {
      server.startServer(config, Arrays.asList(handler1, handler2));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
