package id.cius.app.api;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.cius.app.service.MetaQueryService;

@RestController
@RequestMapping("/meta")
public class MetaFilmApi {

    @Autowired
    private MetaQueryService metaQueryService;

    
    Logger logger = org.apache.logging.log4j.LogManager.getLogger(MetaFilmApi.class);

   
}
