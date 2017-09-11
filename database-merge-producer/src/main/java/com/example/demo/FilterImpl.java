package com.example.demo;

import com.couchbase.client.core.message.dcp.MutationMessage;
import com.couchbase.client.core.message.dcp.RemoveMessage;
import com.couchbase.kafka.DCPEvent;
import com.couchbase.kafka.filter.Filter;

public class FilterImpl implements Filter {
    @Override
    public boolean pass(DCPEvent dcpEvent) {
        return   dcpEvent.message() instanceof MutationMessage ;//|| dcpEvent.message() instanceof RemoveMessage;
    }
}
