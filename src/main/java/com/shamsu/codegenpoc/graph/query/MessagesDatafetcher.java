package com.shamsu.codegenpoc.graph.query;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.shamsu.codegenpoc.graph.schema.Message;
import graphql.relay.SimpleListConnection;
import graphql.schema.DataFetchingEnvironment;

@DgsComponent
public class MessagesDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "messages"
  )
  public SimpleListConnection<Message> getMessages(
      DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
