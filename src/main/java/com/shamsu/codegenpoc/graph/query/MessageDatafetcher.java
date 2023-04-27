package com.shamsu.codegenpoc.graph.query;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.shamsu.codegenpoc.graph.schema.Message;
import graphql.schema.DataFetchingEnvironment;

@DgsComponent
public class MessageDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "message"
  )
  public Message getMessage(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
