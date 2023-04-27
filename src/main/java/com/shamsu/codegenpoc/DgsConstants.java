package com.shamsu.codegenpoc;

import java.lang.String;

public class DgsConstants {
  public static final String QUERY_TYPE = "Query";

  public static class MESSAGE {
    public static final String TYPE_NAME = "Message";

    public static final String Id = "id";

    public static final String Name = "name";

    public static final String Content = "content";
  }

  public static class QUERY {
    public static final String TYPE_NAME = "Query";

    public static final String Message = "message";

    public static final String MessageList = "messageList";

    public static final String Messages = "messages";
  }

  public static class MESSAGEFILTER {
    public static final String TYPE_NAME = "MessageFilter";

    public static final String Ids = "ids";

    public static final String Names = "names";
  }
}
