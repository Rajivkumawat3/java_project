package com.rajivcode.hello.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rajivcode.hello.models.Topic;

@Service
public class TopicService {
    

   private List<Topic> topics = new ArrayList<> (Arrays.asList(
             new Topic("spring","spring framework","have a nice day"),
             new Topic("java","java framework","have a nice day"),
             new Topic("javascript","javascript framework","have a nice day")
        ));

    public List<Topic> getAllTopics(){
         return topics;
    }

    public Topic getTopic(String id){
         return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic) {

        for(int i=0;i<topics.size();i++){
           
            Topic t=topics.get(i);
             
            if(t.getId().equals(id)){
                 topics.set(i,topic);
                 return;
            }
        }
    }

    public void deleteTopic(String id) {

        topics.removeIf(t -> t.getId().equals(id));
    }
}
