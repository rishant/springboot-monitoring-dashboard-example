package com.example.springboot.endpoint;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "release-notes")
public class CustomActuatorReleaseNotesEndpoint {
	
	Map<String, List<String>> releaseNoteMap = new HashMap<>();

	@PostConstruct
	public void initNotes() {
		releaseNoteMap.put("version-1.0", Arrays.asList("Home page created", "Adding a new item from product added"));
		releaseNoteMap.put("version-1.1", Arrays.asList("Reading from OMDb API added"));
	}
	
	@ReadOperation
	public Map<String, List<String>> releaseNotes() {
		return releaseNoteMap;
	}

}
