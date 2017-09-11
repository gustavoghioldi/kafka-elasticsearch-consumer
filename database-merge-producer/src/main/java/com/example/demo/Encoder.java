package com.example.demo;

import com.couchbase.client.core.message.dcp.MutationMessage;
import com.couchbase.client.core.message.dcp.RemoveMessage;
import com.couchbase.client.deps.io.netty.util.CharsetUtil;
import com.couchbase.kafka.DCPEvent;
import com.couchbase.kafka.coder.AbstractEncoder;
import kafka.utils.VerifiableProperties;

public class Encoder extends AbstractEncoder {
    public Encoder(final VerifiableProperties properties) {
        super(properties);
    }

    @Override
    public byte[] toBytes(final DCPEvent dcpEvent) {
    	byte[] messageToPublic = null;
    	
    	if (dcpEvent.message() instanceof MutationMessage) {
        	 MutationMessage message = (MutationMessage)dcpEvent.message();
        	 messageToPublic=  message.content().toString(CharsetUtil.UTF_8).getBytes();
        	 System.out.println(messageToPublic);
         } 
         
         /*if (dcpEvent.message() instanceof RemoveMessage) {
        	 RemoveMessage message = (RemoveMessage)dcpEvent.message();
        	 messageToPublic=  message.key().getBytes();
          }*/ 
         
         return messageToPublic;
    }
}
