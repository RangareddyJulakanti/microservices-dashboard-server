/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package be.ordina.msdashboard.controllers;

import be.ordina.msdashboard.events.EventListener;
import be.ordina.msdashboard.events.SystemEvent;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author Andreas Evers
 */
@CrossOrigin(maxAge = 3600)
@RestController
@ResponseBody
public class EventsController {

    private EventListener eventListener;

    public EventsController(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    @RequestMapping(value = "/events", method = GET)
    public Collection<SystemEvent> getAllNodes() {
        return eventListener.getEvents();
    }

    @RequestMapping(value = "/events", method = DELETE)
    public void deleteAllNodes() {
        eventListener.deleteEvents();
    }
}
