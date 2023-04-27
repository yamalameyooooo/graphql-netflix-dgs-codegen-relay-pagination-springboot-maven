package com.shamsu.codegenpoc.graph.query;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.shamsu.codegenpoc.graph.schema.Message;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;

@DgsComponent
public class MessageListDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "messageList"
  )
  public List<Message> getMessageList(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
