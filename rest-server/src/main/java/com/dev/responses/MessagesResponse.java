package com.dev.responses;

import com.dev.models.MessagesModel;
import com.dev.objects.Messages;

import java.util.ArrayList;
import java.util.List;

public class MessagesResponse extends BasicRespons{
    private List<MessagesModel> messagesList;

    public MessagesResponse(List<Messages> messages) {
       this.setSuccess(true);
       this.setErrorCode(null);
       this.messagesList = new ArrayList<>();
       for(Messages message: messages){
           messagesList.add(new MessagesModel(message));
       }
    }

    public List<MessagesModel> getMessagesList() {
        return messagesList;
    }

    public void setMessagesList(List<MessagesModel> messagesList) {
        this.messagesList = messagesList;
    }
}
