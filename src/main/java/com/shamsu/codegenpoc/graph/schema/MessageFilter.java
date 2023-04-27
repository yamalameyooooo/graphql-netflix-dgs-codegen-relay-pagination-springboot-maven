package com.shamsu.codegenpoc.graph.schema;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

public class MessageFilter {
  /**
   * Filter products based on ID
   */
  private List<String> ids;

  /**
   * Filter products based on name
   */
  private List<String> names;

  public MessageFilter() {
  }

  public MessageFilter(List<String> ids, List<String> names) {
    this.ids = ids;
    this.names = names;
  }

  /**
   * Filter products based on ID
   */
  public List<String> getIds() {
    return ids;
  }

  public void setIds(List<String> ids) {
    this.ids = ids;
  }

  /**
   * Filter products based on name
   */
  public List<String> getNames() {
    return names;
  }

  public void setNames(List<String> names) {
    this.names = names;
  }

  @Override
  public String toString() {
    return "MessageFilter{" + "ids='" + ids + "'," +"names='" + names + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageFilter that = (MessageFilter) o;
        return java.util.Objects.equals(ids, that.ids) &&
                            java.util.Objects.equals(names, that.names);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(ids, names);
  }

  public static MessageFilter.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    /**
     * Filter products based on ID
     */
    private List<String> ids;

    /**
     * Filter products based on name
     */
    private List<String> names;

    public MessageFilter build() {
                  MessageFilter result = new MessageFilter();
                      result.ids = this.ids;
          result.names = this.names;
                      return result;
    }

    /**
     * Filter products based on ID
     */
    public MessageFilter.Builder ids(List<String> ids) {
      this.ids = ids;
      return this;
    }

    /**
     * Filter products based on name
     */
    public MessageFilter.Builder names(List<String> names) {
      this.names = names;
      return this;
    }
  }
}
