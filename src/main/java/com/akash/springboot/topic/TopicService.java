package com.akash.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	
	private List<Topic> topics =  new ArrayList<>(Arrays.asList(
			new Topic("Spring","Spring Framework","Spring description"),
			new Topic("java","Core java","Spring description"),
			new Topic("java script","java script","Spring description"),
			new Topic("Swift","Ios mobile","Spring description")
			));
	
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
}
