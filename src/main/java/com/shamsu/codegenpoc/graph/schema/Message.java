package com.shamsu.codegenpoc.graph.schema;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class Message {
  private String id;

  private String name;

  private String content;

  public Message() {
  }

  public Message(String id, String name, String content) {
    this.id = id;
    this.name = name;
    this.content = content;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return "Message{" + "id='" + id + "'," +"name='" + name + "'," +"content='" + content + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message that = (Message) o;
        return java.util.Objects.equals(id, that.id) &&
                            java.util.Objects.equals(name, that.name) &&
                            java.util.Objects.equals(content, that.content);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, name, content);
  }

  public static Message.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String id;

    private String name;

    private String content;

    public Message build() {
                  Message result = new Message();
                      result.id = this.id;
          result.name = this.name;
          result.content = this.content;
                      return result;
    }

    public Message.Builder id(String id) {
      this.id = id;
      return this;
    }

    public Message.Builder name(String name) {
      this.name = name;
      return this;
    }

    public Message.Builder content(String content) {
      this.content = content;
      return this;
    }
  }
}
